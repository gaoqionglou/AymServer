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
import po.Temp;

import sun.jdbc.odbc.OdbcDef;
import util.GsonUtil;
import util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class GetMaxSizeAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
    private String type; //recommend-ÍÆ¼ö £¬ friend-ÅóÓÑÈ¦£¬around-¸½½ü
   
    private HttpServletRequest request;
	private HttpServletResponse response;
    
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
    
	public void getMaxsize() throws IOException{
		Session session = HibernateSessionFactory.getSession();
		Query query=null;
		Temp tmp = null;
		if(type.equals("recommed")){
//			tmp = new Temp()
			query= session.createQuery("select count(item) from ItemInfo as item");
             response.getWriter().write(query.uniqueResult().toString());
//			System.out.println(query.uniqueResult().toString());
		}else {
			query= session.createQuery("select count(item) from ItemInfo as item where item.topic='"+type+"'");
            response.getWriter().write(query.uniqueResult().toString());
		}
	}
}
