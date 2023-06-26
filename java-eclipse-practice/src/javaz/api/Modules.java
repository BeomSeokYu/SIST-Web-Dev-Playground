package javaz.api;

import javax.swing.JFrame;

public class Modules {

	public static void main(String[] args) {
		new MyWindow();
	}

}

class MyWindow extends JFrame {

	public MyWindow() {
		setSize(200, 200);
		setVisible(true);
	}
	
}