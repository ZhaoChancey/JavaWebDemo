package cn.bjtu.book.service;

import cn.bjtu.book.pojo.Book;
import cn.bjtu.book.pojo.Page;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-03-18 14:44
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
