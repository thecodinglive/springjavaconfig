package info.thecodinglive.api.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.api.dao.UserDao;

@RestController
public class IndexController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String index(){
		return "1";
	}
	
	@RequestMapping("/user")
	public ResponseEntity<?> userList(){
		List resultList = new ArrayList(); 
		resultList = userDao.selectAll();
		
		return new ResponseEntity(resultList, HttpStatus.OK);
	}
}
