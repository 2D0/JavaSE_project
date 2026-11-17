package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//Method
	public String getCustId() {
		return custId;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	
	//일일이 치지않고 아래처럼 한다고 함.
	//소문자로 getacct 혹은 setacct 치고 컨트롤 + 스페이스바 하면 추천 자동입력 나옴.
	//Source -> Generate Getters and Setters 메뉴에서 선택해서 작성도 가능
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
}
