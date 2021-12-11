package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;

public class tagController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tag = Integer.parseInt( request.getParameter("tag"));
		String[] tags = {"패션의류·잡화·뷰티","컴퓨터·디지털·가전","스포츠·건강·렌탈","자동차·공구","홈데코·문구","취미·반려","식품·생필품","핫 딜","베스트","빠른 배송","알뜰 쇼핑"};
		
		
		return null;
	}

}
