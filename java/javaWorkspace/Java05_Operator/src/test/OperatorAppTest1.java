package test;
/*
 * ����� ��ġ�� ���� ��������.
 * 
 *        Field                   Local Variable
 * 1. Ŭ���� �ٷ� ��, �޼ҵ� �ٱ�          |     �޼ҵ� { ��
 * 2. ��ü�� ����̹Ƿ� �⺻���� �ִ�.  |   �⺻���� ����... �ݵ�� �ʱ�ȭ�ϰ� ��� �Ѵ�.
 * 3. JVM���� Heap �ȿ� ����             |   JVM���� Stack �ȿ� ����
 * 4. Member Variable         |      ��������, Temporary Variable, Automatically Variable  
 *     �ν��Ͻ� ����, ��ü ����
 *   (���� ����, Ŭ���� ������ �ٸ�)
 */
public class OperatorAppTest1 { // ���� �׽�Ʈ �̸��� Test�� �����ų� AppTest�� ����

	public static void main(String[] args) {
		// Local Variable ����... ���� �޼ҵ� �ȿ� �����.
		/*int i;
		int j;*/ //�̷��� ���� �������. �ݵ�� �ʱ�ȭ�ؾ� ��
		int i = 5;
		int j = 3;
		
		Operator o1 = new Operator();
		Operator o2 = new Operator();
		
		System.out.println("o1 �ּҰ� : "+o1);
		System.out.println("o2 �ּҰ� : "+o2);
		
		o1 = o2; // �ּҰ��� o2�� ����������. �ּҰ��� �����ϴ� = ���� ��ü��. 
		// ���� : �޸� �׸����� �׸���
		
		System.out.println(o1==o2); // true
		
		System.out.println("������ % :: "+i % j); // 2 (% (modulous) ������)
		System.out.println(i==j); // false
		System.out.println(i!=j); // true
		
		boolean flag = false;
		System.out.println(flag); // false
		System.out.println(!flag); // ture // !=not
		
		int k = 10;
		System.out.println(k++); // ���߿� 1�� ����.... 10 // m-- ���߿� 1�� ����
		System.out.println(k); // ���⼭ 11�� �� �� Ȯ�� ����.
		
		int m = 10;
		System.out.println(++m); // ���� 1�� ����...11 // --m �� ���� 1�� ����
		
		System.out.println(o1.test1() || o1.test2()); // ||�� or ������. true
		// or ������ �� �� | �ᵵ ������ ||�� �� ���ɰ� ��Ȯ�� �鿡�� �� ȿ����. 
		// ||�� �� ������ true�� true�� �����ϰ� �� ���� �ǳʶ�
		System.out.println(o1.test1() && o1.test2()); // false 
		// ||�� �տ����� true�� �� ���ư���, &&�� �տ����� false�� �� ���ư�.
 	}

}

class Operator{ // class�� ���� �� ���޾Ƽ� ���� ���� public�� �� �ϳ��� class���� �ٿ��� ��.x
	// ���ÿ� �ٸ� class���� ���̸� ���� ��.
	// ���� �޼ҵ带 ������ �ִ� class �տ� public�� �ٿ��� ��.
	// �׸��� public���� ������ Ŭ���� �̸����� �����ؾ� ��.
	public boolean test1() {
		System.out.println("test1() call.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() call.....");
		return false;
	}
	
}