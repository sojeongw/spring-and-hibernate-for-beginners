package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	// define our fields
	
	// define constructors
	
	// define getter setters
	
	// define tostring
	
	// annotate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})	// don't want to apply the cascading deletes with REMOVE
	@JoinColumn(name="instructor_id")
	/* it's in the Course table. Course has an instructor_id column,
	that has the key that points back to the actual instructor. 
	So that's the mapping or the annotation that we set up
	so the course know how to find its given instructor. */
	private Instructor instructor;	// course is related instructor.
	
	public Course() {
			
	}
	
	
	// id는 자동 생성되고, instructor는 나중에 set해줄 예정이므로 title만 생성한다.
	public Course(String title) {
		this.title = title;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
}
