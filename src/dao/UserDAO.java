package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import common.JdbcUtil;
import vo.UserVO;

public class UserDAO {
	//로그인 확인
	public boolean confirmId (String id) {
		boolean same = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mId from member where mId = ?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				same = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("comfirmId db 오류 발생 ");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return same;
	}
	// 회원가입 
	public int registerProcess(UserVO vo) {
		int s1 = 0;
		int s2 = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(mId,mPsd,mName,mPhone,mEmail,mGender) VALUES (?,?,?,?,?,?)";
		
		String sql1 = "INSERT INTO detailAddress(mId,mAddress1,mAddress2,mAddress3) VALUES (?,?,?,?)";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2,vo.getmPsd());
			pstmt.setString(3,vo.getmName());
			pstmt.setString(4,vo.getmPhone());
			pstmt.setString(5,vo.getmEmail());
			pstmt.setInt(6,vo.getmGender());
			
			s1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2,vo.getmAddress1());
			pstmt.setString(3,vo.getmAddress2());
			pstmt.setString(4,vo.getmAddress3());
			
			s2 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 중 오류 발생");
		}
		return s1+s2;
	}
	//로그인 확인
	public boolean loginProcess (String id,String psd) {
		boolean login = false;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mId from member where mId = ? and mPsd = ? and mExit = 1";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, psd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login 확인중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return login;
	}
	// 개인정보 가져오기
	public UserVO getLoginProcess(String id,String psd) {
		UserVO vo = new UserVO();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT m.mId \"mId\",m.mName \"name\",m.mPhone \"phone\",mEmail \"email\", "
				+ "da.mAddress1,da.mAddress2,da.mAddress3 FROM member m "
				+ "JOIN detailAddress da ON m.mId = da.mId where m.mId = ? and m.mPsd = ?";
	
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, psd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setmId(rs.getString("mId"));
				vo.setmName(rs.getString("name"));
				vo.setmPhone(rs.getString("phone"));
				vo.setmEmail(rs.getString("email"));
				vo.setmAddress1(rs.getString("mAddress1"));
				vo.setmAddress2(rs.getString("mAddress2"));
				vo.setmAddress3(rs.getString("mAddress3"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login 정보 가져오는중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
		
}
