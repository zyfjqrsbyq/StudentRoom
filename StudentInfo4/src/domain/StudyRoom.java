package domain;

public class StudyRoom {
       private String srno;//自习室号
       private int lno;//楼层号
       private String rname;//自习楼名
       private String uno;//楼管员工号
	
	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getUno() {
		return uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	@Override
	public String toString() {
		return "StudyRoom[srno=" + srno+ ", lno=" + lno + ", rname=" + rname + ", uno=" + uno +"]";
	}
}
