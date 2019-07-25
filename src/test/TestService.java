package test;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exl_si.db.Event;
import com.exl_si.db.SIMember;
import com.exl_si.db.SIMerchant;
import com.exl_si.service.EventService;
import com.exl_si.service.SIMemberService;
import com.exl_si.service.SIMerchantService;

public class TestService {
private static ApplicationContext ctx; 
private static SIMerchantService merchantService;
private static SIMemberService memberService;
private static EventService eventService;
	
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("/conf/spring/ApplicationContext-main.xml");
		merchantService = (SIMerchantService) ctx.getBean("merchantService");
		memberService =  (SIMemberService) ctx.getBean("memberService");
		eventService =  (EventService) ctx.getBean("eventService");
	}
	
	public static void main(String[] args) {
		try {
			init();
//			addMerchant();
//			addMember();
			addEvent();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	public static void addEvent() {
		for(int i= 1; i < 20; i++) {
			Event event = new Event("event"+i, "mer"+i, new Date(), new Date(), "", 100.0, new Date(), "", "", "", "", "", 1, "remark");
			eventService.save(event);
		}
	}
	
	public static void addMember() {
		for(int i= 1; i < 20; i++) {
			SIMember mermber = new SIMember("mem"+i, "123123", "mmm", "f", 28, new Date(), "1234123", "xx@com", "degree", "game", "x", "agent"+i, "agentaccount"+i, 1, "img.com", new Date(), new Date(), new Date(), 1, 1, "remark");
			memberService.save(mermber);
		}
	}
	
	public static void addMerchant() {
		for(int i= 1; i < 20; i++) {
			SIMerchant merchant = new SIMerchant("mer"+i, "123123", "pic00", "pic00", "123456", "123456", "www.com", "xxx", "xxx.img", new Date(), "busi00", "xxx@com", "0127123123", "klcc", "", "luffy", "24234234", new Date(), new Date(), new Date(), 1, 1, "remark");
			merchantService.save(merchant);
		}
	}
}
