package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {

  private static final long serialVersionUID = 1L;
  
  protected int no;
  protected String title;
  protected String content;
  protected Date createdDate;
  protected int views;
  protected String password;
  protected String attachFile; // 컬럼명 = afile

  public Board() {
  }

	@Override
	public String toString() {
	return "Board [no=" + no + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate + ", views="
		+ views + ", password=" + password + ", attachFile=" + attachFile + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
  

}
