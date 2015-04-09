package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.CommentInfo;
import po.ItemInfo;
import util.HibernateSessionFactory;

public class ItemDao {
   public ItemInfo getItemById(int id){
	   ItemInfo item=null;
	   item=(ItemInfo)HibernateSessionFactory.getSession().get(ItemInfo.class, id);
	   HibernateSessionFactory.closeSession();
	   return item;
   }
   
   public void updateItem(int id,String like_num){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session =sf.openSession();
		ItemInfo item = (ItemInfo) session.get(ItemInfo.class, id);
		if(item!=null){
			item.setLike_num(like_num);
			Transaction tran =session.beginTransaction();
			session.update(item);
			tran.commit();
		}
		session.close();
   }
   
   public void addItem(ItemInfo item){
   	Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tran = session.beginTransaction();
		session.save(item);
		tran.commit();
		session.close();
   }
}
