package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.GenreVO;
import com.VO.MemberDTO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	MemberDTO info = null;
	ResultSet rs = null;
	GenreVO inf = null;

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

	// 회원가입메소드
	public int join(MemberDTO vo) {
		// db연결 메소드 호출
		db_conn();

		try {
			// 2. DB에서 무엇을 할지 결정
			// 회원가입 기능 = 입력받은 회원 데이터들을 회원 Table에 추가하기
			String sql = "insert into tbl_member values(?, ?, ?, ?,?,SYSDATE,'U')";

			// 3. sql문장을 DB에 전달 -> 전달 성공 시 PreparedStatement 객체로 반환
			psmt = conn.prepareStatement(sql);

			// 4. ? 바인드 변수에 값 채우기
			// join메소드 매개변수로 dto(입력받은 값들의 묶음 = 가방) 받아오기
			psmt.setString(1, vo.getMb_id());
			psmt.setString(2, vo.getMb_pw());
			psmt.setString(3, vo.getMb_name());
			psmt.setString(4, vo.getMb_birthdate());
			psmt.setString(5, vo.getMb_gender());

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

	// 로그인 메소드
	public MemberDTO login(MemberDTO vo) {
		db_conn();
		try {
			String sql = "select * from tbl_member where MB_Id =? and MB_PW =?";
			// select로 tbl_member에서 가지고 오는데 id과 pw값이 다 일치할때만 가지고 오겠다

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getMb_id());
			psmt.setString(2, vo.getMb_pw());

			// select절은 Query -> ResultSet(rs)
			rs = psmt.executeQuery();

			// rs.next() : 다음 행에 값이 있는지(t) 없는지(f) boolean타입으로 반환
			if (rs.next()) {
				// 실행문장 실행 = 값이 있다 = 로그인성공
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String birthdate = rs.getString(4);
				String gender = rs.getString(5);
				String joindate = rs.getString(6);
				String type = rs.getString(7);

				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체
				info = new MemberDTO(id, pw, name, birthdate, gender, joindate, type);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// 이거 적어야 어디서 오류 났는지 알려주니까 꼭 적어야함!
		} finally {
			db_close();
		}
		System.out.println("여기임?2");
		return info;
	}

	// 회원이 선호하는 장르 리스트
	public String gen(String id) {
		String genr = null;
		try {
			db_conn();
			String sql = "select * from tbl_fav_genre where MB_Id =?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				// 실행문장 실행 = 값이 있다 = 로그인성공
				genr = rs.getString(3);

				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return genr;
	}
	// 회원이 선호하는 장르 입력
	public void joinGen(String id,String genre) {
		try {
			db_conn();
			String sql = " INSERT INTO tbl_fav_genre values(tbl_fav_genre_SEQ.nextval,?,?) ";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, genre);
			

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return ;
	}

	// 회원정보수정 메소드
	public int Update(MemberDTO dto) {
		try {
			db_conn();
			String sql = " UPDATE tbl_member set MB_NAME=?, MB_PW=? where MB_ID=? ";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getMb_name());
			psmt.setString(2, dto.getMb_pw());
			psmt.setString(3, dto.getMb_id());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}

	// 회원정보 장르 수정
	public int upgen(String gener, String id) {
		try {
			db_conn();
			String sql = " UPDATE tbl_fav_genre set FAV_GENRE_ID=? where MB_ID=? ";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, gener);
			psmt.setString(2, id);
			System.out.println(gener);
			System.out.println(id);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return cnt;
	}

	// 회원정보 관리 메소드
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			db_conn();
			String sql = "select * from tbl_member";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String birthdate = rs.getString(4);
				String gender = rs.getString(5);
				String joindate = rs.getString(6);
				String type = rs.getString(7);

				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체
				info = new MemberDTO(id, pw, name, birthdate, gender, joindate, type);
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

	// 회원 선호하는 장르 메소드
	public ArrayList<GenreVO> selectGen() {
		ArrayList<GenreVO> list = new ArrayList<GenreVO>();
		try {
			db_conn();
			String sql = "select * from tbl_fav_genre";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String seq = rs.getString(1);
				String id = rs.getString(2);
				String fav_gen = rs.getString(3);

				// info = 로그인한 사람의 정보를 담고있는 memberDTO형태의 객체
				inf = new GenreVO(seq, id, fav_gen);
				// DTO만 반환하면 마지막 DTO값만 출력되기 때문에
				// 크기를 가변할 수 있는 ArreyList사용

				list.add(inf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return list;
	}

}
