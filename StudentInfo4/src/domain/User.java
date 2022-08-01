package domain;

public class User{

	private String uno;//工号
    private String uname;//姓名
    private String gender;//性别
    private int uage;//年龄
    private int lid;//管理楼号
    private String phone;//联系电话

    private String username;//用户名
    private String password;//密码
    

   
   
	public String getUno() {
		return uno;
	}




	public void setUno(String uno) {
		this.uno = uno;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public int getUage() {
		return uage;
	}




	public void setUage(int uage) {
		this.uage = uage;
	}




	public int getLid() {
		return lid;
	}




	public void setLid(int lid) {
		this.lid = lid;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
    public String toString() {
        return "User{" +
                "uno=" + uno+
                ", uname='" + uname + '\'' +
                ", gender='" + gender + '\'' +
                ", uage=" + uage +
                ", lid='" + lid + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
