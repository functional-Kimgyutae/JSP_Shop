package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;

public class checkIdAjaxController implements Controller {

	
	
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String va = "stop1111";
		String data = request.getParameter("id");
//		dao values
		request.setAttribute("name", "0");
		return new MyView("/view/ajax.jsp");
	}

}
