package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;
import dao.UserDAO;

public class checkIdAjaxController implements Controller {
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		UserDAO dao = new UserDAO();
		
		boolean same = dao.confirmId(id);
		
		request.setAttribute("same", same);
		return new MyView("/view/ajax.jsp");
	}

}
