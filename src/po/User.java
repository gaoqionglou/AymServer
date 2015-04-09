package po;

public class User {
	private String head; //11-³É¹¦µÇÂ¼ 10-ÃÜÂë´íÎó 00-ÊÖ»úºÅÎ´×¢²á
	private String phonenum;
	private String password;
	public User(){
		
	}
	public User(String phonenum, String password) {
		super();
		this.phonenum = phonenum;
		this.password = password;
	}

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

	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "User [head=" + head + ", phonenum=" + phonenum + ", password="
				+ password + "]";
	}
	

}
