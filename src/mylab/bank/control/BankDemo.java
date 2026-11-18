package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		System.out.println("=== 계좌 생성 ===");
		String hong = bank.createSavingsAccount("홍길동", 10000, 3.0);
		String kim = bank.createCheckingAccount("김철수", 20000, 5000);
		String lee = bank.createSavingsAccount("이영희", 30000, 2.0);

		System.out.println();
		bank.printAllAccounts();

		try {
			System.out.println();
			System.out.println("=== 입금/출금 테스트 ===");
			bank.deposit(hong, 5000);
			bank.withdraw(kim, 3000);

			System.out.println();
			System.out.println("=== 이자 적용 테스트 ===");
			Account account = bank.findAccount(hong);
			if (account instanceof SavingsAccount) {
				((SavingsAccount) account).applyInterest();
			}

			System.out.println();
			System.out.println("=== 계좌 이체 테스트 ===");
			bank.transfer(lee, kim, 5000);

			System.out.println();
			bank.printAllAccounts();
		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 출금 한도 초과: 자식 예외를 먼저 잡는다
		try {
			bank.withdraw(kim, 6000);
		} catch (WithdrawalLimitExceededException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 한도를 넘는 금액은 이체도 막힌다
		try {
			bank.transfer(kim, lee, 6000);
		} catch (InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 없는 계좌
		try {
			bank.deposit("AC9999", 1000);
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
	}
}
