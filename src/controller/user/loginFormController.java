package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;

public class loginFormController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//dao 성공했다면
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id", "asdfasf");
		
		return new MyView("/index");
	}

}
