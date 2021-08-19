package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin()
@RequestMapping("api")

public class UserController {
	@Autowired
	
	private UserService userService;
	
@PutMapping("/update")
	
	public ResponseEntity<?> Update ( @RequestBody  User user)
	{
		Optional<User> UserOpt = userService.Update(user);
	
		if(UserOpt.isPresent())
			
		{
			return new ResponseEntity<User>( UserOpt.get(),HttpStatus.OK);
		}
		
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }
	
	
	@PostMapping("/add")
	
	public ResponseEntity<?> AddUser ( @RequestBody  User user)
	{
	userService.AddUser(user);
	return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?> FindById(@PathVariable Long id)
	{
		Optional<User> UserOpt = userService.FindById(id);
		if( UserOpt.isPresent())
		
		{
		
		 return new ResponseEntity<User>( UserOpt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
@GetMapping("/")
public List<User> hello()
{
	return this.userService.findall();
}

@DeleteMapping("/delete/{id}")

public  ResponseEntity<?> delete(@PathVariable Long id)
{
	Optional<User> OptUser = userService.Delete(id) ;
	if( OptUser.isPresent())
	{
		
	 return new ResponseEntity<User>( OptUser.get(),HttpStatus.NO_CONTENT);
	 
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

}


}
