package ftnbooking.agent.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(name = "LodgingServiceSoap", targetNamespace = "http://soap.agent.ftnbooking")

public interface LodgingService {
	 @WebMethod
	    @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "addLodging", targetNamespace = "http://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddLodging")
	    @ResponseWrapper(localName = "addLodgingResponse", targetNamespace = "http://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddLodgingResponse")
	    public Long addLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);

}
