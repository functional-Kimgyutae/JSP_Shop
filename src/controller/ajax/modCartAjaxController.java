package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;
import dao.UserDAO;

public class modCartAjaxController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cId = Integer.parseInt(request.getParameter("cId"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		CartDAO dao = new CartDAO();
		
		int n = dao.cartUpdate(cId,cnt);
		
		request.setAttribute("n", n);
		
		return new MyView("/view/ajax.jsp");
	}

}
