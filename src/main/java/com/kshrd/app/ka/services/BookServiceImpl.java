package com.kshrd.app.ka.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.app.ka.entities.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Book> list() {
		String sql = "SELECT id,title,author,posted_date FROM book";
		try (Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		)
		{
			ArrayList<Book> a = new ArrayList<Book>();
			Book b = null;
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPostedDate(rs.getString("posted_date"));
				a.add(b);
			}
			return a;
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return null;
	}

	@Override
	public boolean addBook(Book b) {
		String sql = "INSERT INTO book (title,author)values(?,?)";
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(sql);) {
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		String sql = "DELETE FROM book WHERE id=?";
		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
		)
		{
			ps.setInt(1, id);
			if(ps.executeUpdate() > 0){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book b) {
		String sql = "UPDATE book set title=? , author=? WHERE id=?";
		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
		)
		{
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setInt(3, b.getId());
			if(ps.executeUpdate() > 0){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

}
