package com.yousef.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousef.dao.BookDAO;
import com.yousef.dao.BookDAOInterface;
import com.yousef.model.Book;

/**
 * Servlet implementation class controllerServlet
 */
@WebServlet("/")
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookDAOInterface b = new BookDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action= request.getServletPath();
		try {
		switch(action)
		{
			case "/addBookForm":
			addBookForm(request, response);
			break;
			
			case "/insertBook":
				insertBook(request, response);
				break;
				
			case "/deleteBook":
				deleteBook(request, response);
				break;
			
			case "/updateBookForm":
				updateBookForm(request, response);
				break;
			
			case "/updateBook":
				updateBook(request, response);
				break;
				
			default:
				listBook(request,response);
				break;
			}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}

	

	

	

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Book> bookList = b.listAllBooks();
		
		request.setAttribute("list", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}

	private void addBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddBookForm.jsp");
		dispatcher.forward(request, response);	
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Book book = new Book(title, author, price);		
		b.addBook(book);
		
		response.sendRedirect("list");
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new Book(id);
		b.deleteBook(book);
		response.sendRedirect("list");
	}
	
	private void updateBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = b.getBook(Integer.parseInt(request.getParameter("id")));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddBookForm.jsp");
		request.setAttribute("book", book);
		dispatcher.forward(request, response);
	}
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		
		b.updateBook(new Book(id,title,author,price));
		
		response.sendRedirect("list");
	}
}
