package com.plivo.test.call;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class CallNumberTest extends AbstractTest {

	@Test
	public void test() {
		addFrom();
		addTo();
		getParameters().put("answer_url",
				"http://dl.dropbox.com/u/54579287/Docs/speak.xml");
		try {
			Call response = getRestApi().makeCall(getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException e) {
			System.out.println(e.getMessage());
		}

	}

}
