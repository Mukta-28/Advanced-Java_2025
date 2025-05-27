package com.cdac.dependent;

import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher subjectTeacher;

	//constructor based D.I (dependency injection) 
	//most recommended from Spring - it enforces mandatory dependency
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass()+""+subjectTeacher);
	}
//core business
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		//dependent public school is using the dependency to teach the student
		subjectTeacher.teach();
	}

	// init method(custom method)(after dependecy it call)()
	public void myInit() {
		System.out.println("in init");
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}

}
