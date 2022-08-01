package domain;

public class RoomProperty {
      private String rpno;//自习室财产编号
      private String rpname;//名称
      private String srno;//所在自习室编号
      private String location;//所在位置
	
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

	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "RoomProperty[rpno=" + rpno + ", rpname=" + rpname+ ", srno=" + srno+ ", location=" + location +"]";
	}
}
