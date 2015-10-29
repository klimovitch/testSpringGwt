package com.netCracker.testSpringGwt.client;

public final class ValidationUtils {

	public static final String EMPTY_STR = "";
	
	public static final String REG_ENG_STR = "^[A-Za-z\\s-]+$";

	private ValidationUtils() {
	}

	public static boolean isEmpty(String str) {
		if (str != null) {
			return EMPTY_STR.equals(str);
		}

		return true;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isBlank(String str) {
		if (isNotEmpty(str)) {
			return EMPTY_STR.equals(str.trim());
		}

		return true;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	public static boolean isEnglishString(String str) {
		if (ValidationUtils.isNotBlank(str) && str.matches(REG_ENG_STR)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEnglishString(String str) {
		return !isEnglishString(str);
	}

}
