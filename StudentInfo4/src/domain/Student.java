package domain;

public class Student {
	
	private String sno;//学号
	private String rno;//自习号
	private int classno;//班级
    private String sname;//姓名
    private String Sdept;//系名
    private String phone;//联系电话
    private String ruxue;//入学日期
    
	
	
	public String getSno() {
		return sno;
	}



	public void setSno(String sno) {
		this.sno = sno;
	}



	public String getRno() {
		return rno;
	}



	public void setRno(String rno) {
		this.rno = rno;
	}



	public int getClassno() {
		return classno;
	}



	public void setClassno(int classno) {
		this.classno = classno;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getSdept() {
		return Sdept;
	}



	public void setSdept(String sdept) {
		Sdept = sdept;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getRuxue() {
		return ruxue;
	}



	public void setRuxue(String ruxue) {
		this.ruxue = ruxue;
	}



	@Override
	public String toString() {
		return "Student [sno=" + sno + ", rno=" + rno + ", classno=" + classno + ", sname=" + sname + ", Sdept=" + Sdept
				+ ", phone=" + phone + ", ruxue=" + ruxue + "]";
	}
   
    
}
