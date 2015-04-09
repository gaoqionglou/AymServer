package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.User;
import util.HibernateSessionFactory;

public class UserDao {
	/**��ѯ����
	 * @param phonenum
	 * @return
	 */
	public User getUserByPhonenum(String phonenum){
		User user = null;
		user=(User)HibernateSessionFactory.getSession().get(User.class, phonenum);
		HibernateSessionFactory.closeSession();
		return user;
	}
   
	/**�������
	 * @param user
	 */
	public void insertUser(User user){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tran = session.beginTransaction();
		session.save(user);
		tran.commit();
		session.close();
	}
	/** �޸��������
	 * @param psw
	 */
	public void update(String phonenum,String password){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session =sf.openSession();
		User user = (User) session.get(User.class, phonenum);
		if(user!=null){
			user.setPassword(password);
			Transaction tran =session.beginTransaction();
			session.update(user);
			tran.commit();
		}
		session.close();
	}
}
