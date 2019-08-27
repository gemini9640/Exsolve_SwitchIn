package com.exl_si.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.exl_si.common.AppProperties;

public class PropertiesUtil {
	private static final Log log = LogFactory.getLog(PropertiesUtil.class);
	private static Map<Class, URL> configMap = new HashMap<Class, URL>();

	private static final char LIST_DELIMITER = '|';

	static {
		AbstractConfiguration.setDefaultListDelimiter(LIST_DELIMITER);
	}

	public static void main(String[] args) {
		initProperySet();
		System.out.println(AppProperties.UPLOAD_PATH);
	}
	
	private static void initProperySet() {
		configMap.put(AppProperties.class, PropertiesUtil.class.getResource("/conf/app.properties"));
		Iterator<Class> it = configMap.keySet().iterator();
		while (it.hasNext()) {
			Class cls = it.next();
			setValues(cls);
		}
	}

	public static void reload(Class cls) {
		setValues(cls);
	}

	public synchronized static void setValues(Class cls) {
		URL url = configMap.get(cls);
		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(url);
			config.clear();
			config.load(new FileInputStream(config.getFile()), "UTF-8");
			Map<String, Field> fieldMap = new HashMap<String, Field>();
			Field[] fields = cls.getFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String key = field.getName();
				Object value = config.getProperty(key);
				if (value == null) {
					log.error("cant find value from property file to inject [" + key + "]");
				} else {
					try {
						if (field.get(null) != null) {
							Object original = field.get(null);
							Object modified = value;
							if (!oEquals(original, modified)) {
								log.info(key + " is modified ,original:[" + original + "," + original.getClass() + "],modified:[" + modified + "," + modified.getClass() + "]");
							}
						}
					} catch (Exception e) {
						log.error(null, e);
					}
					if (value instanceof List)
						field.set(null, value);
					else if (field.getType() == List.class) {
						List list = new ArrayList();
						list.add(value);
						field.set(null, list);
					} else
						field.set(null, ConvertUtils.convert((String) value, field.getType()));
				}
			}
		} catch (Exception e1) {
			log.error("set field value failed", e1);
		} finally {
			config = null;
		}
	}

	private static boolean oEquals(Object o1, Object o2) {
		if (o1 instanceof Collection && o2 instanceof Collection) {
			return CollectionUtils.isEqualCollection((Collection) o1, (Collection) o2);
		} else {
			return ObjectUtils.equals(o1, ConvertUtils.convert(o2.toString(), o1.getClass()));
		}
	}

//	public static NetpayCode getNetpayCode() {
//		InputStream in = PropertiesUtil.class.getResourceAsStream("/conf/properties/pay/netpayCode.properties");
//		Properties prop = OrderedProperties.getProperties(in);
//		NetpayCode netpayCode = new NetpayCode();
//		for(Object o : prop.keySet()) {
//			String key = o.toString();
//			netpayCode.getCodeMap().put(key, prop.getProperty(key));
//		}
//		return netpayCode;
//	}
//	
//	public static NetpayModel getNetpayModel(String netpayName) {
//		InputStream in = PropertiesUtil.class.getResourceAsStream("/conf/properties/pay/"+netpayName+".properties");
//		NetpayModel netpayModel = new NetpayModel();
//		if(in == null)
//			return netpayModel;
//		OrderedProperties prop = OrderedProperties.getProperties(in);
//		for(Object o : prop.keySet()) {
//			String key = o.toString();
//			if(key.equals("code"))
//				netpayModel.setCode(prop.get(key).toString());
//			else if(key.equals("name"))
//				netpayModel.setName(prop.get(key).toString());
//			else if(StringUtils.isNotEmpty(prop.getProperty(key)))
//				netpayModel.getBankSuppot().put(key, prop.getProperty(key));
//		}
//		return netpayModel;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(getNetpayCode().codes());
//	}
}
