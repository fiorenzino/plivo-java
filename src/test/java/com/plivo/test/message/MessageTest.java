package com.plivo.test.message;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class MessageTest extends AbstractTest {

	@Test
	public void testSingleMessage() {

		addSrc();
		addDst();
		getParameters().put("text", "ciao flower come va?");
		getParameters().put("url", "http://xxx.rhcloud.com/statusCallback.jsf");
		try {
			MessageResponse result = getRestApi().sendMessage(getParameters());
			Assert.assertNotNull(result.messageUuids);
			for (String uid : result.messageUuids) {
				Assert.assertNotNull(uid);
				Assert.assertNull(result.error);
			}
		} catch (PlivoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMultiMessage() {

		addSrc();
		addDst();
		getParameters().put("answer_url",
				"http://xxxx.rhcloud.com/statusCallback.jsf");
		try {
			Call result = getRestApi().makeCall(getParameters());
			Assert.assertNotNull(result);
			Assert.assertNotNull(result.requestUUID);
			Assert.assertNull(result.error);
		} catch (PlivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
