package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteLodging", propOrder = {
    "arg0"
})
public class DeleteLodging {
	protected Lodging arg0;

	   
    public Lodging getArg0() {
        return arg0;
    }

   
    public void setArg0(Lodging value) {
        this.arg0 = value;
    }
}
