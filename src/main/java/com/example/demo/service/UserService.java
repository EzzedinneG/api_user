package com.example.demo.service;

import java.util.List; 
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	public List<User> findall();
	public Optional<User> FindById(long id);
    public void AddUser (User user);
	public Optional<User> Update(User user);
	public Optional<User> Delete(long id);
}