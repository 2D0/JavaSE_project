package chapter3.oop;

public class MyDateTest {
	public static void main(String[] args) {          
		// 1. 프로그램 종료 시 실행될 Post Hook(Shutdown Hook) 등록    
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			myCustomEndMethod();
		}));
		

        System.out.println("=== main 메서드 시작 ===");
        MyOtherDateTest myOtherDateTestInstance = new MyOtherDateTest();
        MyOtherDateTest myOtherDateTestInstance1 = new MyOtherDateTest();
        
        // myOtherDateInstance === myOtherDateTestInstance1
        
        String returnValue = myOtherDateTestInstance.publicFunction();
        myOtherDateTestInstance1.exposePrivateFunction();
        System.out.println(returnValue);
        System.out.println("=== main 메서드 종료 ===");
	}
	
	// [Pre Hook 역할] 클래스 로딩 시 main보다 먼저 실행
    static {
        myCustomStartMethod2();
        myCustomStartMethod();
    }

    public static void myCustomStartMethod() {
        System.out.println("시스템 검사");
    }

    public static void myCustomStartMethod2() {
        System.out.println("main 대신 이 함수로 시작했습니다!");
    }
    
    // [Post Hook 역할] 프로그램이 완전히 종료되기 직전에 실행
    public static void myCustomEndMethod() {
        System.out.println("프로그램 종료 전 뒷정리 및 로그 기록!");
    }
}



