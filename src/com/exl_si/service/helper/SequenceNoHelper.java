package com.exl_si.service.helper;

import com.exl_si.mapper.SequenceNoMapper;

public class SequenceNoHelper {
	public static Integer getTotalMerchant(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("siMerchantTotal");
		return Integer.valueOf(total);
	}
}
