package com.plivo.test.call;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class CallExtensionTest extends AbstractTest {

	@Test
	public void test() {
		addFrom();
		addTo();
		getParameters().put("answer_url",
				"http://www.myxmlserver.com/Hangup.xml");
		getParameters().put("send_digits", "1234");
		getParameters().put("answer-method", "GET");
		try {
			Call response = getRestApi().makeCall(getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException e) {
			System.out.println(e.getMessage());
		}

	}

}
