package com.yousef.dao;

import java.util.List;

import com.yousef.model.Book;

public interface BookDAOInterface 
{
	public List<Book> listAllBooks ();
	public boolean addBook(Book b);
	public boolean deleteBook(Book b);
	public boolean updateBook(Book b);
	public Book getBook(int i);
}
