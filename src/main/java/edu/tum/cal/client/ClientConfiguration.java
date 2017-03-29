package edu.tum.cal.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfiguration {

	public static String AddServiceUrl = "http://localhost:8080/add/";
	public static String SubServiceUrl = "http://localhost:8181/sub/";
	public static String MulServiceUrl = "http://localhost:8282/mul/";
	public static String DivServiceUrl = "http://localhost:8383/div/";
	public static String ContextPath = "edu.tum.cal.client.wsdl";

	@Bean
	public Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(ContextPath);
		return marshaller;
	}
	
	@Bean
	public AddClient getAddClient(Jaxb2Marshaller marshaller){
		AddClient ac = new AddClient();
		ac.setDefaultUri(ClientConfiguration.AddServiceUrl);
		ac.setMarshaller(marshaller);
		ac.setUnmarshaller(marshaller);
		return ac;
	}
	
	@Bean
	public SubClient getSubClient(Jaxb2Marshaller marshaller){
		SubClient ac = new SubClient();
		ac.setDefaultUri(ClientConfiguration.SubServiceUrl);
		ac.setMarshaller(marshaller);
		ac.setUnmarshaller(marshaller);
		return ac;
	}
	
	@Bean
	public MulClient getMulClient(Jaxb2Marshaller marshaller){
		MulClient ac = new MulClient();
		ac.setDefaultUri(ClientConfiguration.MulServiceUrl);
		ac.setMarshaller(marshaller);
		ac.setUnmarshaller(marshaller);
		return ac;
	}
	
	@Bean
	public DivClient getDivClient(Jaxb2Marshaller marshaller){
		DivClient ac = new DivClient();
		ac.setDefaultUri(ClientConfiguration.DivServiceUrl);
		ac.setMarshaller(marshaller);
		ac.setUnmarshaller(marshaller);
		return ac;
	}
	
	
}
