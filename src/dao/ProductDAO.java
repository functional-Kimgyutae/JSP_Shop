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
			System.out.println("cnt구하는중 db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return n;
	}
	
	public int productCnt(String type,String value) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from product where "+ type +" like ? and p_exit = 1";
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
			System.out.println("cnt구하는중 db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return n;
	}
	
	public int productInsert(ProductVO vo,int cnt) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product(p_id,p_name,p_l_name,p_tag,p_price,p_count,p_cnt,p_unit,p_packaging,p_text) values (?,?,?,?,?,?,?,?,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cnt+"");
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getL_name());
			pstmt.setInt(4,vo.getTag());
			pstmt.setInt(5,vo.getPrice());
			pstmt.setInt(6,vo.getCount());
			pstmt.setInt(7,vo.getCnt());
			pstmt.setString(8,vo.getUnit());
			pstmt.setString(9,vo.getPackaging());
			pstmt.setString(10,vo.getText());
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert중 오류발생");
		}
		
		return n;
	}

	public int productImageImsert(ProductVO vo,int cnt,int index) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DETAIL_PRODUCT (idx,p_id,p_img) values (detail_idx.NEXTVAL,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cnt);
			pstmt.setString(2,vo.getImage_list_value(index+""));
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("img Insert중 오류발생");
		}
		
		return n;
	}

	public ArrayList<ProductVO> productList(String type,String value,int start) {
		ArrayList<ProductVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_img = null;
		String sql = "select * from(select ROW_NUMBER() over (ORDER BY p_id) num, p.* from product p where "+type+" like ? and p_exit = 1)where num between ? and ?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, start+8);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setP_id(rs.getString("p_id"));
				vo.setName(rs.getString("p_name"));
				vo.setL_name(rs.getString("p_l_name"));
				vo.setTag(Integer.parseInt(rs.getString("p_tag")));
				vo.setPrice(Integer.parseInt(rs.getString("p_price")));
				vo.setCount(Integer.parseInt(rs.getString("p_count")));
				vo.setCnt(Integer.parseInt(rs.getString("p_cnt")));
				vo.setUnit(rs.getString("p_unit"));
				vo.setPackaging(rs.getString("p_packaging"));
				vo.setText(rs.getString("p_text"));
				vo.setView(Integer.parseInt(rs.getString("p_view")));
				sql = "select p_img from detail_product where p_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,rs.getString("p_id"));				
				rs_img = pstmt.executeQuery();
				int i = 0;
				while(rs_img.next()) {
					vo.setImage_list(i+"",rs_img.getString("p_img"));
					i++;
				}
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product list 가져오는중 db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}


	public ProductVO getProduct(String p_id) {
		ProductVO vo = new ProductVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_img = null;
		String sql = "select * from product where p_id = ? and p_exit = 1  ";
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setP_id(rs.getString("p_id"));
				vo.setName(rs.getString("p_name"));
				vo.setL_name(rs.getString("p_l_name"));
				vo.setTag(Integer.parseInt(rs.getString("p_tag")));
				vo.setPrice(Integer.parseInt(rs.getString("p_price")));
				vo.setCount(Integer.parseInt(rs.getString("p_count")));
				vo.setCnt(Integer.parseInt(rs.getString("p_cnt")));
				vo.setUnit(rs.getString("p_unit"));
				vo.setPackaging(rs.getString("p_packaging"));
				vo.setText(rs.getString("p_text"));
				vo.setView(Integer.parseInt(rs.getString("p_view")));
				sql = "select p_img from detail_product where p_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,rs.getString("p_id"));				
				rs_img = pstmt.executeQuery();
				int i = 0;
				while(rs_img.next()) {
					vo.setImage_list(i+"",rs_img.getString("p_img"));
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product list 가져오는중 db오류 발생");
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
}

