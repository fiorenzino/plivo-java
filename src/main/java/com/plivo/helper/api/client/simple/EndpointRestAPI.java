package com.plivo.helper.api.client.simple;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.plivo.helper.api.client.CommonRestApi;
import com.plivo.helper.api.client.util.HttpUtils;
import com.plivo.helper.api.response.endpoint.Endpoint;
import com.plivo.helper.api.response.endpoint.EndpointFactory;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;

public class EndpointRestAPI extends CommonRestApi {

	private Gson gson = new Gson();

	public EndpointRestAPI() {

	}

	public EndpointRestAPI(String authId, String authToken, String version) {
		this.authId = authId;
		this.authToken = authToken;
		if (version == null || version.trim().isEmpty())
			version = LATEST_PLIVO_VERSION;
		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, version, authId);
	}

	public EndpointRestAPI(String authId, String authToken) {
		this.authId = authId;
		this.authToken = authToken;

		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, LATEST_PLIVO_VERSION, authId);
	}

	// Endpoint
	public EndpointFactory getEndpoints(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		return this.gson.fromJson(request("GET", "/Endpoint/", parameters),
				EndpointFactory.class);
	}

	public GenericResponse createEndpoint(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		return this.gson.fromJson(request("POST", "/Endpoint/", parameters),
				GenericResponse.class);
	}

	public Endpoint getEndpoint(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		String endpoint_id = HttpUtils.getKeyValue(parameters, "endpoint_id");
		return this.gson.fromJson(
				request("GET", String.format("/Endpoint/%s/", endpoint_id),
						new LinkedHashMap<String, String>()), Endpoint.class);
	}

	public GenericResponse editEndpoint(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		String endpoint_id = HttpUtils.getKeyValue(parameters, "endpoint_id");
		return this.gson.fromJson(
				request("POST", String.format("/Endpoint/%s/", endpoint_id),
						parameters), GenericResponse.class);
	}

	public GenericResponse deleteEndpoint(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		String endpoint_id = HttpUtils.getKeyValue(parameters, "endpoint_id");
		return this.gson.fromJson(
				request("DELETE", String.format("/Endpoint/%s/", endpoint_id),
						new LinkedHashMap<String, String>()),
				GenericResponse.class);
	}

}
