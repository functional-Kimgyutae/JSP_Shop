package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import common.FileUpload;
import common.JdbcUtil;
import vo.ProductVO;

public class ProductDAO {
	//상품 전체 갯수 가져오기
	public int productCntAll() {
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
			System.out.println("product 테이블 개수 가져오는 중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return n;
	}
	//상품 실제 갯수 가져오기
	public int productCnt(String type,String value) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from product where "+ type +" like ? and pExit = 1";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				n = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product 실 사용가능한 상품 개수 가져오는 중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return n;
	}
	//상품 넣기 
	public int productInsert(ProductVO vo,int cnt) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product(pId,pName,pLName,pTag,pPrice,pCnt,pUnit,pPackaging,pText) values (?,?,?,?,?,?,?,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cnt+"");
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getLName());
			pstmt.setInt(4,vo.getTag());
			pstmt.setInt(5,vo.getPrice());
			pstmt.setInt(6,vo.getCnt());
			pstmt.setString(7,vo.getUnit());
			pstmt.setString(8,vo.getPackaging());
			pstmt.setString(9,vo.getText());
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("product insert중 오류 발생");
		}
		
		return n;
	}
	//상품 이미지 넣기
	public int productImageImsert(ProductVO vo,int cnt,int index) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DETAILPRODUCT (idx,pId,pImg) values (detailIdx.NEXTVAL,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cnt);
			pstmt.setString(2,vo.getImageList_value(index+""));
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("img Insert넣는중 오류 발생");
		}
		
		return n;
	}
	//상품 list 가져오기 
	public ArrayList<ProductVO> productList(String type,String value,int start) {
		ArrayList<ProductVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rsImg = null;
		String sql = "select * from(select ROW_NUMBER() over (ORDER BY pId) num, p.* from product p where "+type+" like ? and pExit = 1)where num between ? and ?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, start+8);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setpId(rs.getString("pId"));
				vo.setName(rs.getString("pName"));
				vo.setLName(rs.getString("pLName"));
				vo.setTag(Integer.parseInt(rs.getString("pTag")));
				vo.setPrice(Integer.parseInt(rs.getString("pPrice")));
				vo.setCnt(Integer.parseInt(rs.getString("pCnt")));
				vo.setUnit(rs.getString("pUnit"));
				vo.setPackaging(rs.getString("pPackaging"));
				vo.setText(rs.getString("pText"));
				vo.setView(Integer.parseInt(rs.getString("pView")));
				sql = "select pImg from detailProduct where pId = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,rs.getString("pId"));				
				rsImg = pstmt.executeQuery();
				int i = 0;
				while(rsImg.next()) {
					vo.setImageList(i+"",rsImg.getString("pImg"));
					i++;
				}
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product list 검색해서 가져오는중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}	
	//상품 하나 가져오기
	public ProductVO getProduct(int pId) {
		ProductVO vo = new ProductVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rsImg = null;
		String sql = "select * from product where pId = ? and pExit = 1";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setpId(rs.getString("pId"));
				vo.setName(rs.getString("pName"));
				vo.setLName(rs.getString("pLName"));
				vo.setTag(Integer.parseInt(rs.getString("pTag")));
				vo.setPrice(Integer.parseInt(rs.getString("pPrice")));
				vo.setCnt(Integer.parseInt(rs.getString("pCnt")));
				vo.setUnit(rs.getString("pUnit"));
				vo.setPackaging(rs.getString("pPackaging"));
				vo.setText(rs.getString("pText"));
				vo.setView(Integer.parseInt(rs.getString("pView")));
				sql = "select pImg from detailProduct where pId = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,rs.getString("pId"));				
				rsImg = pstmt.executeQuery();
				int i = 0;
				while(rsImg.next()) {
					vo.setImageList(i+"",rsImg.getString("pImg"));
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product list 상품 하나만 가져오는중 오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
}

