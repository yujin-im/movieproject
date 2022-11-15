package com.VO;

public class GenreVO {

	String mb_seq;
	String mb_id;
	String mb_fav_genid;
	public GenreVO(String mb_seq, String mb_id, String mb_fav_genid) {
	
		this.mb_seq = mb_seq;
		this.mb_id = mb_id;
		this.mb_fav_genid = mb_fav_genid;
	}
	public String getMb_seq() {
		return mb_seq;
	}
	public void setMb_seq(String mb_seq) {
		this.mb_seq = mb_seq;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_fav_genid() {
		return mb_fav_genid;
	}
	public void setMb_fav_genid(String mb_fav_genid) {
		this.mb_fav_genid = mb_fav_genid;
	}
}
