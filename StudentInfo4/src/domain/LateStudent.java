package domain;

public class LateStudent {
     private int sno;//学号
     private int rno;//自习号
     private String sname;//姓名
     private String reason;//原因
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "LateStudent[sno=" + sno + ", rno=" + rno+ ", sname=" + sname+ ", reason=" + reason +"]";
	}
      
     
}
