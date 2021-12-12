package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import common.JdbcUtil;
import vo.UserVO;

public class UserDAO {
	
	public boolean confirmId (String id) {
		boolean same = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT m_id from member where m_id = ?";
		
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
			System.out.println("comfirmId db���� �߻�");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return same;
	}
	
	public int registerProcess(UserVO vo) {
		int s1 = 0;
		int s2 = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(m_id,m_psd,m_name,m_phone,m_email,m_gender) VALUES (?,?,?,?,?,?)";
		
		String sql1 = "INSERT INTO detail_address(m_id,m_address1,m_address2,m_address3) VALUES (?,?,?,?)";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2,vo.getM_psd());
			pstmt.setString(3,vo.getM_name());
			pstmt.setString(4,vo.getM_phone());
			pstmt.setString(5,vo.getM_email());
			pstmt.setInt(6,vo.getM_gender());
			
			s1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2,vo.getM_address1());
			pstmt.setString(3,vo.getM_address2());
			pstmt.setString(4,vo.getM_address3());
			
			s2 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert�� �����߻�");
		}
		return s1+s2;
	}
	
	public boolean loginProcess (String id,String psd) {
		boolean login = false;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT m_id from member where m_id = ? and m_psd = ? and m_exit = 1";
		
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
			System.out.println("login�� db���� �߻�");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return login;
	}

	
}