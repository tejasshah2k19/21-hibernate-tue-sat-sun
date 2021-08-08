package com.bean;

import java.util.List;

public class StudentBean {

	int studentId;
	String firstName;

	//1 to many 
	//1 student has many certificates 
	List<CertificateBean> certificates;
	
	//Video- abc 
	//Tag  - programing 
	//vide_tag - abc,programming 
	//			

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<CertificateBean> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<CertificateBean> certificates) {
		this.certificates = certificates;
	}

	
}
