package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
	//멤버변수
	int turn = 1;
	boolean isMoney;
	int num;
	List<Player> playerList = new ArrayList<>(); 
	LandList l = new LandList();
	List<Land> landList = l.getLandList();
	Scanner scan = new Scanner(System.in);
	List<Player> isIsland = new ArrayList<>();
	
	//메서드
	// (메인)게임 스타터 : 플레이어 이름을 받음(객체 생성하여 리스트에 저장), 진행 순서를 정함
	public boolean gameStarter() {
		// 플레이어 수 받기
		System.out.print("플레이어 수: ");
		num = scan.nextInt();
		
		// 플레이어 이름 받기
		for(int i=0; i<num; i++) {
			System.out.print("플레이어" + (i+1) + "의 이름을 정해주세요: ");
			String name = scan.next();
			Player p = new Player(name, (i+1));
			playerList.add(p);
		}
		
		// 게임 진행 순서 결정
		System.out.println("\n게임 순서를 정하겠습니다.");
		Map<Player, Integer> seq = new HashMap<>();
		for(int i=0; i<num; i++) {
			System.out.print(playerList.get(i).getName() + "님주사위 굴리는중... ");
			int dice1 = roll();
			int dice2 = roll();			
			seq.put(playerList.get(i), dice1+dice2);
			System.out.println(dice1 + "+" + dice2 + ">> " + (dice1+dice2) + "!!");
		}
		
		playerList.clear();
		
		playerList = seq.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) 
				.map(Map.Entry::getKey) 
				.collect(Collectors.toList()); 
		
		// 준비 완료 + 출력
		System.out.println("\n게임 준비가 완료되었습니다.");
		System.out.println("[플레이어 리스트]");
		for (Player p : playerList) {
			System.out.println(p.toString());
		}	
		
		return true;
	}
	
	// (메인)게임 진행
	public void gamePlay() {
		while(turn != 50) {
			System.out.println("\n현재 턴수: " + turn);
			// 각각의 플레이어가 주사위를 굴림
			for(int i=0; i<num; i++) {
				System.out.print(playerList.get(i).getName() + "님 차례입니다! (아무거나입력)");
				
				// 플레이어의 위치가 무인도인지 검사
				if(isIsland.contains(playerList.get(i))) {
					System.out.println("무인도에서 나갈 수 없네용ㅋ\n");
					isIsland.remove(playerList.get(i));
					continue;
				}
				
				// 주사위 굴려서 칸 이동 + 한바퀴 돌았을 때 처리
				scan.next();
				System.out.println("주사위를 굴립니다...");
				int dice = roll();
				System.out.println(dice + "칸 이동합니다.");
				System.out.println();
				int position = playerList.get(i).getPlayerPo() + dice;
				playerList.get(i).setPlayerPo(position);
				if(position > 17) {
					eventStartPass(playerList.get(i));
				}
				
				// 이동한 위치의 땅의 타입을 가져와서 이벤트 발생
				gameEvent(playerList.get(i));
				System.out.println("------------------------------");
			}
			
			turn++;
		}
	}
	
	// (메인) 이벤트 발생 실행 메서드
	private void gameEvent(Player p) {
		int position = p.getPlayerPo();
		Land a = landList.get(position);
		String type= a.getLandType();
		switch(type) {
		case "출발지" : 
			eventStart(p);
			break;
		case "도시" :
			eventCity(p, position);
			break;
		case "무인도" :
			eventIsland(p);
			break;
		case "황금열쇠" :
			eventGoldenKey();
			break;
		case "세계여행" :
			eventTravel(p);
			break;
		case "사회복지기금" :
			eventFund(p);
			break;
		default : 
			System.out.println("error!!");
		}
		
	}
	
	// (기본)너 돈 낼 수 있니?
	public boolean isBankruptcy(Player p, int pay) {
		if(p.getMoney() < pay) {
			int total = 0;
			for(int i=0; i<landList.size(); i++) {
				if((landList.get(i).getHotel().getOwner()).equals(p.getName())) {
					total += landList.get(i).getHotel().getSale();
				}
			}
			
			if(total >= pay) {
				System.out.print("보유 자산이 부족합니다. 1.건물매각하기 2.파산하기");
				int op = scan.nextInt();
				
				switch(op) {
				case 1 : 
					System.out.println("건물의 매각 금액이 낮은 순서대로 차례로 매각합니다.");
					boolean a = setDisposal(p, pay);
					return a;
				case 2 : 
					setBankruptcy(p);
					return false;
				default : 
					return false;
				}
			}else {
				setBankruptcy(p);
				return false;
			}
			
		}else {
			return true;
		}
	}
	
	// (기본)매각처리
	public boolean setDisposal(Player p, int pay) {
		int money = p.getMoney();
		List<Land> copyList = landList.stream()
	            .filter(n -> n.getHotel().getOwner().equals(p.getName()))
	            .sorted((l1, l2) -> Integer.compare(l1.getHotel().getSale(), l2.getHotel().getSale())) // 정렬
	            .collect(Collectors.toList());		
		
		for(int i=0; i<copyList.size(); i++) {
			if(money < pay) {
				if(landList.size() == 0) {
					return false;
				}
				money += copyList.get(i).getHotel().getSale();
				landList.remove(copyList.get(i));
			}else {
				return true;
			}
		}
		return true;
	}
	
	// (기본)파산처리
	public void setBankruptcy(Player p) {
		for(int i=0; i<landList.size(); i++) {
			if((landList.get(i).getHotel().getOwner()).equals(p.getName())) {
				landList.get(i).toggleHotel();
				landList.get(i).getHotel().setOwner("");
			}
		}
		System.out.println(p.getName() + "님은 파산했습니다 :)");
		playerList.remove(p);
		System.out.println("남은 플레이어 수: " + playerList.size());
	}

	// (기본)주사위 굴리기
	public int roll() {
		return (int)(Math.random()*6)+1;
	}
	
	// (위치이동이벤트)출발지 이벤트
	private void eventStart(Player p) {
		// 출력문구
		System.out.println("출발지에 도착했습니다!");
		// 이벤트 내용 - 20만원 증정
		int money = p.getMoney();
		p.setMoney(money + 200000);
	}
	
	// (위치이동이벤트)출발지 경유!! 이벤트 - 출발지를 지나갈 때 돈 받는거
	private void eventStartPass(Player p) {
		// 출력문구
		System.out.println("한바퀴 돌았어요!");
		// 이벤트 내용 - 20만원 증정
		int position = p.getPlayerPo();
		p.setPlayerPo(position - 17);
		int money = p.getMoney();
		p.setMoney(money + 200000);
	}

	// (위치이동이벤트)도시 이벤트 *****
	private void eventCity(Player p, int position) {
		// 출력문구
		System.out.println(position + "에 도착했습니다!");
		// 이벤트 내용 - 1. 소유X 2. 소유O 
		// 1-1. 땅을 살 것인지 
		// 2-1. 내땅인지 아닌지 -> 내 땅이 아니라면 땅 주인에게 통행료 지불
		// 2-2. 인수하겠습니까?
	}

	// (위치이동이벤트)무인도 이벤트
	private void eventIsland(Player p) {
		// 출력문구
		System.out.println("이런, 무인도에 도착했습니다!");
		System.out.println("한 턴동안 움직일 수 없습니다!");
		// 이벤트 내용 
		isIsland.add(p);
	}

	// (위치이동이벤트)황금열쇠 이벤트 *****
	private void eventGoldenKey() {
		// 출력문구
		System.out.println("황금열쇠를 뽑을 수 있어요!");
		// 이벤트 내용 - 황금열쇠 뽑기
		
	}

	// (위치이동이벤트)세계여행 이벤트 *****
	private void eventTravel(Player p) {
		// 출력문구
		System.out.println("세계여행을 시작합니다!");
		// 이벤트 내용
		// (1) 여행지 입력받기
		int position = p.getPlayerPo(); // 객체의 위치
		int moving = 0; // 이동거리
		
		System.out.println("어디로 가시겠습니까?");
		String destination = scan.next();
		int dtNum = 0; // 도착 위치
		for(int i=0; i<landList.size(); i++) {
			if(landList.get(i).getLandName().equals(destination)) {
				dtNum = landList.get(i).getLandPo();
			}
		}
		
		// (2) 이동 거리 계산
		if(dtNum < position) {
			moving = 17 - position + dtNum;
		}else if(dtNum > position) {
			moving = dtNum - position;
		}
		
		// (3) 여행지 이동 - 출발지 경유 검사
		p.setPlayerPo(position + moving);
		if(p.getPlayerPo() > 17) {
			eventStartPass(p);
		}
		System.out.println();
		// (4) 이동한 여행지의 이벤트 발생
		gameEvent(p);
		
	}

	// (위치이동이벤트)사회복지기금 이벤트
	private void eventFund(Player p) {
		// 출력문구
		System.out.println("사회복지기금을 받을 수 있어요!");
		// 이벤트 내용
		int expense = 10000; // 뜯을 돈
		// (1) 땅을 밟은 사람 제외하고 돈 가져오기 - 파산 검사
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getName() != p.getName()) {
				playerList.get(i).setMoney(playerList.get(i).getMoney() - expense);
			}
		}
		
		p.setMoney(playerList.size()*expense);
	}

}
