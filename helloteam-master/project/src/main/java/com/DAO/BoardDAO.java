package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.BoardVO;
import com.VO.CommentVO;
import com.VO.GenreVO;
import com.VO.MemberDTO;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	BoardVO info = null;
	ResultSet rs = null;
	BoardVO inf = null;
	CommentVO infos = null;
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

			if (conn != null) {
				System.out.println("DB연결성공");
			} else {
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
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardVO> select() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			db_conn();
			String sql = "select * from tbl_community ORDER BY ARTICLE_SEQ DESC";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String file = rs.getString(4);
				String date = rs.getString(5);
				String id = rs.getString(6);
				int count = rs.getInt(7);
				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체
				info = new BoardVO(seq, title, content, file, date, id,count);
				// DTO만 반환하면 마지막 DTO값만 출력되기 때문에
				// 크기를 가변할 수 있는 ArrayList사용

				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}

		return list;
	}

	public int getNext() {

		try {
			db_conn();
			String sql = "select ARTICLE_SEQ from tbl_community ORDER BY ARTICLE_SEQ DESC";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return -1;
	}

	// 게시글 리스트
	public ArrayList<BoardVO> getList(int pageNumber) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		int page = getNext() - (pageNumber - 1) * 10;
		System.out.println("daonumber ==>"+pageNumber);
		System.out.println("getList ==>"+page);
		try {
			db_conn();
			String sql = "select * from (select ARTICLE_SEQ, ARTICLE_TITLE, ARTICLE_CONTENT, ARTICLE_FILE, ARTICLE_DATE, ARTICLE_COUNT, MB_ID"
					+ " from tbl_community ORDER BY ARTICLE_SEQ DESC ) where article_seq < " + page+" and rownum<=10";
					

			psmt = conn.prepareStatement(sql);

			//psmt.setInt(1, a);

			rs = psmt.executeQuery();
			while (rs.next()) {

				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String file = rs.getString(4);
				String date = rs.getString(5);				
				int count = rs.getInt(6);
				String id = rs.getString(7);
				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체
				info = new BoardVO(seq, title, content, file, date, id, count);
				// DTO만 반환하면 마지막 DTO값만 출력되기 때문에
				// 크기를 가변할 수 있는 ArreyList사용

				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}

		return list;
	}

	public boolean nextPage(int pageNumber) {
		
		int page = getNext() - (pageNumber - 1) * 10;
	
		System.out.println("nextPage ==>"+page);
		try {
			db_conn();
			String sql = "select * from tbl_community where ARTICLE_SEQ < "+page+"  ";

			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 내용 불러오기!
	public ArrayList<BoardVO> view(String id) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			db_conn();
			String sql = "select * from tbl_community where ARTICLE_SEQ = ?  ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			while (rs.next()) { // if로 변경

				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String file = rs.getString(4);
				String dates = rs.getString(5);
				String name = rs.getString(6);
				int count = rs.getInt(7);
				inf = new BoardVO(seq, title, content, file, dates, name,count);

				list.add(inf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}

		return list;
	}

	// 글쓰기
	public int write(BoardVO vo) {
		// db연결 메소드 호출
		db_conn();

		try {
			// 2. DB에서 무엇을 할지 결정
			// 회원가입 기능 = 입력받은 회원 데이터들을 회원 Table에 추가하기
			String sql = "insert into tbl_community values(tbl_seq.nextval,?,?,'null',sysdate,?,0)";

			// 3. sql문장을 DB에 전달 -> 전달 성공 시 PreparedStatement 객체로 반환
			psmt = conn.prepareStatement(sql);

			// 4. ? 바인드 변수에 값 채우기
			// join메소드 매개변수로 dto(입력받은 값들의 묶음 = 가방) 받아오기
			psmt.setString(1, vo.getArticle_title());
			psmt.setString(2, vo.getArticle_content());
			psmt.setString(3, vo.getMb_id());
			
			// 5. sql문 실행
			// insert -> DB에 변화생기기 때문에 Update
			// int 형태로 반환, int의 의미 : 몇개의 행에 변화가 생겼는지
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 6. DB문 닫기
			db_close();
		}
		return cnt;
	}

	// 글 수정하기
	public int Update(String title, String content, int seq) {
		try {
			db_conn();
			String sql = " UPDATE tbl_community set ARTICLE_TITLE=?, ARTICLE_CONTENT=? where ARTICLE_SEQ=? ";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, seq);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}

	// 게시글 삭제하기
	public int delete(int num) {

		db_conn();

		try {
			String sql = "delete tbl_community where ARTICLE_SEQ=? ";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}
	
	// 댓글 불러오기
	public ArrayList<CommentVO> Comment(String seq) {
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		try {
			db_conn();
			String sql = "select * from tbl_comment where ARTICLE_SEQ = ? order by cmt_seq";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);

			rs = psmt.executeQuery();
			while (rs.next()) { // if로 변경

				int cmt_seq = rs.getInt(1);
				int B_seq = rs.getInt(2);
				String cmt_content = rs.getString(3);
				String cmt_date = rs.getString(4);
				String id = rs.getString(5);

				infos = new CommentVO(cmt_seq,B_seq,cmt_content,cmt_date,id);

				list.add(infos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}

		return list;
	}
	
	// 댓글 작성하기
	
	
	public int Commentwrite(int article_seq,String comment_content,String mb_id) {
		db_conn();
		try {
			
			String sql = "insert into tbl_comment values(cmt_seq.nextval, ? ,? , sysdate, ?)";

			
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, article_seq);
			psmt.setString(2, comment_content);
			psmt.setString(3, mb_id);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}
	
	//댓글 삭제하기
	public int commentDel(int num) {

		db_conn();

		try {
			String sql = "delete tbl_comment where CMT_SEQ=? ";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}
	
	// 글 조회수 영역
	
	public int Bcount(String id) {
		try {
			db_conn();
			String sql = " UPDATE tbl_community set ARTICLE_count=ARTICLE_count+1 where ARTICLE_SEQ=? ";

			psmt = conn.prepareStatement(sql);

		
			psmt.setString(1, id);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}
	

}
