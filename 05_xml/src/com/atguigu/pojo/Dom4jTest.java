package com.atguigu.pojo;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-03-07 15:46
 */
public class Dom4jTest {
    @Test
    public void test1(){
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = null;
        try {
            document = saxReader.read("src/books.xml");
            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws DocumentException {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        //JUnit测试，相对路径从module开始
        Document document = saxReader.read("src/books.xml");
        //2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        //3.通过根元素获取book标签对象
        //element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements();
        //4.遍历，处理每个book标签转换为Book类
        for (Element book : books){
            //asXML()把标签对象转换为标签字符串
            Element nameElement = book.element("name");
            //getText() 可以获取标签中的文本内容
            String nameText = nameElement.getText();

            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");


            System.out.println(new Book(snValue,nameText,Double.parseDouble(priceText),authorText));
        }
    }
}
