package day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exception05 {

	public static void main(String[] args) {
		// I/O Exception 발생 예제
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String name;
		try {
			//콘솔에서 입력 받아서 그걸 name에서 받아라.
			name = br.readLine();
			System.out.println(name);
			br.close();
			isr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
