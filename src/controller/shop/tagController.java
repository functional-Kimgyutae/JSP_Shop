package controller.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.MyView;
import dao.ProductDAO;
import vo.ProductVO;

public class tagController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tag = "";
	    String[] tags = {"�м��Ƿ�����ȭ����Ƽ","��ǻ�͡������С�����","���������ǰ�����Ż","�ڵ���������","Ȩ���ڡ�����","��̡��ݷ�","��ǰ������ǰ","�� ��","����Ʈ","���� ���","�˶� ����"};
		if(request.getParameter("tag")!= null) {
			tag = request.getParameter("tag");
		}
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> list = dao.productTagList(tag);
		
		request.setAttribute("list",list); 
		request.setAttribute("tag", tags[Integer.parseInt(tag)]);
		return new MyView("/view/shop/tag.jsp");
	}

}
