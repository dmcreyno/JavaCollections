package com.cobbinterwebs.jdj.vol9.issue2.domain;

public class Person {
	String ssn;
	
	public Person(String pSSN) {
		ssn = pSSN;
	}
	
	@Override
	public String toString() {
		return ssn;
	}
}
