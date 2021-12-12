package controller.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;

public class searchController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String search = "";
		if(request.getParameter("search")!= null) {
			search = request.getParameter("search");
		}
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> list = dao.productSearchList(search);
		
		request.setAttribute("list",list); 
		request.setAttribute("search", search);
		
		return new MyView("/view/shop/search.jsp");
	}

}
