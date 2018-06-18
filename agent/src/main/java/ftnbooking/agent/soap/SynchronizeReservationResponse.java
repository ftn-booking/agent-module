package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeReservationResponse", propOrder = {
    "_return"
})
public class SynchronizeReservationResponse {
	@XmlElement(name = "return")
    protected List<Reservation> _return;

  
    public List<Reservation> getReturn() {
        return _return;
    }

    
    public void setReturn(List<Reservation> value) {
        this._return = value;
    }
}
