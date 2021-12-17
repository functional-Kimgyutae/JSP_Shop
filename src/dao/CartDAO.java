package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.CartVO;
import vo.ProductVO;

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
			System.out.println("cart �ߺ� Ȯ����  db���� �߻�");
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
			System.out.println("cart insert�� �����߻�");
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
			System.out.println("cart update�� �����߻�");
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
			System.out.println("cart delete�� �����߻�");
		}
		return n;
	}

//	join �������� �ֹ����̺� ����Ϸ��� 
	public ArrayList<CartVO> cartList(String m_id) {
		ArrayList<CartVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select c.c_id \"c_id\",a.p_id \"p_id\",c.m_id \"m_id\",c.c_cnt \"c_cnt\",p.p_price \"p_price\",a.minIdx \"idx\",b.p_img \"p_img\",p.p_name from (select p.p_id,min(dp.idx) minIdx from product p,detail_product dp where p.p_id = dp.p_id group by p.p_id order by p.p_id) a, DETAIL_PRODUCT b,cart c,product p where b.idx = a.minIdx and c.m_id = ? and a.p_id = c.p_id and a.p_id = p.p_id";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO vo = new CartVO();
				vo.setC_id(rs.getInt("c_id"));
				vo.setP_id(rs.getInt("p_id"));
				vo.setM_id(rs.getString("m_id"));
				vo.setC_cnt(rs.getInt("c_cnt"));
				vo.setP_price(rs.getInt("p_price"));
				vo.setP_img(rs.getString("p_img"));		
				vo.setP_name(rs.getString("p_name"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cart list ���������� db���� �߻�");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
		
	}

		
	public int orderList(int total,Object jsonDataProduct,Object jsonData,String m_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO orderList (o_id,m_id,o_price) values (order_idx.NEXTVAL,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, total);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cart �ߺ� Ȯ����  db���� �߻�");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return  0;
	}
}
