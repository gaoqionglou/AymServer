package po;

public class ActivityInfo {
	private int id;
	private String title;
	private String imageUri;
	private String startTime;
	private String endTime;
	private int state; // 1-�����У� 0-������

    public ActivityInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public ActivityInfo(int id, String title, String imageUri,
			String startTime, String endTime, int state) {
		super();
		this.id = id;
		this.title = title;
		this.imageUri = imageUri;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ActivityInfo [id=" + id + ", imageUri=" + imageUri + ", title="
				+ title + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", state=" + state + "]";
	}
}
