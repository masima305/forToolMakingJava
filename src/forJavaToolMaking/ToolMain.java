package forJavaToolMaking;


import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ToolMain {
	
	static String ARTICLE_URL = "https://finance.naver.com/item/main.nhn?code=035720";
	
	public static void main(String[] args) throws IOException {
		System.out.println("helloWorld!");

		Document rawData = Jsoup.connect(ARTICLE_URL)
                .timeout(5000)
                .get();
		
		
		Document doc = null;
		
		//Document google3 = response.parse();
//		
//		
		String elen = rawData.html();
		System.out.println(elen);
		// ��� ������ ������ �� �ֵ��� Ȯ���ؾ���.(selector Ȯ��)
		// selector�� ���� �����ڵ��� > �����ʹ�ư > copySelector �ϸ� �ٷ� ���� ���� ���̵�!!!
		Elements element = rawData.select("#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(6) > td:nth-child(2)");
		System.out.println(element.text());
		element = rawData.select("#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(6) > td.null.last.cell_strong");
		System.out.println(element.text().equals("")); //true

		//array�� Ȯ���ϴ°� �´°���??
		//ArrayList<String> a  = (ArrayList<String>) element.eachText();
		
		//for.... 
//		for (String b : a) {
//			System.out.println(b);
//		}
		
		
	}
}
