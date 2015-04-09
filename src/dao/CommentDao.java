package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import po.CommentInfo;
import util.HibernateSessionFactory;

public class CommentDao {
    public void addComment(CommentInfo comment){
    	Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tran = session.beginTransaction();
		session.save(comment);
		tran.commit();
		session.close();
    }
    
    public List<CommentInfo> getCommentListById(int _id){
    	List<CommentInfo> comments = new ArrayList<CommentInfo>();
    	Session session = HibernateSessionFactory.getSession();
        Criteria cri = session.createCriteria(CommentInfo.class);
        cri.add(Restrictions.eq("id", _id));
        List list=cri.list();
        
        for(int i=0;i<list.size();i++){
        	CommentInfo commentInfo = (CommentInfo)list.get(i);
        	comments.add(commentInfo);
        }
    	return comments;
    }
}
