package hibernate.demo_one_to_many;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class DeleteCourseDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteCourseDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
        	session.beginTransaction();
        	int theId = 10;
        	Course tempCourse = session.get(Course.class, theId);
        	log.info("deleting : " + tempCourse);
        	session.delete(tempCourse);
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
