package controller.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.PaginationVO;
import vo.ProductVO;

public class tagController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaginationVO pVO = new PaginationVO();
		ProductDAO dao = new ProductDAO();
		String tag = "";
	   
		if(request.getParameter("tag")!= null) {
			tag = request.getParameter("tag");
		}
		int page = 1;
		if(request.getParameter("page")!= null ) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int start = (page - 1)* pVO.getArt() + 1;
	
		
		ArrayList<ProductVO> list = dao.productList("p_tag",tag,start);
		
		int total = dao.productCnt("p_tag",tag);
		pVO.construct(total, page);
		
		request.setAttribute("list",list); 
		request.setAttribute("pVO", pVO);
		request.setAttribute("tag", tag);
		request.setAttribute("start", start);
		return new MyView("/view/shop/tag.jsp");
	}

}
