package bookshop.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.command.CommandAction;
import bookshop.command._01_ManagerMain;
import bookshop.command._02_ManagerLogin;
import bookshop.command._03_ManagerLoginPro;
import bookshop.command._04_ManagerLogout;
import bookshop.command._05_BookList;
import bookshop.command._06_BookRegister;
import bookshop.command._07_BookRegisterPro;
import bookshop.command._08_BookUpdate;
import bookshop.command._09_BookUpdatePro;
import bookshop.command._10_BookDeletePro;
import bookshop.command._11_ShopMain;
import bookshop.command._12_Login;
import bookshop.command._13_LoginPro;
import bookshop.command._14_Logout;
import bookshop.command._18_Register;
import bookshop.command._19_RegisterPro;
import bookshop.command._20_Confirm;
import bookshop.command._21_DeletePro;
import bookshop.command._22_ShopList;
import bookshop.command._23_BookContent;
import bookshop.command._34_InsertCart;
import bookshop.command._35_CartList;
import bookshop.command._36_CartUpdateForm;
import bookshop.command._37_CartUpdatePro;
import bookshop.command._38_DeleteCart;
import bookshop.command._39_BuyList;
import bookshop.command._40_BuyForm;
import bookshop.command._41_BuyPro;
import bookshop.command._42_OrderList;

@WebServlet(urlPatterns = {"*.do"})	
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();  
	
	public void init() throws ServletException {
		//==========================================================================
		commandMap.put("/mg/managerMain.do", new _01_ManagerMain());
		commandMap.put("/mg/managerLogin.do", new _02_ManagerLogin());
		commandMap.put("/mg/managerLoginPro.do", new _03_ManagerLoginPro());
		commandMap.put("/mg/managerLogout.do", new _04_ManagerLogout());
		commandMap.put("/mg/bookList.do", new _05_BookList());
		commandMap.put("/mg/bookRegister.do", new _06_BookRegister());
		commandMap.put("/mg/bookRegisterPro.do", new _07_BookRegisterPro());
		commandMap.put("/mg/bookUpdate.do", new _08_BookUpdate());
		commandMap.put("/mg/bookUpdatePro.do", new _09_BookUpdatePro());
		commandMap.put("/mg/bookDeletePro.do", new _10_BookDeletePro());
		//==========================================================================
		commandMap.put("/index.do", new _11_ShopMain());
		commandMap.put("/login.do", new _12_Login());
		commandMap.put("/loginPro.do", new _13_LoginPro());
		commandMap.put("/logout.do", new _14_Logout());
		commandMap.put("/register.do", new _18_Register());
		commandMap.put("/registerPro.do", new _19_RegisterPro());
		commandMap.put("/confirmId.do", new _20_Confirm());
		commandMap.put("/deletePro.do", new _21_DeletePro());
		commandMap.put("/list.do", new _22_ShopList());
		commandMap.put("/bookContent.do", new _23_BookContent());
		//==========================================================================
		commandMap.put("/insertCart.do", new _34_InsertCart());
		commandMap.put("/cartList.do", new _35_CartList());
		commandMap.put("/cartUpdateForm.do", new _36_CartUpdateForm());
		commandMap.put("/cartUpdatePro.do", new _37_CartUpdatePro());
		commandMap.put("/deleteCart.do", new _38_DeleteCart());
		commandMap.put("/buyList.do", new _39_BuyList());
		commandMap.put("/buyForm.do", new _40_BuyForm());
		commandMap.put("/buyPro.do", new _41_BuyPro());
		//==========================================================================
		commandMap.put("/mg/orderList.do", new _42_OrderList());
	}	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String view = null;
		CommandAction com=null;
		try {
			String command = request.getRequestURI();		// command = /shoppingmall/index.do
			System.out.println("request.getContextPath() = " + request.getContextPath());		//  /shoppingmall
			System.out.println(command.indexOf(request.getContextPath()));

	        if(command.indexOf(request.getContextPath()) == 0) 
	           command = command.substring(request.getContextPath().length());		//	 /index.do
	        com = (CommandAction)commandMap.get(command);  
	        view = com.requestPro(request, response);	// new _11_ShopMain()
	        // view = /11_shopMain.jsp
		}catch(Throwable e) {
			e.printStackTrace();
		}

		request.setAttribute("cont",view);
		
	    RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("/00_index.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		requestPro(request, response);
	}
}
