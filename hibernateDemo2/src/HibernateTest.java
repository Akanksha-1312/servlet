import org.hibernate.Session;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message message = new Message(" Hibernate with annotaion "); 
		
		session.save(message);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
