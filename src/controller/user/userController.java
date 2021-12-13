package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;

public class userController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		if(request.getParameter("page")!= null ) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int show = 0;
		if(request.getParameter("show")!= null ) {
			show = Integer.parseInt(request.getParameter("show"));
		}		
		
		request.setAttribute("show", show);
		
		return new MyView("/view/user/user.jsp");
	}

}
