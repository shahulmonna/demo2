package com.test

class Person {
	String firstName
	String lastName
	String emailId
	Integer age

	static constraints = {
		firstName maxSize: 100
		lastName()
		age()
		emailId email: true
	}
}
