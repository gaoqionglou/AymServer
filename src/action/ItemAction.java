package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import po.ItemInfo;
import util.GsonUtil;
import util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response; 
	private String from;
	    private String to;
	
	    
	    public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
        this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
   this.request=arg0;
	}
  public void getItem() throws IOException{
	  Session session = HibernateSessionFactory.getSession();
	  request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
		Query query_1= null,query_2=null;
		List list_1=null,list_2=null;
		List<ItemInfo> items = new ArrayList<ItemInfo>();
		query_2 = session.createQuery("select count(item) from ItemInfo as item");
		System.out.println(query_2.uniqueResult().toString());
//		if(type.equals("recommed")){
			try {
//				String hql_1 ="select item.id,item.phonenum,item.image_uri,item.topic,item.location,item.msg,item.comment_num,item.like_num from ItemInfo as item  where item.id between '"+from+"' and '" +to+"' order by ID desc";
				String hql_1 ="select item.id,item.phonenum,item.image_uri,item.topic,item.location,item.msg,item.comment_num,item.like_num from ItemInfo as item  where item.id ="+from;
				query_1  = session.createQuery(hql_1);
				
				list_1 = query_1.list();
				System.out.println(list_1.size()+" " +from+" "+ to);
				for(int i=0;i<list_1.size();i++){
					Object[] objs =(Object[])list_1.get(i);
					ItemInfo iteminfo = new ItemInfo(Integer.parseInt(objs[0].toString()), objs[1].toString(), objs[2].toString(), objs[3].toString(), objs[4].toString(), objs[5].toString(),objs[6].toString(),objs[7].toString());
					iteminfo.setMaxsize(query_2.uniqueResult().toString());
					System.out.println(iteminfo.toString());
					items.add(iteminfo);
					
				}
				System.out.println("item="+items.toString());
				response.getWriter().write(GsonUtil.createJsonString(items));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}else{
//			
//		}
  }
}
