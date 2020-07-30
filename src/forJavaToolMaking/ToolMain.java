package forJavaToolMaking;


import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ToolMain {

	//데이터 크롤링 대상
	
	//종합정보
	static String ARTICLE_URL = "https://finance.naver.com/item/main.nhn?code=019170";
	
	//종목분석
	//  https://finance.naver.com/item/coinfo.nhn?code=089010
	
	
	
	
	//당기 순이익 selector
	static String [] netIncomeYear
			= {
					//3년전
					"#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(2)"
					//2년전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(3)"
					//1년전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(4)"
					//예상
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(5)"
			};
	
	//당기 순이익 selector
	static String [] netIncomeQuarter
			= {
					//6분기전
					"#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(6)"
					//5분기전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(7)"
					//4분기전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(8)"
					//3분기전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(9)"
					//2분기전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(10)"
					//1분기전
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(11)"
			};
	
	//시총
	static String marketCap = "#_market_sum";
	
	//PER기준월
	static String perDate = "#tab_con1 > div:nth-child(5) > table > tbody:nth-child(2) > tr > th > span.date";
	
	//추정PER
	static String perCal = "#_per";
	
	//투자의견
	static String invstOp = "#tab_con1 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td > span.f_up > em";
	
	//목표주가
	static String goalPrice = "#tab_con1 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td > em";
	
	//동일업종 PER
	static String sameDomainPer = "#tab_con1 > div:nth-child(6) > table > tbody > tr.strong > td > em";
	
	public static void main(String[] args) throws IOException {

		//페이지 긁어서 가지고옴
		Document rawData = Jsoup.connect(ARTICLE_URL)
                .timeout(5000)
                .get();
		
		
		Elements element = null;
		//당기 순이익 가지고 오기.	
		for (int i = 0; i < netIncomeQuarter.length; i++) {
			element = rawData.select(netIncomeQuarter[i]);
			System.out.println(element.text());
		}
		element = rawData.select(marketCap);
		System.out.println(element.text());
			
		//array로 확인하는게 맞는건지??
		//ArrayList<String> a  = (ArrayList<String>) element.eachText();
		
		//for.... 
//		for (String b : a) {
//			System.out.println(b);
//		}
		
		
	}
}
