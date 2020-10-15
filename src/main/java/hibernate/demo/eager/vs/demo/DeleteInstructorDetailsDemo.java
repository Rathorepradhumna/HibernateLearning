package hibernate.demo.eager.vs.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;
import jdk.internal.org.jline.utils.Log;


public class DeleteInstructorDetailsDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteInstructorDetailsDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-one.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		   
			session.beginTransaction();
			int theId = 4;
			InstructorDetails tempInstructorDetails = session.get(InstructorDetails.class, theId);
			
		    log.info("tempInstructorDetails " + tempInstructorDetails);
			log.info("the associated instructor : " + tempInstructorDetails.getInstructor());
			log.info("deleting " + tempInstructorDetails);
			
			tempInstructorDetails.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetails);
			
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
