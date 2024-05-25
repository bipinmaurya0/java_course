package com.restApiForTesting.restFullApiwebservices;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserJPARepository {
	
	@Autowired
	private UserDAO userD;

	@Autowired
	private RepositoryJpa repository;
	
	public UserJPARepository(UserDAO user, RepositoryJpa repository) {
		this.repository=repository;
		this.userD=user;
	}
	
	
	@GetMapping("/jpa/details")
	public String getfetch() {
		return "all data";
	}
	
	@GetMapping("/jpa/users")
	public  List<Users> getchdetails()
	{
		return userD.getalldetails();
	}
	@GetMapping("/jpa/users/{id}")
	public  EntityModel<Users> getalldetailsbyid(@PathVariable int id){
		
		Users us=userD.getalldetailsbyid(id);
		if(us==null) 
		{
			throw new UserNotFoundExpection("User Not Found -->Id:"+id);
		}
		EntityModel<Users> entity= EntityModel.of(us);
		WebMvcLinkBuilder  links=linkTo(methodOn(this.getClass()).getchdetails());
		 entity.add(links.withRel("all_users"));
		 return entity;
	}
	
	@PostMapping("/jpa/users")
	 public  ResponseEntity<Users> adddetails(@Valid @RequestBody Users user)
	 
	{
		Users us=repository.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(us.getID())
				.toUri();
		return  ResponseEntity.created(location).build();
	}
	@DeleteMapping("/jpa/users/{id}")
	public String DeleteUserbyid(@PathVariable int id)
	{
		Users us=userD.getalldetailsbyid(id);
		if(us==null) {
			
			throw new UserNotFoundExpection("User Not Found -->Id:"+id);
		}
		else {
			userD.deleteData(id);
			throw new UserNotFoundExpection("Successfully delete for given Id"+id);
		}
	}
	
}


