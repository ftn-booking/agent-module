package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changePassword", propOrder = {
    "arg0", "arg1"
})
public class ChangePassword {
	
	protected String arg0;
	
	protected ChangePasswordDTO arg1;
	   
    public String getArg0() {
        return arg0;
    }

   
    public void setArg0(String value) {
        this.arg0 = value;
    }


	public ChangePasswordDTO getArg1() {
		return arg1;
	}


	public void setArg1(ChangePasswordDTO arg1) {
		this.arg1 = arg1;
	}
    
    
}
