package java76.pms.domain;

import java.io.Serializable;

public class Student implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected int    no;
  protected String name;
  protected String email;
  protected String tel;
  protected String cid; // class ID
  protected String photo;
  protected String password;
 
  public Student() {}

	@Override
	public String toString() {
	return "Student [no=" + no + ", name=" + name + ", email=" + email + ", tel=" + tel + ", cid=" + cid + ", photo="
		+ photo + ", password=" + password + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 

}









