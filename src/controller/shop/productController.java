package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;

public class productController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAO dao = new ProductDAO();	
		
		String p_id = request.getParameter("p_id");
		
		ProductVO vo = dao.getProduct(p_id);
		
		request.setAttribute("data",vo);
		
		return new MyView("/view/shop/product.jsp");
	}

}
