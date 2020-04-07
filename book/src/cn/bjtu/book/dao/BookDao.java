package cn.bjtu.book.dao;

import cn.bjtu.book.pojo.Book;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-03-18 12:20
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
