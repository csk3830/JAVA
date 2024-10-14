package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class File05 {

	public static void main(String[] args) throws IOException {
		// test.txt 파일을 읽어들여 map에 저장
		// 명단, 합계, 평균 출력
		// 읽어 들이는 파일은 모두 String
		// 계산을 위해서는 int로 변환이 필요
		// Integer.parseInt();
		// 80점 이상인 학생 명단
		
		Map<String, Integer> map = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			
			String name = line.split(" ")[0];
			int age = Integer.parseInt(line.split(" ")[1]);
			map.put(name, age);
		}
		br.close();
		
		
		int sum = 0;
		double avg;
		List<String> pass = new ArrayList<String>();
		
		for(String key : map.keySet()) {
			int value = map.get(key);
			sum+=value;
			
			if(value>=80) {
				pass.add(key);
			}
			System.out.println(key+":"+value);
		}
		
		avg = sum / (double)map.size();
		
		System.out.println("합계:"+sum+"/"+"평균:"+avg);
		System.out.println("--80점 이상--");
		for(String s : pass) {
			System.out.println(s);
		}
		
	}

}
