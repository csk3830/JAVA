package day07;

import java.util.ArrayList;
import java.util.List;

public class ListEx03 {

	public static void main(String[] args) {
		/* num의 값을 숫자 List를 생성하여 추가 => 출력
		 * 합계를 출력
		 * 70점 이상인 인원 수 출력
		 * 3/8명
		 * */
		String num = "45,78,98,65,84,52,64,31";
		String[] arr = num.split(",");
        int sum=0;
        int pass=0;
		
		List<Integer> list = new ArrayList<>();

        for(String s:arr) {
        	list.add(Integer.parseInt(s));
        }
        
        for(int i:list) {
        	sum+=i;
        }
        System.out.println("합계:"+sum);
        for(int i:list) {
        	if(i>=70) {
        		pass++;
        	}
        }
        System.out.println("70점 이상인 인원 수:"+pass+"/"+list.size());
		
	}

}
