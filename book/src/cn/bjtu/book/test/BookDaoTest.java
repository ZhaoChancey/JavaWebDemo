package cn.bjtu.book.test;

import cn.bjtu.book.dao.BookDao;
import cn.bjtu.book.dao.impl.BookDaoImpl;
import cn.bjtu.book.pojo.Book;
import cn.bjtu.book.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-18 12:46
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"从入门到放弃啊！！","西沃",new BigDecimal(99),12222,100,null));
    }

    @Test
    public void deleteById() {
        bookDao.deleteById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"胡汉三又回来了！","西沃",new BigDecimal(99),12222,100,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        Integer integer = bookDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(queryForPageItem);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(10,50);
        System.out.println(integer);
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book queryForPageItem : bookDao.queryForPageItemsByPrice(0,Page.PAGE_SIZE,10,50)) {
            System.out.println(queryForPageItem);
        }
    }
}