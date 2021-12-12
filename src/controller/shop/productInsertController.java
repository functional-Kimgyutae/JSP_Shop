package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileUpload;
import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;

public class productInsertController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/data/product_img");
		
	    String encType = "UTF-8";
	    
	    int maxSize = 5 * 1024 * 1024;
	    
		HttpSession session = request.getSession();

		MultipartRequest multi = new MultipartRequest(request, path, maxSize,
                encType, new DefaultFileRenamePolicy());
		
		ProductDAO dao = new ProductDAO();	
		ProductVO vo = new ProductVO();
		
		int cnt = Integer.parseInt(multi.getParameter("cnt"));

		vo.setName(multi.getParameter("title"));
		vo.setL_name(multi.getParameter("l_title"));
		vo.setTag(Integer.parseInt(multi.getParameter("tag")));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		vo.setCount(Integer.parseInt(multi.getParameter("count")));
		vo.setCnt(cnt);
		vo.setUnit(multi.getParameter("unit"));
		vo.setPackaging(multi.getParameter("packaging"));
		vo.setText(multi.getParameter("text"));
		

		

		int db_cnt = dao.productCntAll();//번호 가져오기
		
		int n = dao.productInsert(vo, db_cnt); // 기본정보 저장
		
		if(n == 0) {
			session.setAttribute("alert", "insert 오류 발생");
			return new MyView("/admin/admin");
		}

		for (int i = 0; i <=cnt ; i++) {
			String url = FileUpload.fileUp(multi, path, db_cnt, i);
			vo.setImage_list(i+"", url);
		}
		
		
		for (int i = 0; i <= cnt; i++) {
			n = dao.productImageImsert(vo, db_cnt,i);	
		}
		
		return new MyView("/shop/product?p_id="+db_cnt);
	}

}
