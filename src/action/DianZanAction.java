package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.ItemDao;

public class DianZanAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
     private String id;
     private String like_num;
     private HttpServletRequest request;
     private HttpServletResponse response;
	
     
     public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLike_num() {
		return like_num;
	}

	public void setLike_num(String like_num) {
		this.like_num = like_num;
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
   
	public void dianzan() throws IOException{
		ItemDao dao = new ItemDao();
		dao.updateItem(Integer.parseInt(id), like_num);
		response.getWriter().write("1");
	}
}
