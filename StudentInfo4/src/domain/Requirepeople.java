package domain;

public class Requirepeople {
       private int reno;//报修人工号
       private String rename;//报修人姓名
       private String company;//报修人公司
       private String phone;//报修人电话
       private String pingjia;//评价
	
	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPingjia() {
		return pingjia;
	}

	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}

	@Override
	public String toString() {
		return "Requirepeople[reno=" + reno + ", rename=" + rename+ ", company=" + company+ ", phone=" + phone+",pingjia=" + pingjia +"]";
	}
}
