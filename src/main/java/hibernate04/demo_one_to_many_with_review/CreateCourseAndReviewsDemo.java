package hibernate04.demo_one_to_many_with_review;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class CreateCourseAndReviewsDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateCourseAndReviewsDemo.class.getName());  
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
        	
        	Course tempCourse = new Course("Spring");
        	tempCourse.add(new Review("very good"));
        	tempCourse.add(new Review("average"));
        	tempCourse.add(new Review("very bad"));
        	
        	log.info("saving the review" + tempCourse.getReviews()+"\n");
        	
        	session.save(tempCourse);
        	
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
