package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import po.CommentInfo;
import util.GsonUtil;

import com.opensymphony.xwork2.ActionSupport;

import dao.CommentDao;

public class GetCommentAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
    private String id;
    private HttpServletRequest request;
    private HttpServletResponse response;
	
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
    
	public void getComment() throws IOException{
       response.setCharacterEncoding("gb2312");
		CommentDao dao = new CommentDao();
       int _id=Integer.parseInt(id);
       List<CommentInfo> coments= dao.getCommentListById(_id);
       response.getWriter().write(GsonUtil.createJsonString(coments));
    }
}
