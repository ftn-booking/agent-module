package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "realizeReservation", propOrder = {
    "arg0"
})
public class RealizeReservation {
	protected Reservation arg0;

    public Reservation getArg0() {
        return arg0;
    }

    public void setArg0(Reservation value) {
        this.arg0 = value;
    }
}
