package com.exl_si.helper;

import com.exl_si.common.Constants;
import com.exl_si.db.EXLAgent;
import com.exl_si.db.EXLClient;
import com.exl_si.db.Event;
import com.exl_si.db.SIMember;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.Voucher;
import com.exl_si.mapper.SequenceNoMapper;

public class SequenceNoHelper {
	private static volatile Integer SI_MERCHANT_SEQUENCE;
	private static volatile Integer SI_MEMBER_SEQUENCE;
	private static volatile Integer EXL_CLIENT_SEQUENCE;
	private static volatile Integer EXL_AGENT_SEQUENCE;
	private static volatile Integer EVENT_SEQUENCE;
	private static volatile Integer VOUCHER_SEQUENCE;

	public static Integer getTotalVoucher(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("voucherTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setVoucherSequenceId(Voucher voucher, SequenceNoMapper sequenceNoMapper) {
		VOUCHER_SEQUENCE = getTotalVoucher(sequenceNoMapper) + 1;
		voucher.setId(Constants.IdPrefix.VOUCHER + VOUCHER_SEQUENCE);
	}

	public static void updateVoucherSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (VOUCHER_SEQUENCE != null)
			sequenceNoMapper.updateByField("voucherTotal", VOUCHER_SEQUENCE);
		else
			sequenceNoMapper.updateByField("voucherTotal", getTotalVoucher(sequenceNoMapper) + 1);
		VOUCHER_SEQUENCE = null;
	}

	public static Integer getTotalEvent(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("eventTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setEventSequenceId(Event event, SequenceNoMapper sequenceNoMapper) {
		EVENT_SEQUENCE = getTotalEvent(sequenceNoMapper) + 1;
		event.setId(Constants.IdPrefix.EVENT + EVENT_SEQUENCE);
	}

	public static void updateEventSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (EVENT_SEQUENCE != null)
			sequenceNoMapper.updateByField("eventTotal", EVENT_SEQUENCE);
		else
			sequenceNoMapper.updateByField("eventTotal", getTotalEvent(sequenceNoMapper) + 1);
		EVENT_SEQUENCE = null;
	}

	public static Integer getTotalMerchant(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("siMerchantTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setMerchantSequenceId(SIMerchant merchant, SequenceNoMapper sequenceNoMapper) {
		SI_MERCHANT_SEQUENCE = getTotalMerchant(sequenceNoMapper) + 1;
		merchant.setId(Constants.IdPrefix.SI_MERCHANT + SI_MERCHANT_SEQUENCE);
	}

	public static void updateMerchantSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (SI_MERCHANT_SEQUENCE != null)
			sequenceNoMapper.updateByField("siMerchantTotal", SI_MERCHANT_SEQUENCE);
		else
			sequenceNoMapper.updateByField("siMerchantTotal", getTotalMerchant(sequenceNoMapper) + 1);
		SI_MERCHANT_SEQUENCE = null;
	}

	public static Integer getTotalMember(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("siMemberTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setMemberSequenceId(SIMember member, SequenceNoMapper sequenceNoMapper) {
		SI_MEMBER_SEQUENCE = getTotalMember(sequenceNoMapper) + 1;
		member.setId(Constants.IdPrefix.SI_MEMBER + SI_MEMBER_SEQUENCE);
	}

	public static void updateMemberSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (SI_MEMBER_SEQUENCE != null)
			sequenceNoMapper.updateByField("siMemberTotal", SI_MEMBER_SEQUENCE);
		else
			sequenceNoMapper.updateByField("siMemberTotal", getTotalMember(sequenceNoMapper) + 1);
		SI_MEMBER_SEQUENCE = null;
	}

	public static Integer getTotalEXLClient(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("exlClientTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setEXLClientSequenceId(EXLClient client, SequenceNoMapper sequenceNoMapper) {
		EXL_CLIENT_SEQUENCE = getTotalEXLClient(sequenceNoMapper) + 1;
		client.setId(Constants.IdPrefix.EXL_CLIENT + EXL_CLIENT_SEQUENCE);
	}

	public static void updateEXLClientSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (EXL_CLIENT_SEQUENCE != null)
			sequenceNoMapper.updateByField("exlClientTotal", EXL_CLIENT_SEQUENCE);
		else
			sequenceNoMapper.updateByField("exlClientTotal", getTotalEXLClient(sequenceNoMapper) + 1);
		EXL_CLIENT_SEQUENCE = null;
	}

	public static Integer getTotalEXLAgent(SequenceNoMapper sequenceNoMapper) {
		String total = sequenceNoMapper.selectByField("exlAgentTotal");
		return Integer.valueOf(total);
	}

	public static synchronized void setEXLAgentSequenceId(EXLAgent agent, SequenceNoMapper sequenceNoMapper) {
		EXL_AGENT_SEQUENCE = getTotalEXLAgent(sequenceNoMapper) + 1;
		agent.setId(Constants.IdPrefix.EXL_AGENT + EXL_AGENT_SEQUENCE);
	}

	public static void updateEXLAgentSequenceNo(SequenceNoMapper sequenceNoMapper) {
		if (EXL_AGENT_SEQUENCE != null)
			sequenceNoMapper.updateByField("exlAgentTotal", EXL_AGENT_SEQUENCE);
		else
			sequenceNoMapper.updateByField("exlAgentTotal", getTotalEXLAgent(sequenceNoMapper) + 1);
		EXL_AGENT_SEQUENCE = null;
	}
}
