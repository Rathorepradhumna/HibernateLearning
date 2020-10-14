package hibernate04.demo_one_to_many_with_review;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class DeleteCourseAndReviewsDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteCourseAndReviewsDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate04-one-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
        	session.beginTransaction();
        	
        	int theId = 10;
        	
        	Course tempCourse = session.get(Course.class, theId);
        	
        	log.info("deleting the course" + tempCourse);
        	log.info(tempCourse.getReviews());
        	
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
