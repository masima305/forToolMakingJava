package forJavaToolMaking;


import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ToolMain {
	public static void main(String[] args) {
		System.out.println("helloWorld!");
		Document doc = null;
		
		try {
			doc = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=035720").get();
		} catch (IOException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements element = doc.select("div.h_th2 th_cop_anal10");
		
		ArrayList<String> a  = (ArrayList<String>) element.eachText();
		
		for (String b : a) {
			System.out.println(b);
		}
		
		
	}
}
