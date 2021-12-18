package controller.user;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SHA256;
import controller.Controller;
import controller.MyView;
import dao.UserDAO;
import vo.UserVO;

public class registerFormController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		SHA256 sha256 = new SHA256();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String path = "";
		
		vo.setmId(request.getParameter("id"));
		vo.setmPsd(sha256.change(request.getParameter("password")));
		vo.setmName(request.getParameter("name"));
		vo.setmEmail(request.getParameter("email"));
		vo.setmPhone(request.getParameter("number"));
		vo.setmAddress1(request.getParameter("addr"));
		vo.setmAddress2(request.getParameter("addr1"));
		vo.setmAddress3(request.getParameter("addr2"));
		vo.setmGender(Integer.parseInt(request.getParameter("gender")));
		
		int n = dao.registerProcess(vo);
		
		if(n > 1)path = "/view/user/login.jsp";
		else path = "/view/user/register.jsp";
		
		return new MyView(path);
	}

}
