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

public class LoginAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
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

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void login() throws IOException {
		UserDao dao = new UserDao();
		User user = dao.getUserByPhonenum(phonenum);
		System.out.println(phonenum + "," + password);
		
		String json="";
		if (user != null) {
			if (user.getPassword().equals(password)) {
				user.setHead("11");//³É¹¦µÇÂ¼
			}else{
				user.setHead("10");//ÃÜÂë´íÎó
			}
		}else{
			user = new User();
			user.setHead("00"); //Î´×¢²áÓÃ»§
		}
		System.out.println(user.toString());
		 json = GsonUtil.createJsonString(user); 
		response.getWriter().write(json);
	}
}
