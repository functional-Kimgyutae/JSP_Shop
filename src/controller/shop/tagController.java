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
import vo.ProductVO;

public class tagController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tag = "";
	    String[] tags = {"패션의류·잡화·뷰티","컴퓨터·디지털·가전","스포츠·건강·렌탈","자동차·공구","홈데코·문구","취미·반려","식품·생필품","핫 딜","베스트","빠른 배송","알뜰 쇼핑"};
		if(request.getParameter("tag")!= null) {
			tag = request.getParameter("tag");
		}
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> list = dao.productTagList(tag);
		
		request.setAttribute("list",list); 
		request.setAttribute("tag", tags[Integer.parseInt(tag)]);
		return new MyView("/view/shop/tag.jsp");
	}

}
