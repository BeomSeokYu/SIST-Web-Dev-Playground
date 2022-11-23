package javaz.oop;

public class Pizza {
	private int radius;
	private String name;
	
	public Pizza(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}
	
	public static Pizza getLargePizza(Pizza p1, Pizza p2) {
		if (p1.radius > p2.radius) {
			return p1;
		} else {
			return p2;
		}
	}
	
	public static void makeLargePizza(Pizza p, int large) {
		if (p.radius < 20) {
			p.radius = large;
		}
	}
	
	public static void setRadius(Pizza p, int r) {
		p.radius = r;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Pizza [radius=" + radius + ", name=" + name + "]";
	}
	
}