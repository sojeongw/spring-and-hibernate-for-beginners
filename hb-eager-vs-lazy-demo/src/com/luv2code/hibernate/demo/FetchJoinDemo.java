package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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

			// solution 2. Hibernate query with HQL
			// when executed, will load instructor and courses all at once
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);
			
			
			// set parameter on query
			// arg 1 = 위에서 i.id=:에 쓰인 이름.
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			// load instructor and courses all at once
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// since courses are lazy loaded, this should fail
			session.close();
			System.out.println("luv2code: THe session is now closed\n" + "luv2code: Instructor: " 
							+ tempInstructor.getCourses());

			System.out.println("luv2code: Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
