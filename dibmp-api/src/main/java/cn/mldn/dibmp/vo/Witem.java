package cn.mldn.dibmp.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Witem implements Serializable {
	private Long	wiid ; //商品分类id
	private String title; // 商品分类标题
	public Long getWiid() {
		return wiid;
	}
	public void setWiid(Long wiid) {
		this.wiid = wiid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Witem [wiid=" + wiid + ", title=" + title + "]";
	}

}
