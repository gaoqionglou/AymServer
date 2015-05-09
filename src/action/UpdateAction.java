package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import util.GsonUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
   private String host="http://172.25.161.5:8080/AymServer";
	private String updateUrl=host+"/update/Aym.apk";
	private String versionName;
   private String updateversion="1.1";
   private HttpServletRequest request;
  	private HttpServletResponse response;
	public String getVersionName() {
	return versionName;
}

public void setVersionName(String versionName) {
	this.versionName = versionName;
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
  public void update() throws IOException{
	  request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
	  if(versionName.equals(updateversion)){
		  System.out.println(updateUrl);
			response.getWriter().write(updateUrl);
	  }else{
		  response.getWriter().write(updateUrl);
	  }
  }
}
