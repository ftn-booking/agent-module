package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeLodgingResponse", propOrder = {
    "_return"
})
public class SynchronizeLodgingResponse {
	@XmlElement(name = "return")
    protected List<Lodging> _return;

  
    public List<Lodging> getReturn() {
        return _return;
    }

    
    public void setReturn(List<Lodging> value) {
        this._return = value;
    }
}
