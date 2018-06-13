package ftnbooking.agent;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.LodgingWebService;

@Configuration
public class CXFConfig {
	
	@Bean
	public LodgingService getLodgingService() {
		LodgingWebService service = new LodgingWebService();
		LodgingService lservice = service.getLodgingServicePort();
		setUpInterceptors(lservice);
		return lservice;
	}
	
	private void setUpInterceptors(Object o) {
		Client client = ClientProxy.getClient(o);
		client.getOutInterceptors().add(getWSS4JOutInterceptor());
		client.getInInterceptors().add(getWSS4JInInterceptor());
	}
	
	@Bean
	public WSS4JOutInterceptor getWSS4JOutInterceptor() {
		Map<String, Object> outProps = new HashMap<String, Object>();
	
		return new WSS4JOutInterceptor(outProps);
	}
	
	@Bean
	public WSS4JInInterceptor getWSS4JInInterceptor() {
		Map<String, Object> inProps = new HashMap<String, Object>();
		
		return new WSS4JInInterceptor(inProps);
	}
	
}
