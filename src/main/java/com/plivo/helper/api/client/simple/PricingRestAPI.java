package com.plivo.helper.api.client.simple;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.plivo.helper.api.common.CommonRestApi;
import com.plivo.helper.api.response.pricing.PlivoPricing;
import com.plivo.helper.exception.PlivoException;

public class PricingRestAPI extends CommonRestApi {

	private Gson gson = new Gson();

	public PricingRestAPI() {

	}

	public PricingRestAPI(String authId, String authToken, String version) {
		this.authId = authId;
		this.authToken = authToken;
		if (version == null || version.trim().isEmpty())
			version = LATEST_PLIVO_VERSION;
		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, version, authId);
	}

	public PricingRestAPI(String authId, String authToken) {
		this.authId = authId;
		this.authToken = authToken;

		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, LATEST_PLIVO_VERSION, authId);
	}

	// Pricing
	public PlivoPricing getPricing(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		return this.gson.fromJson(request("GET", "/Pricing/", parameters),
				PlivoPricing.class);
	}

}