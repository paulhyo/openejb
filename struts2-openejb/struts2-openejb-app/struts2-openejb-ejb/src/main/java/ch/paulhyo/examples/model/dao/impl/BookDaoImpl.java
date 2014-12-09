package ch.paulhyo.examples.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.FinderException;
import javax.ejb.Stateless;

import ch.paulhyo.examples.model.Book;
import ch.paulhyo.examples.model.BookDTO;
import ch.paulhyo.examples.model.dao.IBookDao;
/**
 * @author jasforge
 * @param <T>
 * 
 */
@Stateless(name = "IBookDao")
public class BookDaoImpl<T> extends GenericDaoImpl<Book> implements IBookDao {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jasmineconseil.workshop.dao.IBookDao#deleteBookDTO(com.jasmineconseil
	 * .workshop.model.BookDTO)
	 */
	@Override
	public void deleteBookDTO(BookDTO t) {
		//remove(Book.class, t.getIsbn());
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jasmineconseil.workshop.dao.IBookDao#deleteAllBookDto(java.util.List)
	 */
	@Override
	public void deleteAllBookDto(List<BookDTO> listBookDto) {
		// TODO Auto-generated method stub
		for (BookDTO bookDto : listBookDto) {
			deleteBookDTO(bookDto);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jasmineconseil.workshop.dao.IBookDao#createBookDto(com.jasmineconseil
	 * .workshop.model.BookDTO)
	 */
	@Override
	public void createBookDto(BookDTO bookDto) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setIsbn(bookDto.getIsbn());
		book.setName(bookDto.getName());
		book.setNumberOfPages(bookDto.getNumberOfPages());
		//create(book);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jasmineconseil.workshop.dao.IBookDao#findAllBook()
	 */
	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		List<Book> list = (List<Book>) rechercherByWhere("select b from Book b");
		return list;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jasmineconseil.workshop.dao.IBookDao#findByNameBook(java.lang.String)
	 */
	@Override
	public List<Book> findByNameBook(String name) {
		// TODO Auto-generated method stub
		List<Book> listBook = (List<Book>) rechercherByWhere("select b from Book b where b.name='"
				+ name + "'");
		return listBook;
	}
	@Override
	public List<BookDTO> findAllBookDto() {
		List<Book> listAllBook = findAllBook();
		List<BookDTO> listBookDto = convertListBookToDto(listAllBook);
		return listBookDto;
	}
	private List<BookDTO> convertListBookToDto(List<Book> listAllBook) {
		List<BookDTO> listDto = new ArrayList<BookDTO>();
		for (Book book : listAllBook) {
			listDto.add(convertBookToDto(book));
		}
		return listDto;
	}
	private BookDTO convertBookToDto(Book book) {
		BookDTO bookDto = null;
		if (book != null) {
			bookDto = new BookDTO();
			bookDto.setIsbn(book.getIsbn());
			bookDto.setName(book.getName());
			bookDto.setNumberOfPages(book.getNumberOfPages());
		}
		return bookDto;
	}
	
	public BookDTO findBookDto(String isbn) throws FinderException{		
		// Recherche du book 
		Book book = findByPrimaryKey(isbn); 
		// conversion en bookDto
		BookDTO bookDto = convertBookToDto(book); 
		return bookDto; 
	}
}

