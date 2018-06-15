package ftnbooking.agent.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LodgingWebService", targetNamespace = "https://soap.agent.ftnbooking", wsdlLocation = "https://localhost:8080/services/LodgingService?wsdl")
public class LodgingWebService extends Service
{

    private final static URL LODGINGWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException LODGINGWEBSERVICE_EXCEPTION;
    private final static QName LODGINGWEBSERVICE_QNAME = new QName("https://backend.ftnbooking/lodgingServiceSoap", "LodgingService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://localhost:8080/services/LodgingService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LODGINGWEBSERVICE_WSDL_LOCATION = url;
        LODGINGWEBSERVICE_EXCEPTION = e;
    }

    public LodgingWebService() {
        super(__getWsdlLocation(), LODGINGWEBSERVICE_QNAME);
    }

    public LodgingWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LODGINGWEBSERVICE_QNAME, features);
    }

    public LodgingWebService(URL wsdlLocation) {
        super(wsdlLocation, LODGINGWEBSERVICE_QNAME);
    }

    public LodgingWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LODGINGWEBSERVICE_QNAME, features);
    }

    public LodgingWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LodgingWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "LodgingServicePort")
    public LodgingService getLodgingServicePort() {
    	LodgingService port = super.getPort(new QName("https://backend.ftnbooking/lodgingServiceSoap", "LodgingServicePort"), LodgingService.class);
    	HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();

    	TLSClientParameters tlsCP = new TLSClientParameters();
    	// other TLS/SSL configuration like setting up TrustManagers
    	tlsCP.setDisableCNCheck(true);
    	httpConduit.setTlsClientParameters(tlsCP);
        return port;
    }


    @WebEndpoint(name = "LodgingServicePort")
    public LodgingService getLodgingServicePort(WebServiceFeature... features) {
    	LodgingService port = super.getPort(new QName("https://backend.ftnbooking/lodgingServiceSoap", "LodgingServicePort"), LodgingService.class, features);
    	HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();

    	TLSClientParameters tlsCP = new TLSClientParameters();
    	// other TLS/SSL configuration like setting up TrustManagers
    	tlsCP.setDisableCNCheck(true);
    	httpConduit.setTlsClientParameters(tlsCP);
        return port;
    }

    private static URL __getWsdlLocation() {
        if (LODGINGWEBSERVICE_EXCEPTION!= null) {
            throw LODGINGWEBSERVICE_EXCEPTION;
        }
        return LODGINGWEBSERVICE_WSDL_LOCATION;
    }

}
