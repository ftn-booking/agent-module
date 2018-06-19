package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizePrice", propOrder = {
    "arg0"
})
public class SynchronizePrice {
	protected ApplicationUser arg0;

	   
    public ApplicationUser getArg0() {
        return arg0;
    }

   
    public void setArg0(ApplicationUser value) {
        this.arg0 = value;
    }
}
