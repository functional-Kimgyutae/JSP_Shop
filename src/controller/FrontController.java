package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.adminController;
import controller.ajax.checkIdAjaxController;
import controller.shop.productController;
import controller.shop.searchController;
import controller.shop.tagController;
import controller.user.cartController;
import controller.user.loginFormController;
import controller.user.logoutController;
import controller.user.registerFormController;
import controller.user.userController;

@WebServlet({"/index","/shop/*", "/user/*","/admin/*","/ajax/*" })

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Controller> controllerMap = new HashMap<>(); // url매핑해서 container연결하기 위한 
       
    public FrontController() {
    	super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 메인페이지 로드
		controllerMap.put("/index", new mainController());
		
		//user 관련 페이지
		controllerMap.put("/user/user", new userController());
		controllerMap.put("/user/login", new loginFormController());
		controllerMap.put("/user/register", new registerFormController());	
		controllerMap.put("/user/logout", new logoutController());
		controllerMap.put("/user/cart", new cartController());
		
		//admin 관련 페이지
		controllerMap.put("/admin/admin", new adminController());	
		
		//shop 관련 페이지
		controllerMap.put("/shop/tag", new tagController());
		controllerMap.put("/shop/product", new productController());
		controllerMap.put("/shop/search", new searchController());
		//ajax 쓰는 페이지
		controllerMap.put("/ajax/check_id",new checkIdAjaxController());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		Controller controller = controllerMap.get(path);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		MyView view = controller.process(request, response);
		view.render(request, response);
	}

}
