package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;

import po.ActivityInfo;

import util.GsonUtil;
import util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class GetActivityAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String type;
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
    public void getActivity() throws Exception{
		Session session = HibernateSessionFactory.getSession();
		Query query =null;
		List list=null;
		List<ActivityInfo> infos = new ArrayList<ActivityInfo>();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
    	if("all".equals(type)){
    		String hql="select a.id,a.title,a.imageUri,a.startTime,a.endTime,a.state from ActivityInfo as a";
    		query=session.createQuery(hql);
    		list=query.list();
    		for(int i=0;i<list.size();i++){
    			Object[] objs =(Object[])list.get(i);
    			ActivityInfo activityInfo = new ActivityInfo(Integer.parseInt(objs[0].toString()), objs[1].toString(), objs[2].toString(), objs[3].toString(), objs[4].toString(), Integer.parseInt(objs[5].toString()));
    			infos.add(activityInfo);
    		}
    	}
    	System.out.println(infos.toString());
    	response.getWriter().write(GsonUtil.createJsonString(infos));
    }
}
