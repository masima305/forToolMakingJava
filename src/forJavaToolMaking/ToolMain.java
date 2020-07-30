package forJavaToolMaking;


import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ToolMain {

	//������ ũ�Ѹ� ���
	
	//��������
	static String ARTICLE_URL = "https://finance.naver.com/item/main.nhn?code=019170";
	
	//����м�
	//  https://finance.naver.com/item/coinfo.nhn?code=089010
	
	
	
	
	//��� ������ selector
	static String [] netIncomeYear
			= {
					//3����
					"#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(2)"
					//2����
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(3)"
					//1����
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(4)"
					//����
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(5)"
			};
	
	//��� ������ selector
	static String [] netIncomeQuarter
			= {
					//6�б���
					"#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(6)"
					//5�б���
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(7)"
					//4�б���
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(8)"
					//3�б���
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(9)"
					//2�б���
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(10)"
					//1�б���
					, "#content > div.section.cop_analysis > div.sub_section > table > tbody > tr:nth-child(3) > td:nth-child(11)"
			};
	
	//����
	static String marketCap = "#_market_sum";
	
	//PER���ؿ�
	static String perDate = "#tab_con1 > div:nth-child(5) > table > tbody:nth-child(2) > tr > th > span.date";
	
	//����PER
	static String perCal = "#_per";
	
	//�����ǰ�
	static String invstOp = "#tab_con1 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td > span.f_up > em";
	
	//��ǥ�ְ�
	static String goalPrice = "#tab_con1 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td > em";
	
	//���Ͼ��� PER
	static String sameDomainPer = "#tab_con1 > div:nth-child(6) > table > tbody > tr.strong > td > em";
	
	public static void main(String[] args) throws IOException {

		//������ �ܾ �������
		Document rawData = Jsoup.connect(ARTICLE_URL)
                .timeout(5000)
                .get();
		
		
		Elements element = null;
		//��� ������ ������ ����.	
		for (int i = 0; i < netIncomeQuarter.length; i++) {
			element = rawData.select(netIncomeQuarter[i]);
			System.out.println(element.text());
		}
		element = rawData.select(marketCap);
		System.out.println(element.text());
			
		//array�� Ȯ���ϴ°� �´°���??
		//ArrayList<String> a  = (ArrayList<String>) element.eachText();
		
		//for.... 
//		for (String b : a) {
//			System.out.println(b);
//		}
		
		
	}
}
