package controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MyView;

public class tagController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tag = Integer.parseInt( request.getParameter("tag"));
		String[] tags = {"�м��Ƿ�����ȭ����Ƽ","��ǻ�͡������С�����","���������ǰ�����Ż","�ڵ���������","Ȩ���ڡ�����","��̡��ݷ�","��ǰ������ǰ","�� ��","����Ʈ","���� ���","�˶� ����"};
		
		
		return null;
	}

}
