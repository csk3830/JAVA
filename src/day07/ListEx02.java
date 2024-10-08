package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListEx02 {

	public static void main(String[] args) {
		// 두 배열을 하나의 리스트로 합치기
		// 정렬하여 출력 (오름, 내림차순 둘 다)
		
		// 직접 해당 값을 리스트로 올리기
		// Arrays.asList() : 배열 => 리스트
		// toArray() : 리스트 => 배열
		
		String arr1[] = {"a","g","f","h","c"};
		String arr2[] = {"b","t","s","p","n","m"};
	
		List<String> mergeList2 = Arrays.asList(arr1);
		System.out.println(mergeList2);
		// 배열과 list가 연결되어있는 상태 		추가 불가능 / 수정 가능
		// 리스트 == 배열 원본 배열 변경
//		mergeList2.add("z");
//		mergeList2.set(0, "z");
//		System.out.println(mergeList2);
		
		System.out.println("--new ArrayList arr1 -- ");
		List<String> mergeList3 = new ArrayList<String>(Arrays.asList(arr1));
		System.out.println(mergeList3);
		mergeList3.add("z");
		System.out.println(mergeList3);
		System.out.println("--new ArrayList arr2 -- ");
		List<String> mergeList4 = new ArrayList<String>(Arrays.asList(arr2));
		System.out.println(mergeList4);
		
		System.out.println("-- list addAll --");
		mergeList3.addAll(mergeList4);
		System.out.println(mergeList3);

		// List를 배열로 변환
		int listSize = mergeList3.size();
		System.out.println("---리스트를 배열로 변환--");
		String[] arr = mergeList3.toArray(new String[listSize]);
		System.out.println(Arrays.toString(arr));
		
		mergeList3.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(mergeList3);
		
		System.out.println("-- 손수 옮기기 -- ");
		List<String> mergeList = new ArrayList<String>();		
		
		int cnt = arr1.length + arr2.length;
		int i=0, j=0;
		while(cnt > mergeList.size()) {
			if(i<arr1.length) {
				mergeList.add(arr1[i]);
				i++;
			}
			if(j<arr2.length) {
				mergeList.add(arr2[j]);
				j++;
			}		
		}
		System.out.println(mergeList);
		
		
		
//		for(String a : arr1) {
//			mergeList.add(a);
//		}
//		
//		for(String a: arr2) {
//			mergeList.add(a);
//		}
//		
//		Collections.sort(mergeList);
//		System.out.println(mergeList);
//		
//		mergeList.sort(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});
//		System.out.println(mergeList);
		
	}

}
