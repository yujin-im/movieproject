package com.VO;

public class MemberDTO {
	String mb_id;
	String mb_pw;
	String mb_name;
	String mb_birthdate;
	String mb_gender;
	String mb_joindate;
	String mb_type;
	
	public MemberDTO(String mb_id, String mb_pw, String mb_name, String mb_birthdate, String mb_gender,
			String mb_joindate, String mb_type) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
		this.mb_birthdate = mb_birthdate;
		this.mb_gender = mb_gender;
		this.mb_joindate = mb_joindate;
		this.mb_type = mb_type;
	}
	public MemberDTO(String mb_id, String mb_pw, String mb_name, String mb_birthdate, String mb_gender
			) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
		this.mb_birthdate = mb_birthdate;
		this.mb_gender = mb_gender;

	}
	public MemberDTO(String mb_id, String mb_pw
			) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		

	}
	public MemberDTO(String mb_id, String mb_pw,String mb_name
			) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;

	}
	
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}


	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}


	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}


	public void setMb_birthdate(String mb_birthdate) {
		this.mb_birthdate = mb_birthdate;
	}


	public void setMb_gender(String mb_gender) {
		this.mb_gender = mb_gender;
	}


	public void setMb_joindate(String mb_joindate) {
		this.mb_joindate = mb_joindate;
	}


	public void setMb_type(String mb_type) {
		this.mb_type = mb_type;
	}


	public String getMb_id() {
		return mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public String getMb_name() {
		return mb_name;
	}
	public String getMb_birthdate() {
		return mb_birthdate;
	}
	public String getMb_gender() {
		return mb_gender;
	}
	public String getMb_joindate() {
		return mb_joindate;
	}
	public String getMb_type() {
		return mb_type;
	}

}
