package com.cobbinterwebs.jdj.vol9.issue2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobbinterwebs.jdj.vol9.issue2.domain.Person;

public class Main {
	static final Logger log = LoggerFactory.getLogger(Main.class);
	List<Person> arrListPerson;
	Vector<Person> vPerson;
	List<Person> syncArrListPerson;
	long startTime = 0L;
	long stopTime = 0L;
	long elapsedTime = 0L;
	
	Person p;
	
	static int iterations = 100000; // number of items in collection
	static int numberOfRuns = 8;     // number of time to run full test
	
	public Main() {
		arrListPerson  = new ArrayList<>(iterations);
		vPerson = new Vector<>(iterations);
		syncArrListPerson = Collections.synchronizedList(arrListPerson);
		p = new Person("111-22-3333");
		log.info("Run,Collection,Operation,Elapsed Time (ms)");
	}

	public static void main(String[] args) {
		Main app = new Main();
		for(int i = 0; i < numberOfRuns; i++) {
			app.doArrayListWrite(i);
			app.doArrayListRead(i);
		}
		for(int i = 0; i < numberOfRuns; i++) {
			app.doSyncArrayListWrite(i);
			app.doSyncArrayListRead(i);
		}
		for(int i = 0; i < numberOfRuns; i++) {
			app.doVectorWrite(i);
			app.doVectorRead(i);
		}
	}
	
	void doArrayListWrite(int testRun) {
		String testName = "ArrayList";
		String testOp = "Write";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			arrListPerson.add(p);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},-,{}",testRun,testName,testOp,elapsedTime);
	}
	
	void doSyncArrayListWrite(int testRun) {
		String testName = "SyncArrayList";
		String testOp = "Write";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			syncArrListPerson.add(p);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},-,{}",testRun,testName,testOp,elapsedTime);
	}
	
	void doVectorWrite(int testRun) {
		String testName = "Vector";
		String testOp = "Write";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			vPerson.add(p);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},-,{}",testRun,testName,testOp,elapsedTime);
	}

	void doArrayListRead(int testRun) {
		String testName = "ArrayList";
		String testOp = "Read";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			arrListPerson.get(i);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},{},-",testRun,testName,testOp,elapsedTime);
	}
	
	void doSyncArrayListRead(int testRun) {
		String testName = "SyncArrayList";
		String testOp = "Read";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			syncArrListPerson.get(i);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},{},-",testRun,testName,testOp,elapsedTime);
	}
	
	void doVectorRead(int testRun) {
		String testName = "Vector";
		String testOp = "Read";
		startTime = System.currentTimeMillis();
		for(int i = 0; i < Main.iterations; i++) {
			vPerson.get(i);
		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		log.info("{},{},{},{},-",testRun,testName,testOp,elapsedTime);
	}

}
