package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendMessage", propOrder = {
    "arg0"
})
public class SendMessage {
	protected Message arg0;

	   
    public Message getArg0() {
        return arg0;
    }

   
    public void setArg0(Message value) {
        this.arg0 = value;
    }
}
