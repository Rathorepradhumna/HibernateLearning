package hibernate.demo_one_to_many;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class CreateInstructorDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateInstructorDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate-one-to-many.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			Instructor tempInstructor = new Instructor("Pradhumna" , "Rathore" ,"pradhumna@gmail.com");
			
			InstructorDetails tempInstructorDetails = 
					new InstructorDetails("youtube.com/pradhumna" , "watching movie");
			
			tempInstructor.setInstructorDetail(tempInstructorDetails);
		   
			session.beginTransaction();
		
			log.info("saving instructor");
			session.save(tempInstructor);
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			session.close();
			factory.close();
		}
									
	}
}
