package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;


public class orderCartAjaxController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int total = Integer.parseInt(request.getParameter("total"));
		String jsonDataProduct = request.getParameter("productArray").toString();
		String jsonDataCnt = request.getParameter("productCnt").toString();
		
		JSONParser parser = new JSONParser();
		Object obj1 = parser.parse(jsonDataProduct);
		Object obj2 = parser.parse(jsonDataCnt);
		CartDAO dao = new CartDAO();
		int n = dao.;
		request.setAttribute("n", n);
		System.out.println("여기까지 왔다");
		return new MyView("/view/ajax.jsp");
	}

}
