package ftnbooking.agent.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftnbooking.agent.soap.ChangePasswordDTO;
import ftnbooking.agent.soap.LodgingService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private AgentServiceLocal agentService;
	
	
	@PostMapping("/{email}")
	public ResponseEntity<?> changePass(@PathVariable String email, @RequestBody ChangePasswordDTO cdto){
		if(!cdto.getOldPassword().equals(cdto.getNewPassword())) {
			boolean changed = lodgingService.changePassword(email, cdto);
			if (changed) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	};
	
}
