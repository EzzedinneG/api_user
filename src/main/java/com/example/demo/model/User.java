package com.example.demo.model;

import java.util.Objects; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String FirstName;

	@NonNull
	private String LasttName;
	@NonNull
	private Integer age;
	@NonNull
	private String country;
	public User() {
		super();
	}
	

	public User(String firstName, long id, String lasttName, Integer age, String country) {
		super();
		FirstName = firstName;
		this.id = id;
		LasttName = lasttName;
		this.age = age;
		this.country = country;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLasttName() {
		return LasttName;
	}
	public void setLasttName(String lasttName) {
		LasttName = lasttName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public int hashCode() {
		return Objects.hash(FirstName, LasttName, age, country, id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(FirstName, other.FirstName) && Objects.equals(LasttName, other.LasttName)
				&& Objects.equals(age, other.age) && Objects.equals(country, other.country) && id == other.id;
	}




	@Override
	public String toString() {
		return "User [FirstName=" + FirstName + ", id=" + id + ", LasttName=" + LasttName + ", age=" + age
				+ ", country=" + country + "]";
	}
	
	
	
	
}
