package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;

@Override
public Optional<User> Update(User user) {
	//Optional<User> Useropt = userlist.stream().filter(U -> U.getId() == user.getId()).findFirst();
	Optional<User> Useropt = userRepository.findById(user.getId());
if (Useropt.isPresent())
{ 
	User ExistUser = Useropt.get();
	if(user.getFirstName() != null)
	{
		ExistUser.setFirstName(user.getFirstName()) ;
	}
	if(user.getCountry() != null)
	{
		ExistUser.setCountry(user.getCountry()) ;
	}
	if(user.getAge() != null)
	{
		ExistUser.setAge(user.getAge()) ;
	}
	if(user.getLasttName() != null)
	{
		ExistUser.setLasttName(user.getLasttName()) ;
	}
	
	//userlist = userlist.stream().filter(U -> U.getId() != ExistUser.getId()).collect(Collectors.toList());
	//userlist.add(ExistUser);
	userRepository.save(ExistUser);
   return Optional.of(ExistUser);
}
return Optional.empty();

}

@Override
public List<User> findall() {
 return userRepository.findAll();
 //return userlist.stream().sorted(Comparator.comparing(User :: getId)).collect(Collectors.toList());
}
@Override
public Optional<User> FindById(long id) {
	
	//return userlist.stream().filter(User -> User.getId() == id).findFirst();
	return userRepository.findById(id);
}
@Override
public void AddUser(User user) {
	//user.setId(COUNTER++);
	//userlist.add(user);
	userRepository.save(user);
	
}
@Override
public Optional<User> Delete(long id)
{
	//Optional<User> Useropt = userlist.stream().filter(User -> User.getId() == id).findFirst();
	//if (Useropt.isPresent())
	 //{
	//	userlist= userlist.stream().filter(user -> Useropt.get().getId() !=  user.getId()).collect(Collectors.toList());
		//return(Useropt);
	 //} 
	
	//return Optional.empty();
	
	Optional<User> Useropt = userRepository.findById(id);
	if (Useropt.isPresent())
    {
		userRepository.delete(Useropt.get());
		return(Useropt);
	}
	return Optional.empty();
	
}


}
