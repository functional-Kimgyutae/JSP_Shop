package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;


public class orderCartAjaxController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// 수정중
		boolean mod = false;
		if(mod) {
		int total = Integer.parseInt(request.getParameter("total"));
		String jsonDataProduct = request.getParameter("productArray").toString();
		String jsonDataCnt = request.getParameter("productCnt").toString(); 
		
		JSONParser parser = new JSONParser();
		Object obj1;
		Object obj2;
		JSONObject Product;
		JSONObject Cnt;
		try {
			obj1 = parser.parse(jsonDataProduct);
			Product = (JSONObject) obj1;
			obj2 = parser.parse(jsonDataCnt);
			Cnt = (JSONObject) obj2;
			System.out.println(Product);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		CartDAO dao = new CartDAO();
		return new MyView("/view/ajax.jsp");
		}else {
			// 삭제 넣기
			CartDAO dao = new CartDAO();
			HttpSession session = request.getSession();
			dao.deleteList((String)session.getAttribute("userId"));
			return new MyView("/view/ajax.jsp");
		}

	}

}
