package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exl_si.db.SequenceNo;
import com.exl_si.mapper.SequenceNoMapper;

public class TestMapper {
	private static ApplicationContext ctx; 
	private static SequenceNoMapper sequenceNoMapper;
	
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("/conf/spring/applicationContext-main.xml");
		sequenceNoMapper = (SequenceNoMapper) ctx.getBean("sequenceNoMapper");
	}
	
	public static void main(String[] args) {
		try {
			init();
//			saveSequenceNo();
			updateSequenceNo();
			querySequenceNo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	public static void saveSequenceNo() {
		SequenceNo sequenceNo = new SequenceNo();
		sequenceNo.setSimerchanttotal(0);
		sequenceNoMapper.insertSelective(sequenceNo);
	}
	
	public static void querySequenceNo() {
		System.out.println(sequenceNoMapper.selectByField("siMerchantTotal"));
	}
	
	public static void updateSequenceNo() {
		System.out.println(sequenceNoMapper.updateByField("siMerchantTotal", 1));
	}
}
