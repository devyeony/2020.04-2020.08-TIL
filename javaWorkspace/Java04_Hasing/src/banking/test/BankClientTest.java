package banking.test;

import banking.Account;
import banking.Customer;

public class BankClientTest {

	public static void main(String[] args) {
		/*
		 * james��� �̸��� ������ ����... �ֹι�ȣ�� 1234
		 * james�� �ܾ� 10000���� ���� ���¸� �ϳ� ����
		 * ���� ���� ���¸� ���ؼ� 
		 * 5000��, 12000���� �Ա�
		 * 7000���� ���
		 * ���������� James ������ �ܾ��� ���
		 */
		Customer custom1 = new Customer("James", 1234);
		custom1.setAccount(new Account(10000));
		
		Account james=custom1.getAccount();
		System.out.println("5000���� �Ա��մϴ�...");
		james.deposit(5000.0);
		
		System.out.println("12000���� �Ա��մϴ�...");
		james.deposit(12000.0);
		
		System.out.println("7000���� ����մϴ�...");
		james.withdraw(7000.0);
		
		/*
		Customer james = new Customer("James", 1234);
		Account account = new Account(10000);
		System.out.println(james.getCustInfo());
		System.out.println(account.getBalance());
		account.deposit(5000);
		System.out.println(account.getBalance());
		account.deposit(12000);
		System.out.println(account.getBalance());
		account.withdraw(7000);
		System.out.println(account.getBalance());
		*/
	}

}