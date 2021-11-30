package com.cobbinterwebs.jdj.vol9.issue2.domain;

public class PersonComparable extends Person implements Comparable<Person> {

	public PersonComparable(String pSSN) {
		super(pSSN);
	}

	@Override
	public int compareTo(Person o) {
		if((null == this.ssn) || (null == o.ssn)) {
			throw new IllegalStateException("SSN cannot be null. this.ssn[" + ssn + "] other.ssn[" + o.ssn + "]");
		}
		return ssn.compareTo(o.ssn);
	}

	@Override
	public int hashCode() {
		if(null != ssn) {
			return ssn.hashCode();
		} else {
			throw new IllegalStateException("SSN cannot be null");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		Person p = (Person) o;
		if((null == this.ssn) || (null == p.ssn)) {
			throw new IllegalStateException("SSN cannot be null. this.ssn[" + ssn + "] other.ssn[" + p.ssn + "]");
		}
		return ssn.equals(p.ssn);
	}


	public boolean equals(Person o) {
		if((null == this.ssn) || (null == o.ssn)) {
			throw new IllegalStateException("SSN cannot be null. this.ssn[" + ssn + "] other.ssn[" + o.ssn + "]");
		}
		return ssn.equals(o.ssn);
	}
}
