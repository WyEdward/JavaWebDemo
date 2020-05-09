package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("----------");
        Elements element2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(element2);
        System.out.println("------");
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }
}