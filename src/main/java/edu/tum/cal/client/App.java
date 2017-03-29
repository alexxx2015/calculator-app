package edu.tum.cal.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tum.cal.client.wsdl.AddNumbersResponse;

//@SpringBootApplication
public class App {
	public static void main(String[] args) {
//		SpringApplication.run(App.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ClientConfiguration.class);
		ctx.refresh();
		AddClient ac = ctx.getBean(AddClient.class);
		AddNumbersResponse anr = ac.addNumbers(4, 5);
		System.out.println("RESP: "+anr.getN1());
	}

//	@Bean
//	CommandLineRunner lookup(final AdderClient client) {
//		return args -> {
//			AddNumbersResponse resp = client.addNumbers(5, 6);
//			System.out.println(resp.getN1());
//		};
//	}
}
