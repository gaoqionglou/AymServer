package action;

import java.io.IOException;
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
import po.TopicInfo;
import util.GsonUtil;
import util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class GetTopicAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private String type;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void getTopic() throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("gb2312");
		Session session = HibernateSessionFactory.getSession();
		Query query = null;
		List list = null;
		List<TopicInfo> infos = new ArrayList<TopicInfo>();
//		if ("all".equals(type)) {
			String hql = "select a.id,a.title,a.imageUri,a.introduction,a.num from TopicInfo as a";
			query = session.createQuery(hql);
			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = (Object[]) list.get(i);
				TopicInfo topicInfo = new TopicInfo(Integer.parseInt(objs[0]
						.toString()), objs[1].toString(), objs[2].toString(),
						objs[3].toString(),
						Integer.parseInt(objs[4].toString()));
				infos.add(topicInfo);
			}
//		}
		response.getWriter().write(GsonUtil.createJsonString(infos));
	}
}
