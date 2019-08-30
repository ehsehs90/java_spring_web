package biz.vo;

public class MailVO {
	private int num;
	private String id;
	private String fid;
	private String why;
	private String msg;
	
	public MailVO() {
		super();
	}

	public MailVO(int num, String id, String fid, String why, String msg) {
		super();
		this.num = num;
		this.id = id;
		this.fid = fid; 
		this.why = why;
		this.msg = msg;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MailVO [num=" + num + ", id=" + id + ", fid=" + fid + ", why=" + why + ", msg=" + msg + "]";
	}

}
