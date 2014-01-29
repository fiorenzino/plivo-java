package com.plivo.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.plivo.test.call.CallExtensionTest;
import com.plivo.test.call.CallNumberTest;
import com.plivo.test.call.HangupCallTest;
import com.plivo.test.call.RecordCallTest;
import com.plivo.test.call.TransferCallTest;
import com.plivo.test.conference.GetAllConferencesTest;
import com.plivo.test.conference.HangUpConferenceMemberTest;
import com.plivo.test.conference.HangupAllConferencesTest;
import com.plivo.test.conference.HangupConferenceTest;
import com.plivo.test.conference.KickMemberTest;
import com.plivo.test.conference.MakeMemberDeafTest;
import com.plivo.test.conference.MakeMemberUndeafTest;
import com.plivo.test.conference.MuteMemberTest;
import com.plivo.test.conference.PlayMemberTest;
import com.plivo.test.conference.RecordConferenceTest;
import com.plivo.test.conference.RetrieveConferenceDetailsTest;
import com.plivo.test.conference.SpeakToMemberTest;
import com.plivo.test.conference.StopPlayMemberTest;
import com.plivo.test.conference.StopRecordingConferenceTest;
import com.plivo.test.conference.UnmuteMemberTest;
import com.plivo.test.message.MessageTest;
import com.plivo.test.message.SendMessageTest;
import com.plivo.test.number.ListRentedNumberTest;
import com.plivo.test.number.RentNumberTest;
import com.plivo.test.number.RentedNumberDetailsTest;
import com.plivo.test.number.SearchAvailableNumbersTest;
import com.plivo.test.plivoXml.DialXMLTest;
import com.plivo.test.plivoXml.GetDigitsXMLTest;
import com.plivo.test.plivoXml.SpeakXMLTest;

@RunWith(Suite.class)
@SuiteClasses({ MessageTest.class, CallExtensionTest.class,
		CallNumberTest.class, HangupCallTest.class, RecordCallTest.class,
		TransferCallTest.class, GetAllConferencesTest.class,
		HangupAllConferencesTest.class, HangUpConferenceMemberTest.class,
		HangupConferenceTest.class, KickMemberTest.class,
		MakeMemberDeafTest.class, MakeMemberUndeafTest.class,
		MuteMemberTest.class, PlayMemberTest.class, RecordConferenceTest.class,
		RetrieveConferenceDetailsTest.class, SpeakToMemberTest.class,
		StopPlayMemberTest.class, StopRecordingConferenceTest.class,
		UnmuteMemberTest.class,

		SendMessageTest.class, MessageTest.class,

		ListRentedNumberTest.class, RentedNumberDetailsTest.class,
		RentNumberTest.class, SearchAvailableNumbersTest.class,

		DialXMLTest.class, GetDigitsXMLTest.class, SpeakXMLTest.class

})
public class TestSuite {

	@BeforeClass
	public static void setUp() {
		System.out.println("setting up");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("tearing down");
	}

}