package cn.bjtu.book.test;

import cn.bjtu.book.pojo.Book;
import cn.bjtu.book.pojo.Page;
import cn.bjtu.book.service.BookService;
import cn.bjtu.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-18 14:47
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"一本毫无感情的书","不是小威",new BigDecimal(120),20000,2,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"一本感情的书","是小威",new BigDecimal(1200),20000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}