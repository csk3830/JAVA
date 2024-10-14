package word;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordController {

	/* 단어장 프로그램
	 * Word class 생성
	 * - 넘버링, 단어, 뜻(list<String>)
	 * 1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.단어삭제|6.단어파일로출력|7.종료
	 * 6. - 내가 등록한 모든 단어를 메모장에 파일로 출력
	 * Word (equals 사용) : 단어가 같으면 같은 객체(2.검색, 5.삭제, 3.수정, 4.출력까지)
	 * */
	private int wordId;
	
	private List<Word> wordList = new ArrayList<>();
	
	public void addWord() {
		
		List<Word> addWordList = new ArrayList<>();

	    List<String> giftMeanings = new ArrayList<>();
	    giftMeanings.add("선물");
	    giftMeanings.add("재능");
	    addWordList.add(new Word(wordId++, "gift", giftMeanings));

	    List<String> capitalMeanings = new ArrayList<>();
	    capitalMeanings.add("자본");
	    capitalMeanings.add("자산");
	    capitalMeanings.add("자금");
	    capitalMeanings.add("수도");
	    addWordList.add(new Word(wordId++, "capital", capitalMeanings));

	    List<String> appleMeanings = new ArrayList<>();
	    appleMeanings.add("오른쪽");
	    appleMeanings.add("권리");
	    appleMeanings.add("올바른");
	    addWordList.add(new Word(wordId++, "right", appleMeanings));

	    List<String> bookMeanings = new ArrayList<>();
	    bookMeanings.add("경쟁");
	    bookMeanings.add("인종");
	    addWordList.add(new Word(wordId++, "race", bookMeanings));
	    
	    for (Word w : addWordList) {
	        wordList.add(w);
	    }
	}

	public void insertWord(Scanner scan) {
		System.out.print("등록할 단어를 입력하세요 > ");
	    String word = scan.next();

	    List<String> meanings = new ArrayList<>();
	    boolean isMore = true;

	    while (isMore) {
	        System.out.print("뜻을 입력하세요 > ");
	        String meaning = scan.next();
	        meanings.add(meaning);
	        
	        System.out.print("뜻을 더 등록하시겠습니까? (y/n) > ");
	       
	        String confirm = scan.next();
	        if (confirm.equals("n")) {
	        	isMore = false;
	        }
	    }

	    Word newWord = new Word(wordId++, word, meanings); 
	    newWord.setMeanings(meanings);
	    wordList.add(newWord);
	    System.out.println("단어가 등록되었습니다.");
	}

	public void searchWord(Scanner scan) {
		System.out.print("검색할 단어를 입력하세요 > ");
	    String search = scan.next();

	    boolean isSearch = false;

	    for (Word w : wordList) {
	        if (w.getWord().equals(search)) {
	            System.out.println(w.getWord()+":"+w.getMeanings());
	            isSearch = true; 
	            break; 
	        }
	    }

	    if (!isSearch) {
	        System.out.println("검색결과가 없습니다.");
	    }
		
	}

	public void modifyWord(Scanner scan) {
		System.out.println("수정할 단어를 검색하세요 > ");
		String search = scan.next();
		
		boolean isSearch = false;
		
		for (Word w : wordList) {
			if (w.getWord().equals(search)) {
				isSearch = true; 
				
				List<String> meanings = new ArrayList<>();
	            while (true) {
	            	System.out.print("수정할 뜻을 입력하세요 > ");
	                String meaning = scan.next();
	                meanings.add(meaning);

	                System.out.print("뜻을 더 등록하시겠습니까? (y/n) > ");
	                String confirm = scan.next();
	                if (confirm.equals("n")) {
	                    break;
	                }
	            }
	            
	            w.setMeanings(meanings);
	            System.out.println("수정되었습니다.");
	            break; 
	        }
		}

	    if (!isSearch) {
	        System.out.println("검색결과가 없습니다.");
	    }
	}

	public void printWord() {
		System.out.println("--단어장--");
		for(Word w : wordList) {
			System.out.println(w);
		}
		
	}

	public void removeWord(Scanner scan) {
		System.out.println("삭제할 단어를 검색하세요 > ");
	    String search = scan.next();

	    boolean isRemove = false;

	    for (int i=0; i<wordList.size(); i++) {
	        if (wordList.get(i).getWord().equals(search)) {
	            wordList.remove(i); 
	            System.out.println("삭제되었습니다.");
	            isRemove = true; 
	            break; 
	        }
	    }

	    if (!isRemove) {
	        System.out.println("검색결과가 없습니다.");
	    }
	}

	public void fileWord() {
		FileWriter fw;
		try {
			fw = new FileWriter("word.txt");
			for (Word w : wordList) {
				fw.write(w.getWord() + ":" + w.getMeanings() + "\r\n");
			}
			fw.close();
			System.out.println("메모장에 파일(word.txt)로 출력하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}	    
	    
		
	}
	
	
}
