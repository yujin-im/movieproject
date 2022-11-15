package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.MemberDTO;
import com.VO.OttDTO;

public class OttDAO {
	Connection conn = null;
	   PreparedStatement psmt = null;
	   int cnt = 0;
	   OttDTO info = null;
	   ResultSet rs = null;
	   
	   // DB연결메소드
	   public void db_conn() {
		   System.out.println("DB연결");
	      
	      try {
	         // 1. ojdbc6.jar -> import 
	         // maven에서는 pom.xml에서 라이브러리 넣어서 다운로드
	         
	         // 2. Class찾기 -> Java와 DB를 이어주는 통로
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         // 3. DB에 접속하기 위한 카드키만들기(url, id, pw)
	         String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
	         String db_id = "gjai_5_3_0822";
	         String db_pw = "smhrd3";
	         
	         // 4. DB연결 -> 연결 성공 시 Connection 객체로 반환
	         conn = DriverManager.getConnection(db_url, db_id, db_pw);
	         
	         if(conn != null) {
	            System.out.println("DB연결성공");
	         }else {
	            System.out.println("DB연결실패");
	         }
	      
	         
	      } catch (ClassNotFoundException e) {
	         
	         e.printStackTrace();
	      } catch (SQLException e) {
	        
	         e.printStackTrace();
	      }
	   }
	   // DB종료메소드
	   // 역순으로 닫아줄것임
	   public void db_close() {
	      
	         try {
	        	if(rs!=null)rs.close();
	            if(psmt != null)psmt.close();
	            if(conn != null)conn.close();
	            
	         } catch (SQLException e) {
	           e.printStackTrace();
	         }
	   }
	   
	   //ott 프로그램 정보 호출
	   public ArrayList<OttDTO> select(OttDTO vo) {
		   ArrayList<OttDTO> list = new ArrayList<OttDTO>();
		   try {
			db_conn();
			String sql="select video_seq,video_type,video_title,video_content,video_img,to_char(video_open_date,'YYYY-MM-DD'),to_char(video_close_date,'YYYY-MM-DD'),video_rating,video_runtime,video_country,video_ott,genre_seq,mb_id from tbl_video where video_type = ? and video_ott = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getVideo_type());
			psmt.setString(2, vo.getVideo_ott());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String video_seq = rs.getString(1);
				String video_type = rs.getString(2);
				
				String video_title = rs.getString(3);
				String video_content = rs.getString(4);
				String video_img = rs.getString(5);
				String video_open_date = rs.getString(6);
				String video_close_date = rs.getString(7);
				String video_rating = rs.getString(8);
				String video_runtime = rs.getString(9);
				String video_country = rs.getString(10);
				String video_ott = rs.getString(11);	
				String genre_seq = rs.getString(12);
				String mb_id = rs.getString(13);
				
	        	// info = 영상 정보를 담고있는 OttDTO형태의 객체
	        	info = new OttDTO(video_seq, video_type, video_title, video_content, video_img, video_open_date, video_close_date, video_rating, video_runtime, video_country, video_ott, genre_seq, mb_id);
				// DTO만 반환하면 마지막 DTO값만 출력되기 때문에
				// 크기를 가변할 수 있는 ArreyList사용
				
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		} return list;
	   }
	   
	   
	   public ArrayList<OttDTO> detailSelect(OttDTO vo, String id) {
		   ArrayList<OttDTO> list = new ArrayList<OttDTO>();
		   try {
			db_conn();
			String sql="select video_seq,video_type,video_title,video_content,video_img,to_char(video_open_date,'YYYY-MM-DD'),to_char(video_close_date,'YYYY-MM-DD'),video_rating,video_runtime,video_country,video_ott,genre_seq,mb_id from tbl_video where video_type = ? and video_ott = ? and video_seq = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getVideo_type());
			psmt.setString(2, vo.getVideo_ott());
			psmt.setString(3, id);
			
			System.out.println("dao : " + vo.getVideo_type());
			System.out.println("dao : " + vo.getVideo_ott());
			System.out.println("dao : " + id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("이미지 디테일 들어오나요???");
				String video_seq = rs.getString(1);
				String video_type = rs.getString(2);
				String video_title = rs.getString(3);
				String video_content = rs.getString(4);
				String video_img = rs.getString(5);
				String video_open_date = rs.getString(6);
				String video_close_date = rs.getString(7);
				String video_rating = rs.getString(8);
				String video_runtime = rs.getString(9);
				String video_country = rs.getString(10);
				String video_ott = rs.getString(11);
				String genre_seq = rs.getString(12);
				String mb_id = rs.getString(13);
				
	        	
	        	// info = 영상 정보를 담고있는 OttDTO형태의 객체
	        	info = new OttDTO(video_seq, video_type, video_title, video_content, video_img, video_open_date, video_close_date, video_rating, video_runtime, video_country, video_ott, genre_seq, mb_id);
				// DTO만 반환하면 마지막 DTO값만 출력되기 때문에
				// 크기를 가변할 수 있는 ArreyList사용
				
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		} return list;
	   }

	}

	   

