package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class SpeakToMemberTest extends AbstractTest {

	@Test
	public void test() {

		getParameters().put("conference_name", "1234");
		getParameters().put("member_id", "1");
		/*
		 * single member_id or multiple or 'all'
		 */
		getParameters().put("text",
				"Hello! Member. Welcome to the conference 1234");

		/**
		 * Optional Parameters
		 * 
		 * voice : MAN, WOMAN, Defaults to WOMAN language : en-US,el-GR etc.
		 * 
		 * getParameters().put("voice", "MAN"); getParameters().put("language",
		 * "en-US");
		 */

		try {
			GenericResponse response = getRestApi()
					.speakMember(getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}

	}
}
