package com.javatechie.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "COURSE_TBL")
public class Course {
  
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String abbreviation;
	private int modules;
	private double fee;
	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	@JsonBackReference 
	private Set<Student> students;

	public Course() {
		super();
	}

	public Course(long id, String title, String abbreviation, int modules, double fee, Set<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.abbreviation = abbreviation;
		this.modules = modules;
		this.fee = fee;
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getModules() {
		return modules;
	}

	public void setModules(int modules) {
		this.modules = modules;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
