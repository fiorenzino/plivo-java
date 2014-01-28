package com.plivo.test.number;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.number.NumberGroupFactory;
import com.plivo.helper.exception.PlivoException;

public class SearchAvailableNumbers {

	public static void main(String args[]) {
		RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>", "v1");

		NumberGroupFactory numbers = new NumberGroupFactory();
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

		// Mandatory Parameter - country_iso
		params.put("country_iso", "BE");

		// Optional Parameters - number_type, prefix, region, services, limit,
		// offset
		/*
		 * params.put("number_type", "BE"); params.put("prefix", "12345");
		 * params.put("region", "California"); params.put("services", "voice");
		 * params.put("limit", "10"); params.put("offset", "705");
		 */

		try {
			numbers = restAPI.searchNumberGroups(params);
			System.out.println(numbers.groupList.get(0).groupId);
		} catch (PlivoException plivoException) {
			System.out.println(plivoException.getMessage());
			;
		}
	}

}
