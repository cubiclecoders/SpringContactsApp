package com.ravi.contactsapp.util;

public class StringUtil {

	public static String CommaSeparatedUserIds(Integer[] userIds) {

		StringBuilder sb = new StringBuilder();
		for (Integer userId : userIds) {
			sb.append(userId).append(",");
		}

		return sb.deleteCharAt(sb.length()-1).toString();
	}

}
