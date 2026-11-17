package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("고객번호 = " + account.getCustId());
		System.out.println("계좌번호 = " + account.getAcctId());
		System.out.println("잔액 = " + account.getBalance());
		
		
		Account account2 = new Account("A1105", "221-22-3488", 100000);
		
		account2.withdraw(50000);
		System.out.println("고객번호 = " + account2.getCustId());
		System.out.println("계좌번호 = " + account2.getAcctId());
		System.out.println("잔액 = " + account2.getBalance());
		
		//toString();
		//println가 알아서 toString 있는지 체크하고 불러준다. 디컴파일로 소스 보면 됨.
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		System.out.println(account2);
	}
}
