plivo-java: REVAMP PROCESS!!
=========================


Description
-----------

![alt text](https://s3.amazonaws.com/new-ui-cms-plivo/img/logo-119x36.png "Plivo")

Simple rewriting process of original code.. Junit test and more!



How to use
----------

### Making a Call.
	RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>");

  	Map<String, String> params = new HashMap<String, String>();
		params.put("from", "xxxxxxxxxx");
		params.put("to", "xxxxxxxxxx");
		params.put("answer_url", "http://server/url/answer.xml");

		Call response;
		try {
			response = restAPI.makeCall(params);
			System.out.println(response.apiId);
		} 
		catch (PlivoException e) {
			System.out.println(e.getMessage());
		}
 
### Check the [junit test to verify my code](https://github.com/fiorenzino/plivo-java/tree/master/src/test/java/com/plivo/test)


ping me @ fiorenzino[AT]gmail.com


