package hibernate.demo;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class QueryStudentDemo {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(QueryStudentDemo.class.getName());  
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(log,theStudents);
			
			// query students: lastName='Rathore'
			theStudents = session.createQuery("from Student s where s.lastName='Rathore'").getResultList();
			
			// display the students
			log.info("\n\nStudents who have last name of Doe");
			displayStudents(log,theStudents);
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			log.info("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(Logger log,List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			log.info(tempStudent);
		}
	}
}
