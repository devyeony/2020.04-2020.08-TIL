package condition.test;

import java.util.Random;

/*
 * formating�� ���� ������
 */

public class ConditionTest6 {

	public static void main(String[] args) {
		String result = ""; // ���ú����� �⺻���� �����Ƿ� �̷��Զ� �ʱ�ȭ���Ѿ� ��.
		Random r = new Random(); // �̰ɷ� �ϸ� math.random()���� �� �����ϰ� �� �� ����.
		System.out.println("=======ū��? Ȥ�� ������?");
		// 0~99 ������ ������ ����
		int num1 = r.nextInt(100); // 100 ������ 99���� ��. 0~99���� ����.
		System.out.println(num1);
		
		if(num1>50) result="ū��";
		else if(num1==50) result="������";
		else result="������";
		
		System.out.println(num1+"�� 50�� ������ �� "+result+"�Դϴ�.");
		System.out.printf("%d��/�� %s�̴�%n", num1, result); // %d ������, %s string. %n=blank
		//println���� �� ��. printf���� ��. f=format. formating...
		
		int num2 = r.nextInt(10)+1; // 1~10���� ����.
		if(num2 % 2 ==0) result = "¦��";
		else result = "Ȧ��";
		System.out.printf("%d��(��) %s�̴�%n", num2, result);
		
		System.out.println("==========���� ������========");
		result = (num2 % 2 ==0)? "¦��" : "Ȧ��";
		System.out.printf("%d��(��) %s�̴�%n", num2, result);

	}

}