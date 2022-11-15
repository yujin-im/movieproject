package com.VO;

public class OttDTO{
	String video_seq;
	String video_type;
	String video_title;
	String video_content;
	String video_img;
	String video_open_date;
	String video_close_date;
	String video_rating;
	String video_runtime;
	String video_country;
	String video_ott;
	String genre_seq;
	String mb_id;
	
	public OttDTO(String video_seq, String video_type, String video_title, String video_content, String video_img,
			String video_open_date, String video_close_date, String video_rating, String video_runtime,
			String video_country, String video_ott, String genre_seq, String mb_id) {
		
		this.video_seq = video_seq;
		this.video_type = video_type;
		this.video_title = video_title;
		this.video_content = video_content;
		this.video_img = video_img;
		this.video_open_date = video_open_date;
		this.video_close_date = video_close_date;
		this.video_rating = video_rating;
		this.video_runtime = video_runtime;
		this.video_country = video_country;
		this.video_ott = video_ott;
		this.genre_seq = genre_seq;
		this.mb_id = mb_id;
	}
	
	public OttDTO(String video_type, String video_ott) {

		this.video_type = video_type;
		this.video_ott = video_ott;
		
	}

	public String getVideo_seq() {
		return video_seq;
	}

	public void setVideo_seq(String video_seq) {
		this.video_seq = video_seq;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public String getVideo_title() {
		return video_title;
	}

	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}

	public String getVideo_content() {
		return video_content;
	}

	public void setVideo_content(String video_content) {
		this.video_content = video_content;
	}

	public String getVideo_img() {
		return video_img;
	}

	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}

	public String getVideo_open_date() {
		return video_open_date;
	}

	public void setVideo_open_date(String video_open_date) {
		this.video_open_date = video_open_date;
	}

	public String getVideo_close_date() {
		return video_close_date;
	}

	public void setVideo_close_date(String video_close_date) {
		this.video_close_date = video_close_date;
	}

	public String getVideo_rating() {
		return video_rating;
	}

	public void setVideo_rating(String video_rating) {
		this.video_rating = video_rating;
	}

	public String getVideo_runtime() {
		return video_runtime;
	}

	public void setVideo_runtime(String video_runtime) {
		this.video_runtime = video_runtime;
	}

	public String getVideo_country() {
		return video_country;
	}

	public void setVideo_country(String video_country) {
		this.video_country = video_country;
	}

	public String getVideo_ott() {
		return video_ott;
	}

	public void setVideo_ott(String video_ott) {
		this.video_ott = video_ott;
	}

	public String getGenre_seq() {
		return genre_seq;
	}

	public void setGenre_seq(String genre_seq) {
		this.genre_seq = genre_seq;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
	
}
