package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;

import po.ItemInfo;

import sun.jdbc.odbc.OdbcDef;
import util.GsonUtil;
import util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class SelectListAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
    private String type; //recommend-ÍÆ¼ö £¬ friend-ÅóÓÑÈ¦£¬around-¸½½ü
    private String location;
    private String from;
    private String to;
    private HttpServletRequest request;
	private HttpServletResponse response;
    
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

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
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
        this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
        this.request=request;
	}
    
	public void selectList() throws IOException{
		Session session = HibernateSessionFactory.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
		System.out.println(toString());
		Query query_1= null,query_2=null;
		List list_1=null,list_2=null;
		List<ItemInfo> items = new ArrayList<ItemInfo>();
		query_2 = session.createQuery("select count(item) from ItemInfo as item");
		System.out.println(query_2.uniqueResult().toString());
		if(type.equals("recommed")){
			
			String hql_1 ="select item.id,item.phonenum,item.image_uri,item.topic,item.location,item.msg,item.comment_num,item.like_num from ItemInfo as item  where item.id between '"+from+"' and '" +to+"' order by ID desc";
			query_1  = session.createQuery(hql_1);
		    
			list_1 = query_1.list();
			for(int i=0;i<list_1.size();i++){
				Object[] objs =(Object[])list_1.get(i);
				ItemInfo iteminfo = new ItemInfo(Integer.parseInt(objs[0].toString()), objs[1].toString(), objs[2].toString(), objs[3].toString(), objs[4].toString(), objs[5].toString(),objs[6].toString(),objs[7].toString());
				iteminfo.setMaxsize(query_2.uniqueResult().toString());
				items.add(iteminfo);
			}
			System.out.println(items.toString());
			response.getWriter().write(GsonUtil.createJsonString(items));
		}else if(!type.equals("recommed")&&"".equals(location)){
			
			String hql ="select item.id,item.phonenum,item.image_uri,item.topic,item.location,item.msg,item.comment_num,item.like_num from ItemInfo as item  where item.topic='"+type+"' order by ID desc";
			query_1  = session.createQuery(hql);
		    
			list_1 = query_1.list();
			for(int i=0;i<list_1.size();i++){
				Object[] objs =(Object[])list_1.get(i);
				ItemInfo iteminfo = new ItemInfo(Integer.parseInt(objs[0].toString()), objs[1].toString(), objs[2].toString(), objs[3].toString(), objs[4].toString(), objs[5].toString(),objs[6].toString(),objs[7].toString());
				iteminfo.setMaxsize(query_2.uniqueResult().toString());
				items.add(iteminfo);
			}
			System.out.println(items.toString());
			response.getWriter().write(GsonUtil.createJsonString(items));
		}else if(!"".equals(location)&&location!=null){
			
			String hql ="select item.id,item.phonenum,item.image_uri,item.topic,item.location,item.msg,item.comment_num,item.like_num from ItemInfo as item  where item.location='"+location+"' order by ID desc";
			query_1  = session.createQuery(hql);
		    
			list_1 = query_1.list();
			for(int i=0;i<list_1.size();i++){
				Object[] objs =(Object[])list_1.get(i);
				ItemInfo iteminfo = new ItemInfo(Integer.parseInt(objs[0].toString()), objs[1].toString(), objs[2].toString(), objs[3].toString(), objs[4].toString(), objs[5].toString(),objs[6].toString(),objs[7].toString());
				iteminfo.setMaxsize(query_2.uniqueResult().toString());
				items.add(iteminfo);
			}
			System.out.println(items.toString());
			response.getWriter().write(GsonUtil.createJsonString(items));
		}
	}

	@Override
	public String toString() {
		return "SelectListAction [type=" + type + ", location=" + location
				+ ", from=" + from + ", to=" + to + "]";
	}
	
}
