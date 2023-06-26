package javaz.oop;

public class DeskLampTest {

	public static void main(String[] args) {
		DeskLamp myLamp = new DeskLamp();
		
		myLamp.powerOn();
		System.out.println(myLamp);
		
		myLamp.setBrightness(3);
		System.out.println("현재 램프 밝기 : " + myLamp.getBrightness() + " 단계");
		
		myLamp.powerOff();
		System.out.println(myLamp);
		
		System.out.println("-----------------------------------");
		DeskLamp jpLamp = new DeskLamp(110);
		
		System.out.println(jpLamp);
		
	}

}