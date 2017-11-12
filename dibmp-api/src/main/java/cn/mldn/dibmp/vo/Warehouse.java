package cn.mldn.dibmp.vo;

import java.io.Serializable;

public class Warehouse implements Serializable {
	private   Long	wid		; //仓库编号	 bigint AUTO_INCREMENT ,
	private String  name	;	//仓库名称	varchar(50) ,
	private   Long   pid		; //仓库所在省份bigint ,
	private   Long   cid		;	//仓库所在城市bigint ,
	private   Long   wiid		;	//存储分类bigint ,
	private String   address	;	//仓库地址 varchar(50) ,
	private Double   area		;	//仓库面积 double ,
	private int   maximum	;	//存储上限 int ,
	private int   currnum	;	//当前存储量 int ,
	private String   photo	;	//仓库照片varchar(200) ,
	private String  note		;	//仓库备注信息：text ,
	private String   recorder	;	//管理员姓名varchar(50) ,
	private String  admin	;	//级别 varchar(50) ,
	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getWiid() {
		return wiid;
	}
	public void setWiid(Long wiid) {
		this.wiid = wiid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getCurrnum() {
		return currnum;
	}
	public void setCurrnum(int currnum) {
		this.currnum = currnum;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Warehouse [wid=" + wid + ", name=" + name + ", pid=" + pid + ", cid=" + cid + ", wiid=" + wiid
				+ ", address=" + address + ", area=" + area + ", maximum=" + maximum + ", currnum=" + currnum
				+ ", photo=" + photo + ", note=" + note + ", recorder=" + recorder + ", admin=" + admin + "]";
	}
	
}
