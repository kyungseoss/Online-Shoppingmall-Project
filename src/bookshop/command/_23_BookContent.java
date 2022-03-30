package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerBean;
import bookshop.bean.ManagerDAO;


public class _23_BookContent implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		
		String book_kind = request.getParameter("book_kind");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		//book_id에 해당하는 상품을 얻어냄
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		ManagerBean book = bookProcess.getBook(book_id);
		

		request.setAttribute("book", book);
		request.setAttribute("book_id", new Integer(book_id));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(1));
		return "/23_bookContent.jsp";
	}
}