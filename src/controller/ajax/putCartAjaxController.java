package controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.CartDAO;
import vo.CartVO;
import vo.UserVO;

public class putCartAjaxController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int pId = Integer.parseInt(request.getParameter("pId"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		UserVO uVO =  (UserVO) session.getAttribute("userVO");
		CartDAO dao = new CartDAO();
		CartVO vo = new CartVO();
		vo.setmId(uVO.getMId());
		vo.setpId(pId);
		vo.setcCnt(cnt);
		
		
		boolean b = dao.isExist(vo.getpId(), vo.getmId());
		b = !b;
		request.setAttribute("upload", b);		
		if(b) {
			int n = dao.cartInsert(vo);
		}
		return new MyView("/view/ajax.jsp");
	}

}
