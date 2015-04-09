package po;

public class ItemInfo {
    private int id; //����ID��1��ʼ����
	private String phonenum; //�����ߵ��ֻ��� 
	private String image_uri; //ͼƬ����
     private String topic; //����
     private String location; //��ַ
     private String msg;//����
     private String comment_num; //������
     private String like_num; //������
	private String maxsize; //�������
     
	public ItemInfo(){
		
	}
	
     public ItemInfo(String phonenum, String image_uri, String topic,
			String location, String msg, String comment_num, String like_num) {
		super();
		this.phonenum = phonenum;
		this.image_uri = image_uri;
		this.topic = topic;
		this.location = location;
		this.msg = msg;
		this.comment_num = comment_num;
		this.like_num = like_num;
	}

	public ItemInfo(int id,String phonenum, String image_uri, String topic,
			String location, String msg,String comment_num, String like_num) {
		super();
		this.id=id;
		this.phonenum = phonenum;
		this.image_uri = image_uri;
		this.topic = topic;
		this.location = location;
		this.msg=msg;
		this.comment_num = comment_num;
		this.like_num = like_num;
	}
	
     public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
   
	public String getMaxsize() {
		return maxsize;
	}

	public void setMaxsize(String maxsize) {
		this.maxsize = maxsize;
	}

	@Override
	public String toString() {
		return "ItemInfo [id=" + id + ", phonenum=" + phonenum + ", image_uri="
				+ image_uri + ", topic=" + topic + ", location=" + location
				+ ", msg=" + msg + ", comment_num=" + comment_num
				+ ", like_num=" + like_num + ", maxsize=" + maxsize + "]";
	}

     
}
