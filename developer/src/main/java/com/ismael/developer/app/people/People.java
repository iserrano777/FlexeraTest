package com.ismael.developer.app.people;

/*
 * This class is use for the business Logic of the application
 */

public class People {
	private Long id;
	private String personname;
	private Integer age;
	private Double balance;
	private String email;
	private String address;
	
	public People() {
		
	}
	
	
	public People(long id,String personname, Integer age, double balance, String email, String address) {
		super();
		this.id = id;
		this.personname = personname;
		this.age = age;
		this.balance = balance;
		this.email = email;
		this.address = address;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPersonname() {
		return personname;
	}


	public void setPersonname(String personname) {
		this.personname = personname;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personname == null) ? 0 : personname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People person = (People) obj;
		if (personname == null) {
			if (person.personname != null)
				return false;
		} else if (!personname.equals(person.personname))
			return false;
		if (id == null) {
			if (person.id != null)
				return false;
		} else if (!id.equals(person.id))
			return false;
		if (age == null) {
			if (person.age != null)
				return false;
		} else if (!age.equals(person.age))
			return false;
		if (balance == null) {
			if (person.balance != null)
				return false;
		} else if (!balance.equals(person.balance))
			return false;
		if (email == null) {
			if (person.email != null)
				return false;
		} else if (!email.equals(person.email))
			return false;
		if (address == null) {
			if (person.address != null)
				return false;
		} else if (!address.equals(person.address))
			return false;
		return true;
	}

}
