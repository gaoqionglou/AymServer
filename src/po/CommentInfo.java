package po;

public class CommentInfo {
	private int no; //����������Ϊ1
	private int id;//��Ʒ��־id
	private String phonenum;//�������ֻ���
	private String msg;//��������
	private String date;//����ʱ��
	
	public CommentInfo() {
		// TODO Auto-generated constructor stub
	}
	public CommentInfo( int no,int id, String phonenum, String msg,String date) {
		super();
		this.no=no;
		this.id = id;
		this.phonenum = phonenum;
		this.msg = msg;
		this.date=date;
	}
	public CommentInfo(int id, String phonenum, String msg,String date) {
		super();
		this.id = id;
		this.phonenum = phonenum;
		this.msg = msg;
		this.date=date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String toString() {
		return "CommentInfo [no=" + no + ", id=" + id + ", phonenum="
				+ phonenum + ", msg=" + msg + ", date=" + date + "]";
	}
}
