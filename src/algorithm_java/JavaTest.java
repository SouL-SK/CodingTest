package algorithm_java;

public class JavaTest {
//	public static void main(String[] argv) {
//		new JavaTest().compare();
//	}
//
//	private void compare() {
//		User a = new User("J", "Lee");
//		User b = new User("J", "Lee");
//		User c = a;
//
//		System.out.println(a == b);
//		System.out.println(a == c);
//		System.out.println(a.equals(b));
//	}
//
//	public class User {
//		private String firstName;
//		private String lastName;
//
//		public User(String firstName, String lastName) {
//			this.firstName = new String(firstName);
//			this.lastName = new String(lastName);
//		}
//
//		public boolean equals(User other) {
//			return match(firstName, other.firstName) || match(lastName, other.lastName);
//		}
//
//		private boolean match(String part1, String part2) {
//			return part1 == part2 && part1.equals(part2); //false, true
//		}
//	public static void main(String[] argv) {
//
//		String number = "1234";
//		System.out.println(toInt(number));
//		number = "9,900";
//		System.out.println(toInt(number));
//		number = "10";
//		System.out.println(toInt(number));
//	}
//
//	public static int toInt(String strValue) {
//
//		if (strValue == null || strValue.length() == 0) {
//			throw new IllegalArgumentException();
//		}
//
//		int intValue = 0;
//		try {
//			intValue = Integer.parseInt(strValue);
//		} catch (Exception e) {
//			intValue = 0;
//			System.out.println(intValue);
//			System.out.println(strValue);
//			
//		}
//
//		return intValue;
//	}
	public static void main(String[] argv) {

		String stringObj = "Hello";
		int intValue = 0;
		Float floatObj = new Float(1.0);

		setValues(stringObj, intValue, floatObj);

		System.out.println(stringObj + ", " + intValue + ", " + floatObj);

	}

	private static void setValues(String strValue, int intValue, Float floatObj) {
		strValue.replace("H", "h");
		strValue += " World";
		intValue = 99;
		floatObj.valueOf((float) 2.0);
	}

}
