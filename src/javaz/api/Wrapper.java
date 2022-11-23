package javaz.api;

public class Wrapper {

	public static void main(String[] args) {
		Object[] obj = new Object[8];

		obj[0] = Boolean.valueOf(false);
		obj[1] = Character.valueOf('A');
		obj[2] = Byte.valueOf((byte) 12);
		obj[3] = Short.valueOf((short) 68);
		obj[4] = Integer.valueOf(83);
		obj[5] = Long.valueOf(12000000000L);
		obj[6] = Float.valueOf(76.3F);
		obj[7] = Double.valueOf(12.82);
		
		for (Object object : obj) {
			System.out.println(object);
		}
		obj[0] = false;
		obj[1] = 'A';
		obj[2] = (byte) 12;
		obj[3] = (short) 68;
		obj[4] = 83;
		obj[5] = 12000000000L;
		obj[6] = 76.3F;
		obj[7] = 12.82;
		
		for (Object object : obj) {
			System.out.println(object);
		}
		
		boolean b = (boolean) obj[0];
		char c = (char) obj[1];
		byte by = (byte) obj[2];
		short s = (short) obj[3];
		int i = (int) obj[4];
		long l = (long) obj[5];
		float f = (float) obj[6];
		double d = (double) obj[7];
		
		System.out.println(Integer.parseInt("123"));
		System.out.println(100 + "");
		System.out.println(String.valueOf(100));
		
		System.out.println(5/0.0);
		System.out.println(Double.isInfinite(5/0.0));
		System.out.println(5%0.0);
		System.out.println(Double.isNaN(5%0.0));
	}
}
