package lab04;

public class PhoneNumber {

	private String areaCode;
	private String trunk;
	private String rest;

	public PhoneNumber(String phoneNum) {
		phoneNum = phoneNum.replaceAll("-|\\s|\\.|\\(|\\)", "");

		boolean isValid = phoneNum.length() == 10;
		if (isValid) {
			for (int i = 0; i < 10; i++) {
				if (!Character.isDigit(phoneNum.charAt(i))) {
					isValid = false;
					break;
				}
			}
		}

		if (isValid) {
			areaCode = phoneNum.substring(0, 3);
			trunk = phoneNum.substring(3, 6);
			rest = phoneNum.substring(6, 10);
		} else {
			areaCode = "000";
			trunk = "000";
			rest = "000";
			System.err.println("Phone number \"" + phoneNum + "\" is not formatted correctly.");
		}
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PhoneNumber)) return false;
		PhoneNumber rhs = (PhoneNumber) other;
		return areaCode.equals(rhs.areaCode) && trunk.equals(rhs.trunk) && rest.equals(rhs.rest);
	}

	@Override
	public String toString() {
		return "(" + areaCode + ") " + trunk + "-" + rest;
	}

	@Override
	public int hashCode() {
		return areaCode.hashCode() + trunk.hashCode() + rest.hashCode();
	}
}
