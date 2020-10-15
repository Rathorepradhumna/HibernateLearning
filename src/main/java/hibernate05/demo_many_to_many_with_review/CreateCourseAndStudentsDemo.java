package hibernate05.demo_many_to_many_with_review;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class CreateCourseAndStudentsDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateCourseAndStudentsDemo.class.getName());  
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
        	
        	Course tempCourse = new Course("Spring");
        	Student tempStudent1 =  new Student("Pradhumna" , "Rathore" , "pradhumna@gmail.com");
        	Student tempStudent2 =  new Student("Namrata" , "Soni" , "namrata@gmail.com");
        	log.info("saving the students");
        	
        	tempCourse.addStundent(tempStudent1);
        	tempCourse.addStundent(tempStudent2);
        	session.save(tempCourse);
        	session.save(tempStudent1);
        	session.save(tempStudent2);
        	log.info("saved student " +  tempCourse.getStudents());
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
