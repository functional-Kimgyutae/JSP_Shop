package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.SHA256;
import controller.Controller;
import controller.MyView;
import dao.UserDAO;
import vo.UserVO;

public class loginFormController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		UserDAO dao = new UserDAO();
		SHA256 sha256 = new SHA256();
		String path = "";
		
		String id = request.getParameter("id");
		String psd =request.getParameter("password");
		
		if(id.trim() == "" || psd.trim() == "") {
			session.setAttribute("alert", "아이디 또는 비밀번호를 입력해주세요.");
			return new MyView("/view/user/login.jsp");
		}

		boolean login = dao.loginProcess(id,sha256.change(psd));
		
		if(login) {
			path = "/index";
			UserVO vo = dao.getLoginProcess(id, sha256.change(psd));
			session.setAttribute("userId",vo.getmName());
			session.setAttribute("userVO",vo);
			
		}else { 
			session.setAttribute("alert", "아이디 또는 비밀번호가 틀렸습니다.");
			path = "/view/user/login.jsp";
		}
		return new MyView(path);
		
	}

}
