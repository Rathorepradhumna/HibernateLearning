package hibernate04.demo_one_to_many_with_review;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class CreateDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate04-one-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
/*			Instructor tempInstructor = new Instructor("Pradhumna" , "rathore" ,"pradhumna@gmail.com");
			
			InstructorDetails tempInstructorDetails = 
					new InstructorDetails("youtube.com/pradhumna" , "watching series");
*/	
			Instructor tempInstructor = new Instructor("Namrata" , "Soni" ,"namrata@gmail.com");
			
			InstructorDetails tempInstructorDetails = 
					new InstructorDetails("youtube.com/namrata" , "watching movie");
			
			tempInstructor.setInstructorDetail(tempInstructorDetails);
		   
			session.beginTransaction();
		
			log.info("saving instructor");
			session.save(tempInstructor);
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
