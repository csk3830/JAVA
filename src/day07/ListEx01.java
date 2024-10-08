package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListEx01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list를 생성 (String)
		 * 출력 일반 for / 향상된 for / Iterator 출력
		 * import 단축키 : ctrl + shift + o
		 * */
		
		List<String> dayScheduleList = new ArrayList<String>();
		dayScheduleList.add("물마시기");
		dayScheduleList.add("명상");
		dayScheduleList.add("씻기");
		dayScheduleList.add("아침 먹기");
		dayScheduleList.add("공부 하기");
		dayScheduleList.add("명상");
		dayScheduleList.add("점심 먹기");
		dayScheduleList.add("명상");
		
		System.out.println("-- 일반 for --");
		for(int i=0; i<dayScheduleList.size(); i++) {
			System.out.println(dayScheduleList.get(i));
		}
		
		System.out.println("-- 향상된 for --");
		for(String a : dayScheduleList) {
			System.out.println(a);
		}
		
		System.out.println("-- Iterator --");
		Iterator<String> it = dayScheduleList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//정렬 list.sort(Comparator 구현체);
		System.out.println("-- 정렬 --");
		// 오름차순
		Collections.sort(dayScheduleList);
		System.out.println(dayScheduleList);
		
		dayScheduleList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// compareTo
				// 사전순으로 앞에 있으면 -	같으면 0	뒤에 있으면 +
				// o1.compareTo(o2) : 오름차순
				return o2.compareTo(o1);	//내림차순
			}
		});
		System.out.println(dayScheduleList);
		
		// remove()는 같은 Object가 2개 이상이더라도 앞에있는 하나만 삭제
		// 여러개 삭제하는 법
		List<String> ex = new ArrayList<String>();
		ex.add("명상");
		dayScheduleList.removeAll(ex);
		System.out.println(dayScheduleList);
		
	}

}
