package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;

public class productInsertController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();	
		ProductVO vo = new ProductVO();
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		vo.setName(request.getParameter("title"));
		vo.setL_name(request.getParameter("l_title"));
		vo.setTag(Integer.parseInt(request.getParameter("tag")));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setCount(Integer.parseInt(request.getParameter("count")));
		vo.setCnt(cnt);
		vo.setUnit(request.getParameter("unit"));
		vo.setPackaging(request.getParameter("packaging"));
		vo.setText(request.getParameter("text"));
		vo.setImage_url(request.getParameter("image_url"));
		for (int i = 1; i <=cnt ; i++) {
			vo.setImage_list(i+"", request.getParameter("image_url"+i));
		}
		
			
		int db_cnt = dao.productCnt();
		
		

		
		
		
		return new MyView("/index");
	}

}
