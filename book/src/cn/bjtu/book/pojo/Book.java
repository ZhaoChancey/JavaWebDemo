package cn.bjtu.book.pojo;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2020-03-18 11:22
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";//图书图片的地址

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgpath='" + imgPath + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgpath() {
        return imgPath;
    }

    public void setImgpath(String imgpath) {
        // 要求给定的图书封面的图书路径不能为空，若为空，则在首页无法显示
        if (imgpath != null && !"".equals(imgpath)){
            this.imgPath = imgpath;
        }
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgpath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        // 要求给定的图书封面的图书路径不能为空，若为空，则在首页无法显示
        if (imgpath != null && !"".equals(imgpath)){
            this.imgPath = imgpath;
        }
    }

    public Book() {
    }
}
