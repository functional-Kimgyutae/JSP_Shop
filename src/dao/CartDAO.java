package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;

import common.JdbcUtil;
import vo.CartVO;
import vo.ProductVO;

public class CartDAO {
	// 카트내에 존재 하는지 확인
	public boolean isExist(int pId,String mId) {
		boolean isExist = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cId from cart where pId = ? and mId = ?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pId);
			pstmt.setString(2, mId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cart에 담겼는지 확인중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return isExist;
	}
	// 카트에 상품 담기
	public int cartInsert(CartVO vo) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO cart (cId,pId,mId,cCnt) values (cart_idx.NEXTVAL,?,?,?)";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getpId());
			pstmt.setString(2,vo.getmId());
			pstmt.setInt(3,vo.getcCnt());

			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart insert중 오류 발생");
		}
		
		return n;
	}
	// 카트 상품 수량 업데이트
	public int cartUpdate(int cId,int cCnt) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE cart SET cCnt = ? WHERE cId = ?";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cCnt);
			pstmt.setInt(2, cId);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart update중 오류 발생");
		}
		return n;
	}
	// 카트 상품 삭제
	public int cartDelete(int cId) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM cart where cId = ?";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart delete 삭제중 오류 발생");
		}
		return n;
	}
	// 카트 품목 들고 오기
	public ArrayList<CartVO> cartList(String mId) {
		ArrayList<CartVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select c.cId \"cId\",a.pId \"pId\",c.mId \"mId\",c.cCnt \"cCnt\",p.pPrice \"pPrice\",a.minIdx \"idx\",b.pImg \"pImg\",p.pName "
				+ "from ("
				+ "select p.pId,min(dp.idx) minIdx from product p,detailProduct dp where p.pId = dp.pId group by p.pId order by p.pId) a, "
				+ "DETAILPRODUCT b,cart c,product p "
				+ "where b.idx = a.minIdx and c.mId = ? and a.pId = c.pId and a.pId = p.pId";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO vo = new CartVO();
				vo.setcId(rs.getInt("cId"));
				vo.setpId(rs.getInt("pId"));
				vo.setmId(rs.getString("mId"));
				vo.setcCnt(rs.getInt("cCnt"));
				vo.setpPrice(rs.getInt("pPrice"));
				vo.setpImg(rs.getString("pImg"));		
				vo.setpName(rs.getString("pName"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cart list 가져오는중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	// 주문하려고 값을 들고 오기 수정중 
	public int orderList(int total,Object jsonDataProduct,Object jsonDataCnt,String mId) {
		ArrayList<String> ProductKeyList = new ArrayList<>();


		JSONObject JsonProduct = (JSONObject) jsonDataProduct; 
		JSONObject JsonCnt = (JSONObject) jsonDataCnt;
		Set<String> productKeys = JsonProduct.keySet(); 
		Set<String> Cntkeys = JsonCnt.keySet();
		    while(i.hasNext())
		    {
		        String b = i.next().toString();
		        ProductKeyList.add(b); 
		    }
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO orderList (oId,mId,oPrice) values (orderIdx.NEXTVAL,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select count(*) as cnt from orderList");
			int cnt = 0;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, total);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cart 포기");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return  0;
	}

	public int deleteList(String mId) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM cart where mId = ?";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cart delete 삭제중 오류 발생");
		}
		return n;
		
	}
}
