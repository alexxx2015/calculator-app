package edu.tum.cal.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import edu.tum.cal.client.wsdl.SubNumbersRequest;
import edu.tum.cal.client.wsdl.SubNumbersResponse;

public class SubClient extends WebServiceGatewaySupport{
	
	public SubNumbersResponse subNumbers(double a, double b){
		SubNumbersRequest req = new SubNumbersRequest();
		req.setN1(String.valueOf(a));
		req.setN2(String.valueOf(b));
		
		return (SubNumbersResponse) getWebServiceTemplate().marshalSendAndReceive(ClientConfiguration.SubServiceUrl, req);
	}
	
}
