package edu.tum.cal.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import edu.tum.cal.client.wsdl.AddNumbersRequest;
import edu.tum.cal.client.wsdl.AddNumbersResponse;

public class AddClient extends WebServiceGatewaySupport{
	
	public AddNumbersResponse addNumbers(double a, double b){
		AddNumbersRequest req = new AddNumbersRequest();
		req.setN1(String.valueOf(a));
		req.setN2(String.valueOf(b));
		
		return (AddNumbersResponse) getWebServiceTemplate().marshalSendAndReceive(ClientConfiguration.AddServiceUrl, req);
	}
	
}
