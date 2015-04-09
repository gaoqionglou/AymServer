package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import po.CommentInfo;

import com.opensymphony.xwork2.ActionSupport;

import dao.CommentDao;

public class SendCommentAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
    private String id;
    private String phonenum;
    private String msg;
    private String date;
    private HttpServletRequest request;
    private HttpServletResponse response;
	
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
    
	public void sendComment() throws IOException{
    	CommentDao dao  = new CommentDao();
    	CommentInfo comment = new  CommentInfo(Integer.parseInt(id),phonenum,msg,date);
    	dao.addComment(comment);
    	response.getWriter().write("1");
    }
}
