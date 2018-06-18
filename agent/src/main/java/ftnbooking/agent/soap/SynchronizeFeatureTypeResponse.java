package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeFeatureTypeResponse", propOrder = {
    "_return"
})
public class SynchronizeFeatureTypeResponse {
	@XmlElement(name = "return")
    protected List<FeatureType> _return;

  
    public List<FeatureType> getReturn() {
        return _return;
    }

    
    public void setReturn(List<FeatureType> value) {
        this._return = value;
    }
}
