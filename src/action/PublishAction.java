package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import po.ItemInfo;

import com.opensymphony.xwork2.ActionSupport;

import dao.ItemDao;

public class PublishAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private String phonenum; // 发布者的手机号
	private String image_uri; // 图片链接
	private String topic; // 话题
	private String location; // 地址
	private String msg;// 内容
	private String comment_num; // 评论数
	private String like_num; // 点赞数

	private HttpServletRequest request;
	private HttpServletResponse response;

	
	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getImage_uri() {
		return image_uri;
	}

	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getComment_num() {
		return comment_num;
	}

	public void setComment_num(String comment_num) {
		this.comment_num = comment_num;
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
  
	public void publish() throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
		ItemInfo item = new ItemInfo(phonenum,image_uri,topic,location,msg,comment_num,like_num);
		ItemDao dao = new ItemDao();
		dao.addItem(item);
		response.getWriter().write("1");
	}
}
