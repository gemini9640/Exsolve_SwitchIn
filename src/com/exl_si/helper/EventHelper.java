package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.EventPicture;
import com.exl_si.db.vo.SubFile;
import com.exl_si.utils.UuidUtil;

public class EventHelper {
	public static List<EventPicture> assembleInitEventPicture(Integer eventId, String type, List<SubFile> files) {
		List<EventPicture> eventPictures = new ArrayList<EventPicture>();
		for(int i = 0; i< files.size(); i++) {
			EventPicture picture = (EventPicture)files.get(i);
			picture.setId(UuidUtil.get32UUID());
			picture.setEventId(eventId);
			picture.setType(type);
			picture.setIndx(-1);
			eventPictures.add(picture);
		}
		return eventPictures;
	}
}
