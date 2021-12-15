package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;
import vo.CartVO;
import vo.UserVO;

public class cartController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userVO") == null) {
			session.setAttribute("alert", "로그인후 이용가능합니다.");
			return new MyView("/view/user/login.jsp");
		}
		UserVO uVO = (UserVO)session.getAttribute("userVO");
		CartDAO dao = new CartDAO();
		
		ArrayList<CartVO> list = dao.cartList(uVO.getM_id());
		
		request.setAttribute("list", list);
		
		
		return new MyView("/view/user/cart.jsp");
	}

}
