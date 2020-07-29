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
		// 당기 순이익 가져올 수 있도록 확인해야함.(selector 확인)
		// selector는 구글 개발자도구 > 오른쪽버튼 > copySelector 하면 바로 딸수 있음 개이득!!!
		Elements element = rawData.select("#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(6) > td:nth-child(2)");
		System.out.println(element.text());
		element = rawData.select("#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(6) > td.null.last.cell_strong");
		System.out.println(element.text().equals("")); //true

		//array로 확인하는게 맞는건지??
		//ArrayList<String> a  = (ArrayList<String>) element.eachText();
		
		//for.... 
//		for (String b : a) {
//			System.out.println(b);
//		}
		
		
	}
}
