 	package com.javatechie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "STUDENT_TBL")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 private String name;
	 private int age;
	 private String dept;
	
	 @ManyToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinTable(name = "STUDENT_COURSE_TABLE",
	 		joinColumns = {
	 				@JoinColumn(name = "student_id",referencedColumnName = "id")
	 		},
	 		inverseJoinColumns = {
	 				@JoinColumn(name = "course_id",referencedColumnName = "id")
	 		}
			 )
	 @JsonManagedReference
	 private Set<Course> courses;

	public Student() {
		super();
	}

	public Student(long id, String name, int age, String dept, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.courses = courses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	 
	 
}
