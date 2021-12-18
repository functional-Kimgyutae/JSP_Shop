package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;

public class delCartAjaxController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cId = Integer.parseInt(request.getParameter("cId"));
		
		CartDAO dao = new CartDAO();
		
		int n = dao.cartDelete(cId);
		
		request.setAttribute("n", n);
		
		return new MyView("/view/ajax.jsp");
	}

}
