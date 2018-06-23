package ftnbooking.agent.soap;

import java.util.List;

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

	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "reserveLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ReserveLodging")
	    @ResponseWrapper(localName = "reserveLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ReserveLodgingResponse")
	    public Long reserveLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Reservation arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "freeLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.FreeLodging")
	    @ResponseWrapper(localName = "freeLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.FreeLodgingResponse")
	    public Long freeLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Reservation arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "realizeReservation", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.RealizeReservation")
	    @ResponseWrapper(localName = "realizeReservationResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.RealizeReservationResponse")
	    public Long realizeReservation(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Reservation arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeLodging")
	    @ResponseWrapper(localName = "synchronizeLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeLodgingResponse")
	    public List<Lodging> synchronizeLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        ApplicationUser arg0); //verovatno ce se menjati
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeReservation", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeReservation")
	    @ResponseWrapper(localName = "synchronizeReservationResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeReservationResponse")
	    public List<Reservation> synchronizeReservation(
	        @WebParam(name = "arg0", targetNamespace = "")
	        ApplicationUser arg0); //verovatno ce se menjati
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeFeatureType", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeFeatureType")
	    @ResponseWrapper(localName = "synchronizeFeatureTypeResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeFeatureTypeResponse")
	    public List<FeatureType> synchronizeFeatureType(
	       );
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeLodgingType", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeLodgingType")
	    @ResponseWrapper(localName = "synchronizeLodgingTypeResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeLodgingTypeResponse")
	    public List<LodgingType> synchronizeLodgingType(
	       );
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeFoodServiceType", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeFoodServiceType")
	    @ResponseWrapper(localName = "synchronizeFoodServiceTypeResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeFoodServiceTypeResponse")
	    public List<FoodServiceType> synchronizeFoodServiceType(
	       );
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizePrice", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizePrice")
	    @ResponseWrapper(localName = "synchronizePriceResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizePriceResponse")
	    public List<Price> synchronizePrice(
	        @WebParam(name = "arg0", targetNamespace = "")
	        ApplicationUser arg0); //verovatno ce se menjati
	 
	 @WebMethod
	    @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "addPrice", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddPrice")
	    @ResponseWrapper(localName = "addPriceResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.AddPriceResponse")
	    public Long addPrice(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Price arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeApplicationUser", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeApplicationUser")
	    @ResponseWrapper(localName = "synchronizeApplicationUserResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeApplicationUserResponse")
	    public List<ApplicationUser> synchronizeApplicationUser(
	       );
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "synchronizeMessage", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeMessage")
	    @ResponseWrapper(localName = "synchronizeMessageResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SynchronizeMessageResponse")
	    public List<Message> synchronizeMessage(
	        @WebParam(name = "arg0", targetNamespace = "")
	        ApplicationUser arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "changePassword", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ChangePassword")
	    @ResponseWrapper(localName = "changePasswordResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.ChangePasswordResponse")
	    public boolean changePassword(
	        @WebParam(name = "arg0", targetNamespace = "")
	        String arg0,
	        @WebParam(name = "arg1", targetNamespace = "")
	        ChangePasswordDTO arg1);
	 
	 @WebMethod
	    @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "sendMessage", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SendMessage")
	    @ResponseWrapper(localName = "sendMessageResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.SendMessageResponse")
	    public Long sendMessage(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Message arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "deleteLodging", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeleteLodging")
	    @ResponseWrapper(localName = "deleteLodgingResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeleteLodgingResponse")
	    public boolean deleteLodging(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Lodging arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "deleteReservation", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeleteReservation")
	    @ResponseWrapper(localName = "deleteReservationResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeleteReservationResponse")
	    public boolean deleteReservation(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Reservation arg0);
	 
	 @WebMethod
	 @WebResult(targetNamespace = "")
	    @RequestWrapper(localName = "deletePrice", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeletePrice")
	    @ResponseWrapper(localName = "deletePriceResponse", targetNamespace = "https://soap.agent.ftnbooking", className = "ftnbooking.agent.soap.DeletePriceResponse")
	    public boolean deletePrice(
	        @WebParam(name = "arg0", targetNamespace = "")
	        Price arg0);

}
