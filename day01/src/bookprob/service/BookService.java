package bookprob.service;

import java.util.List;

import bookprob.vo.BookVO;

public interface BookService {
	List<BookVO> bookList();
	
	int addBook(BookVO vo) throws Exception;
}
