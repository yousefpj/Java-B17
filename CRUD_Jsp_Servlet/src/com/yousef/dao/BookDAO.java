package com.yousef.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yousef.model.Book;

public class BookDAO implements BookDAOInterface 
{

	String url = "jdbc:mysql://localhost:3306/book_management";
	String username = "root";
	String password = "";
	Connection conn;
	
	private void connect() throws SQLException
	{
		if(conn == null || conn.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new SQLException(e);
			}
		}
	}
	
	@Override
	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		List <Book> listofBooks = new ArrayList<Book>();
		
		try {
			String sql = "select * from books";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");
				
				listofBooks.add(new Book(id,title,author,price));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listofBooks;
	}

	@Override
	public boolean addBook(Book b) 
	{
		boolean row = false;
		
		
		try {
			String sql = "INSERT INTO books (title, author, price) VALUES (?,?,?)";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setFloat(3, b.getPrice());
			row = st.executeUpdate() > 0;
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return row;
	}

	@Override
	public boolean deleteBook(Book b) {
		boolean row= false;
		
		try {
			String sql = "delete from books where id=?";
			connect();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, b.getId());
			
			row = st.executeUpdate() > 0;
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public boolean updateBook(Book b) {
		boolean row= false;
		
		try {
			String sql = "update books set title=? , author=? , price=? where id=?";
			connect();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setFloat(3, b.getPrice());
			st.setInt(4, b.getId());
			
			row = st.executeUpdate() > 0;
			
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return row;
	}

	@Override
	public Book getBook(int i) {
		Book book = null;
		
		try {
			String sql = "select * from books where id=?";
			connect();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, i);
			
			ResultSet result = st.executeQuery();
			
			while(result.next())
			{
				book = new Book(result.getInt("id"), result.getString("title"), result.getString("author"), result.getFloat("price"));
			}
			
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

}
