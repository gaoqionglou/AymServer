package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import po.User;
import util.GsonUtil;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class ModifyPswAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private String phonenum;
	private String password;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String getPhonenum() {

		return phonenum;
	}

	public void setPhonenum(String phonenum) {

		this.phonenum = phonenum;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
    public void modifyPsw() throws IOException{
    	UserDao dao = new UserDao();
    	User user = dao.getUserByPhonenum(phonenum);
    	String json;
    	if(user==null){
    		user = new User();
    		user.setHead("011");
    		json = GsonUtil.createJsonString(user);
    		response.getWriter().write(json);
    	}else{
    		dao.update(phonenum, password);
    		user.setHead("111");
    		json=GsonUtil.createJsonString(user);
    		response.getWriter().write(json);
    	}
    }
}
