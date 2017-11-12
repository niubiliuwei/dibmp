package cn.mldn.dibmp.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private Long         gid; //商品编号
	private String      name;  // 商品名称
	private Long        wiid; //仓库分类表id
	private Double     price; // 商品价格
	private Double    weight;//商品重量
	private String     photo; //商品图片
	private String      note; // 备注信息
	private Long       stid ; //商品子分类id
	private Date      lastin; //最后入库时间
	private int      stornum; // 库存量
	private String recorder ; //录入员工
	private int      delflag; // 非0为待出库商品添加成功
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getWiid() {
		return wiid;
	}
	public void setWiid(Long wiid) {
		this.wiid = wiid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
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
	public Long getStid() {
		return stid;
	}
	public void setStid(Long stid) {
		this.stid = stid;
	}
	public Date getLastin() {
		return lastin;
	}
	public void setLastin(Date lastin) {
		this.lastin = lastin;
	}
	public int getStornum() {
		return stornum;
	}
	public void setStornum(int stornum) {
		this.stornum = stornum;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", name=" + name + ", wiid=" + wiid + ", price=" + price + ", weight=" + weight
				+ ", photo=" + photo + ", note=" + note + ", stid=" + stid + ", lastin=" + lastin + ", stornum="
				+ stornum + ", recorder=" + recorder + ", delflag=" + delflag + "]";
	}
	
}
