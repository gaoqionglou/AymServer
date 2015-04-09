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

public class RegisterAction extends ActionSupport implements
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
	public void register() throws IOException{
		User user  = null;
		UserDao dao = new UserDao();
		user=dao.getUserByPhonenum(phonenum);
		if(user==null){
		user = new User(phonenum,password);
		dao.insertUser(user);
		user.setHead("11");
		System.out.println(user.toString());
		response.getWriter().write(GsonUtil.createJsonString(user));
		}else{
			user.setHead("10");
			response.getWriter().write(GsonUtil.createJsonString(user));
		}
	}

}
