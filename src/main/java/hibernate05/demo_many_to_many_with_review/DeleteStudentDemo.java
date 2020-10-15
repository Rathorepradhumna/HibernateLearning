package hibernate05.demo_many_to_many_with_review;

import org.hibernate.cfg.Configuration;

import demo.entity.StudentDemo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class DeleteStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteStudentDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate05-many-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
        	session.beginTransaction();
        	int sundentId = 3;
        	Student tempStudent = session.get(Student.class, sundentId);

        	log.info("deleting  " + tempStudent);
        	session.delete(tempStudent);
        	session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
