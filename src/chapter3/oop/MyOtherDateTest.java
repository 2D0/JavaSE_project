package chapter3.oop;

public class MyOtherDateTest {
	public String publicFunction() {
		MyDate date = new MyDate();
		
		// 객체란건데 생성자ㅘ 객체야 
		// js 에선 const a = new 
//		date.day = 32;
		date.setMonth(13);
		
		System.out.println(date.getMonth());
		date.setDay(31);
		System.out.println(date.getDay());
		
		MyDate date2 = new MyDate(2026,13,16);
		System.out.println("date2.exposedDay = " + date2.exposedDay);
		System.out.println("date2.exposedMonth = " + date2.exposedMonth);
		System.out.println("date2.exposedYear = " + date2.exposedYear);
		// const date2: MyDate = new MyDate(2026,13,16)
		System.out.println(date2.getMonth());
		System.out.println(date2.getDay());
		return new String("이 함수는 PUBLIC 접근이 가능합니다.");
	}
	
	private void privateFunction() {
		System.out.println("이 함수는 PRIVATE 접근이 불가능합니다.");
	}
	
	public void exposePrivateFunction() {
		privateFunction();
		System.out.println("이런식으로 우회는 되지만 잘 사용 안함.");
	}
}
