package com.gmiskos.hibernate.demo.OneToOne.bidirectional.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gmiskos.hibernate.demo.OneToOne.bidirectional.entity.*;


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
						
			// print  the associated instructor
			System.out.println("the associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " 
											+ tempInstructorDetail);

			/*
			 * if we change tha cascade type in instructor detail
			 * in order to delete only the instructor detail.
			 * then before deleting instructor details
			 * we have to remove the connection before deleting.
			 * Like 
			 * tempInstructorDetail.getInstructor().setInstructorDetail(null);
			 */
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}





