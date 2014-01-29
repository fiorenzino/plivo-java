package com.plivo.test.plivoXml;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.xml.elements.PlivoResponse;
import com.plivo.helper.xml.elements.Speak;
import com.plivo.test.common.AbstractTest;

public class SpeakXMLTest extends AbstractTest {

	@Test
	public void test() {
		PlivoResponse response = new PlivoResponse();
		Speak speak = new Speak("Plivo calling.");

		// Set various attributes for speak
		speak.setLanguage("en-US");
		speak.setVoice("WOMAN");

		try {
			response.append(speak);
			Assert.assertNotNull(response.toXML());
		} catch (PlivoException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
