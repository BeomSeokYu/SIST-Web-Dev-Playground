package javaz.oop;

public class DeskLamp {
	private int volt;		// 전압을 저장하는 volt추가
	private boolean power;	// 전원 켜짐:true, 꺼짐:false
	private int brightness; // 1/2/3 단계 밝기, 0 이면 꺼짐
	
	public DeskLamp() {
		volt = 220;
	}
	
	public DeskLamp(int volt) {
		this.volt = volt;
	}
	
	public void powerOn() {
		// 전원 켜기
		// 전원을 키면 기본 밝기는 1단계
		power = true;
		brightness = 1;
		System.out.println("램프가 켜졌습니다.");
	}
	
	public void powerOff() {
		// 전원 끄기
		// 밝기는 0으로 설정
		power = false;
		brightness = 0;
		System.out.println("램프가 꺼졌습니다.");
	}
	// Setter
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	// Getter
	public int getBrightness() {
		return brightness;
	}
	
	public void setVolt(int volt) {
		this.volt = volt;
	}
	
	// 객체를 문자열로 반환
	public String toString() {
		// 램프 전원에따라 ON/OFF 출력
		// 밝기도 출력
		return "전원 : " + (power?"On":"Off") + ", 밝기 : " + brightness + " 단계" + ", 전압 : " + volt + "v";

		
	}
}
