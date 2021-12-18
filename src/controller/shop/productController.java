package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;
import vo.UserVO;

public class productController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProductDAO dao = new ProductDAO();	
		
		String pId = request.getParameter("pId"); 
		
		ProductVO vo = dao.getProduct(pId);
		
		request.setAttribute("data",vo);
		
		
		return new MyView("/view/shop/product.jsp");
	}

}
