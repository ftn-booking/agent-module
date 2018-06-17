package ftnbooking.agent.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(name = "LodgingServiceSoap", targetNamespace = "https://soap.agent.ftnbooking")

public interface LodgingService {
	 @WebMethod
	    @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "addLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddLodging")
	    @ResponseWrapper(localName = "addLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddLodgingResponse")
	    public Long addLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);

	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "reserveLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ReserveLodging")
	    @ResponseWrapper(localName = "reserveLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ReserveLodgingResponse")
	    public Long reserveLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);
	 
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "freeLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.FreeLodging")
	    @ResponseWrapper(localName = "freeLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.FreeLodgingResponse")
	    public Long freeLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);
	 
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "realizeReservation", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.RealizeReservation")
	    @ResponseWrapper(localName = "realizeReservationResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.RealizeReservationResponse")
	    public Long realizeReservation(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);
}
