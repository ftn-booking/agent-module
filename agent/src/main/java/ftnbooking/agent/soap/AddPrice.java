package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addPrice", propOrder = {
    "arg0"
})
public class AddPrice {
	
	protected Price arg0;

	   
    public Price getArg0() {
        return arg0;
    }

   
    public void setArg0(Price value) {
        this.arg0 = value;
    }
}
