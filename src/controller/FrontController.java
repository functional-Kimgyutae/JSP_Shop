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
import controller.ajax.delCartAjaxController;
import controller.ajax.modCartAjaxController;
import controller.ajax.orderCartAjaxController;
import controller.ajax.putCartAjaxController;
import controller.shop.productController;
import controller.shop.productInsertController;
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
	private HashMap<String, Controller> controllerMap = new HashMap<>(); 
       
    public FrontController() {
    	super();
    }

	public void init(ServletConfig config) throws ServletException {
		// index
		controllerMap.put("/index", new mainController());
		
		//user 
		controllerMap.put("/user/user", new userController());
		controllerMap.put("/user/login", new loginFormController());
		controllerMap.put("/user/register", new registerFormController());	
		controllerMap.put("/user/logout", new logoutController());
		controllerMap.put("/user/cart", new cartController());
		
		//admin
		controllerMap.put("/admin/admin", new adminController());	
		
		//shop 
		controllerMap.put("/shop/tag", new tagController());
		controllerMap.put("/shop/product", new productController());
		controllerMap.put("/shop/search", new searchController());
		controllerMap.put("/shop/product_insert", new productInsertController());
		
		//ajax 
		controllerMap.put("/ajax/check_id",new checkIdAjaxController());
		controllerMap.put("/ajax/add_cart",new putCartAjaxController());
		controllerMap.put("/ajax/mod_cart",new modCartAjaxController());
		controllerMap.put("/ajax/del_cart",new delCartAjaxController());
		controllerMap.put("/ajax/order_cart",new orderCartAjaxController());
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
