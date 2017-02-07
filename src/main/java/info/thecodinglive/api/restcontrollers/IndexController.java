package info.thecodinglive.api.restcontrollers;

import info.thecodinglive.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(){
		return "1";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/user")
	public ResponseEntity<?> userList(){
		Map<String, Object> resultMap = new HashMap();
		resultMap.put("result", userService.findAllUserList());
		
		return new ResponseEntity(resultMap, HttpStatus.OK);
	}
}
