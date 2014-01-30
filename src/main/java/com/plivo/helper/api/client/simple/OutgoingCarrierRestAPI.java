package com.plivo.helper.api.client.simple;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.plivo.helper.api.common.CommonRestApi;
import com.plivo.helper.api.response.carrier.OutgoingCarrier;
import com.plivo.helper.api.response.carrier.OutgoingCarrierCreatedResponse;
import com.plivo.helper.api.response.carrier.OutgoingCarrierFactory;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.util.HttpUtils;

public class OutgoingCarrierRestAPI extends CommonRestApi {

	private Gson gson = new Gson();

	public OutgoingCarrierRestAPI() {

	}

	public OutgoingCarrierRestAPI(String authId, String authToken,
			String version) {
		this.authId = authId;
		this.authToken = authToken;
		if (version == null || version.trim().isEmpty())
			version = LATEST_PLIVO_VERSION;
		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, version, authId);
	}

	public OutgoingCarrierRestAPI(String authId, String authToken) {
		this.authId = authId;
		this.authToken = authToken;

		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, LATEST_PLIVO_VERSION, authId);
	}

	// Outgoing Carrier
	public OutgoingCarrierFactory getOutgoingCarriers(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		return this.gson.fromJson(
				request("GET", "/OutgoingCarrier/", parameters),
				OutgoingCarrierFactory.class);
	}

	public OutgoingCarrier getOutgoingCarrier(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		String carrier = HttpUtils.getKeyValue(parameters, "carrier_id");
		return this.gson.fromJson(
				request("GET", String.format("/OutgoingCarrier/%s/", carrier),
						parameters), OutgoingCarrier.class);
	}

	public OutgoingCarrierCreatedResponse addOutgoingCarrier(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		return this.gson.fromJson(
				request("POST", "/OutgoingCarrier/", parameters),
				OutgoingCarrierCreatedResponse.class);
	}

	public GenericResponse editOutgoingCarrier(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		String carrier = HttpUtils.getKeyValue(parameters, "carrier_id");
		return this.gson.fromJson(
				request("POST", String.format("/OutgoingCarrier/%s/", carrier),
						parameters), GenericResponse.class);
	}

	public GenericResponse dropOutgoingCarrier(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		String carrier = HttpUtils.getKeyValue(parameters, "carrier_id");
		return this.gson.fromJson(
				request("DELETE",
						String.format("/OutgoingCarrier/%s/", carrier),
						parameters), GenericResponse.class);
	}

}
