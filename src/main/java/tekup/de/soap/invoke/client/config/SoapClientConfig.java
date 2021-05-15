package tekup.de.soap.invoke.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import tekup.de.soap.invoke.client.service.SoapClient;
@Configuration
public class SoapClientConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("de.tekup.loan.soap.api.consume.whitetest");
		return marshaller;
	}

	
	

}
