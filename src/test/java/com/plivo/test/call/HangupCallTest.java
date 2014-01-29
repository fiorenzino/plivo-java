package com.plivo.test.call;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class HangupCallTest extends AbstractTest {

	@Test
	public void test() {
		getParameters().put("call_uuid", "6653422-91b6-4716-9fad-9463daaeeec2");
		try {
			GenericResponse response = getRestApi().hangupCall(getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}
	}

}
