package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeLodgingTypeResponse", propOrder = {
    "_return"
})
public class SynchronizeLodgingTypeResponse {
	@XmlElement(name = "return")
    protected List<LodgingType> _return;

  
    public List<LodgingType> getReturn() {
        return _return;
    }

    
    public void setReturn(List<LodgingType> value) {
        this._return = value;
    }
}
