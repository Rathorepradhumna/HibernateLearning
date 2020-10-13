package hibernate.demo_one_to_many;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;
import jdk.internal.org.jline.utils.Log;


public class GetInstructorDetailsDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(GetInstructorDetailsDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-one.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		   
			session.beginTransaction();
			int theId = 3;
			InstructorDetails tempInstructorDetails = session.get(InstructorDetails.class, theId);
			
		    log.info("tempInstructorDetails " + tempInstructorDetails);
			log.info("the associated instructor : " + tempInstructorDetails.getInstructor());
				
			session.getTransaction().commit();
			log.info("done");
		}
		catch(Exception e) {
			log.error(e);
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
