package com.plivo.test.plivoXml;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.xml.elements.Dial;
import com.plivo.helper.xml.elements.Number;
import com.plivo.helper.xml.elements.PlivoResponse;
import com.plivo.test.common.AbstractTest;

public class DialXMLTest extends AbstractTest {

	@Test
	public void test() {
		PlivoResponse response = new PlivoResponse();
		Dial dial = new Dial();
		dial.setCallerId("12345678901");
		Number number = new Number("12345678901");

		dial.setAction("http://http://myserverurl/setredirect/");
		dial.setMethod("GET");

		try {
			dial.append(number);
			response.append(dial);

			Assert.assertNotNull(response.toXML());
		} catch (PlivoException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
