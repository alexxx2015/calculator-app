package edu.tum.cal.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import edu.tum.cal.client.wsdl.MulNumbersRequest;
import edu.tum.cal.client.wsdl.MulNumbersResponse;

public class MulClient extends WebServiceGatewaySupport{
	
	public MulNumbersResponse mulNumbers(double a, double b){
		MulNumbersRequest req = new MulNumbersRequest();
		req.setN1(String.valueOf(a));
		req.setN2(String.valueOf(b));
		
		return (MulNumbersResponse) getWebServiceTemplate().marshalSendAndReceive(ClientConfiguration.MulServiceUrl, req);
	}
	
}
