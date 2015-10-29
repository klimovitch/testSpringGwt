package com.netCracker.testSpringGwt.shared.services.utils;

import org.apache.commons.codec.language.Metaphone;

public class MetaphoneUtils {

	public Metaphone metaphoner = new Metaphone();

	public String metaphoneCustomer(String name) {
		String nameMetaphone = metaphoner.metaphone(name);
		return nameMetaphone;

	}

}
