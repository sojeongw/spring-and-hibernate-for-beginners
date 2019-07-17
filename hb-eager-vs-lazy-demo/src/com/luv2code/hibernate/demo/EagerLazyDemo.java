package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)	// 새로운 클래스 추가 
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// start a transaction
			session.beginTransaction();

			// lazy 일 때는 instructor와 instructor detail만 get 한다.
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// lazy라서 course 정보가 나타나지 않는다.
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// solution 1. Execute while session is open
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// since courses are lazy loaded, this should fail
			session.close();
			System.out.println("luv2code: THe session is now closed\n" + tempInstructor.getCourses());

			System.out.println("luv2code: Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
