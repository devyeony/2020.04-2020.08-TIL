package self.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void main(String[] args) {
		for (int run = 0;;) {
			System.out.println("10~99 ������ ������ �Է��ϼ���>>>");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			// % , / �����ڸ� �̿�

			int start = n / 10;
			int end = n % 10;

			if (start == 3 || start == 6 || start == 9) { 
				// %3�� �̿��ؼ� ���ϸ� ���� �ڸ��� 0�� ������ ���ԵǹǷ� �� ��.
				if (end == 3 || end == 6 || end == 9) {
					System.out.println("@@");
					System.exit(0);
				} 
				else System.out.println("@");
			} 
			else if (end == 3 || end == 6 || end == 9) {
				System.out.println("@");
			} 
			else {
				System.out.println(n);
			}
		}

	}
}