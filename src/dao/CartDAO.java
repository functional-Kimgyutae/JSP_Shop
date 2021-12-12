package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtil;
import vo.CartVO;

public class CartDAO {
	public boolean isExist(int p_id,String m_id) {
		boolean isExist = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT c_id from cart where p_id = ? and m_id = ?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			pstmt.setString(2, m_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cart 중복 확인중  db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return isExist;
	}
	
	public int cartInsert(CartVO vo) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO cart (c_id,p_id,m_id,c_cnt) values (cart_idx.NEXTVAL,?,?,?)";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_id());
			pstmt.setString(2,vo.getM_id());
			pstmt.setInt(3,vo.getC_cnt());

			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart insert중 오류발생");
		}
		
		return n;
	}

	public int cartUpdate(int c_id,int c_cnt) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE cart SET c_cnt = ? WHERE c_id = ?";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,c_cnt);
			pstmt.setInt(2, c_id);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart update중 오류발생");
		}
		return n;
	}
	
	public int cartDelete(int c_id) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM cart where c_id = ?";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_id);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart delete중 오류발생");
		}
		return n;
	}

//	join 만들어야함 주문테이블 사용하려면 
	
}
