package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtil;
import vo.ProductVO;

public class ProductDAO {
	public int productCnt() {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from product";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				n = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cnt구하는중 db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return n;
	}
	
	public int productInsert(ProductVO vo,int cnt) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		
		return 1;
	}
}
