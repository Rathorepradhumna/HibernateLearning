package hibernate.demo.eager.vs.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class CreateCourseDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateCourseDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
        	session.beginTransaction();
        	
        	int theId = 1;
        	Instructor tempInstructor = session.get(Instructor.class, theId);
        	
        	Course course1 = new Course("java");
        	Course course2 = new Course("python");
        	 
        	tempInstructor.add(course1);
        	tempInstructor.add(course2);
        	
        	session.save(course1);
        	session.save(course2);
        	
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
