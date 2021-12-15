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
		
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		
		CartDAO dao = new CartDAO();
		int n = dao.cartDelete(c_id);
		request.setAttribute("n", n);
		return new MyView("/view/ajax.jsp");
	}

}
