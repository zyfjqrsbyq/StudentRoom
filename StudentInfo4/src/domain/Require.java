package domain;

public class Require {
	private String rpno;//报修物品编号
	private String rpname;//报修物品名称
	private String reno;//报修人姓名
	private String date;//报修日期
	
	public String getRpno() {
		return rpno;
	}

	public void setRpno(String rpno) {
		this.rpno = rpno;
	}

	public String getRpname() {
		return rpname;
	}

	public void setRpname(String rpname) {
		this.rpname = rpname;
	}

	public String getReno() {
		return reno;
	}

	public void setReno(String reno) {
		this.reno = reno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Require[rpno=" + rpno + ", rpname=" + rpname+ ", reno=" + reno+ ", date=" + date +"]";
	}

}
