package com.VO;

public class CommentVO {

	
	int cmt_seq;
	int article_seq;
	String cmt_content;
	String cmt_date;
	String m_id;
	public CommentVO(int cmt_seq, int article_seq, String cmt_content, String cmt_date, String m_id) {

		this.cmt_seq = cmt_seq;
		this.article_seq = article_seq;
		this.cmt_content = cmt_content;
		this.cmt_date = cmt_date;
		this.m_id = m_id;
	}
	public int getCmt_seq() {
		return cmt_seq;
	}
	public void setCmt_seq(int cmt_seq) {
		this.cmt_seq = cmt_seq;
	}
	public int getArticle_seq() {
		return article_seq;
	}
	public void setArticle_seq(int article_seq) {
		this.article_seq = article_seq;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public String getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(String cmt_date) {
		this.cmt_date = cmt_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}
