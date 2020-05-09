package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // Document document = Jsoup.parse(new File(path), "utf-8");
        // System.out.println(document);
       /* String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                " <students    >\n" +
                " \t<student number=\"heima_0001\">\n" +
                " \t\t<name>tom</name>\n" +
                " \t\t<age>18</age>\n" +
                " \t\t<sex>male</sex>\n" +
                " \t</student>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\t\t \n" +
                " </students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

    }
}