package ch.paulhyo.examples.model.dao;

import java.util.List;

import javax.ejb.FinderException;

import ch.paulhyo.examples.model.Book;
import ch.paulhyo.examples.model.BookDTO;

public interface IBookDao extends IGenericDao<Book> {

	void deleteBookDTO(BookDTO t);

	void deleteAllBookDto(List<BookDTO> listBookDto);

	void createBookDto(BookDTO bookDto);

	List<Book> findAllBook();

	List<Book> findByNameBook(String name);

	public List<BookDTO> findAllBookDto();

	BookDTO findBookDto(String isbn) throws FinderException;
}
