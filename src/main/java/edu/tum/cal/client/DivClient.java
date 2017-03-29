package edu.tum.cal.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import edu.tum.cal.client.wsdl.DivNumbersRequest;
import edu.tum.cal.client.wsdl.DivNumbersResponse;

public class DivClient extends WebServiceGatewaySupport{
	
	public DivNumbersResponse divNumbers(double a, double b){
		DivNumbersRequest req = new DivNumbersRequest();
		req.setN1(String.valueOf(a));
		req.setN2(String.valueOf(b));
		
		return (DivNumbersResponse) getWebServiceTemplate().marshalSendAndReceive(ClientConfiguration.DivServiceUrl, req);
	}
	
}
