package com.restApiForTesting.restFullApiwebservices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	
	
	public static List<Users> list=new ArrayList<>();
	public static int idValue=0;

	static {
		list.add(new Users(++idValue,"Bipin",LocalDate.now().minusYears(24)));
		list.add(new Users(++idValue,"Amit",LocalDate.now().minusYears(22)));
		list.add(new Users(++idValue,"Arun",LocalDate.now().minusYears(25)));
	}
	
	public List<Users> getalldetails(){
		return list;
	}
   
	public Users getalldetailsbyid(int id) {
		return list.stream()
                .filter(user -> user.getID().equals(id))
                .findFirst().orElse(null);
	}

	public Users addnewUsers(Users user) {
		user.setID(++idValue);
		Users us=user;
		
		list.add(user);
		return us;
	}

	public void deleteData(int id) {
	
		list.remove(id-1);
	}
}
