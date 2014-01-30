package com.plivo.helper.api.client.simple;

import java.util.LinkedHashMap;

import com.google.gson.Gson;
import com.plivo.helper.api.client.CommonRestApi;
import com.plivo.helper.api.client.util.HttpUtils;
import com.plivo.helper.api.response.account.Account;
import com.plivo.helper.api.response.account.SubAccount;
import com.plivo.helper.api.response.account.SubAccountFactory;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;

public class AccountRestAPI extends CommonRestApi {

	private Gson gson = new Gson();

	public AccountRestAPI() {

	}

	public AccountRestAPI(String authId, String authToken, String version) {
		this.authId = authId;
		this.authToken = authToken;
		if (version == null || version.trim().isEmpty())
			version = LATEST_PLIVO_VERSION;
		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, version, authId);
	}

	public AccountRestAPI(String authId, String authToken) {
		this.authId = authId;
		this.authToken = authToken;

		this.baseURI = String.format("%s/%s/Account/%s", PLIVO_PROTOCOL
				+ PLIVO_HOST, LATEST_PLIVO_VERSION, authId);
	}

	// Account
	public Account getAccount() throws PlivoException {
		return this.gson.fromJson(
				request("GET", "/", new LinkedHashMap<String, String>()),
				Account.class);
	}

	public GenericResponse editAccount(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		return this.gson.fromJson(request("POST", "/", parameters),
				GenericResponse.class);
	}

	public SubAccountFactory getSubaccounts() throws PlivoException {
		return this.gson.fromJson(
				request("GET", "/Subaccount/",
						new LinkedHashMap<String, String>()),
				SubAccountFactory.class);
	}

	public SubAccount getSubaccount(LinkedHashMap<String, String> parameters)
			throws PlivoException {
		String subauth_id = HttpUtils.getKeyValue(parameters, "subauth_id");
		return this.gson.fromJson(
				request("GET", String.format("/Subaccount/%s/", subauth_id),
						parameters), SubAccount.class);
	}

	public GenericResponse createSubaccount(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		return this.gson.fromJson(request("POST", "/Subaccount/", parameters),
				GenericResponse.class);
	}

	public GenericResponse editSubaccount(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		return this.gson.fromJson(request("POST", "/Subaccount/", parameters),
				GenericResponse.class);
	}

	public GenericResponse deleteSubaccount(
			LinkedHashMap<String, String> parameters) throws PlivoException {
		String subauth_id = HttpUtils.getKeyValue(parameters, "subauth_id");
		return this.gson.fromJson(
				request("DELETE", String.format("/Subaccount/%s/", subauth_id),
						parameters), GenericResponse.class);
	}
}
