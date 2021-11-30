package com.cobbinterwebs.jdj.vol9.issue2.domain;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if((null == o1.ssn) || (null == o2.ssn)) {
			throw new IllegalStateException("SSN cannot be null. o1.ssn[" + o1.ssn + "] o2.ssn[" + o2.ssn + "]");
		}
		return o1.ssn.compareTo(o2.ssn);
	}

}
