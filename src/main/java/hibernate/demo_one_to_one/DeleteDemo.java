package hibernate.demo_one_to_one;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class DeleteDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-one.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		   
			session.beginTransaction();
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			log.info("instructor found : " + tempInstructor);
			if(tempInstructor!=null) {
				log.info("deleting"  + tempInstructor);
				session.delete(tempInstructor);
			}
		
			session.getTransaction().commit();
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
