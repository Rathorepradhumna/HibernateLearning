package hibernate.demo.eager.vs.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class FetchJoinDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(FetchJoinDemo.class.getName());  
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
        	
        	log.info("pradhumna Instructor : " + tempInstructor);
        	
        	
        
        	
        	session.getTransaction().commit();
        
       
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
