package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.EventPicture;
import com.exl_si.db.vo.SubFile;

public class EventHelper {
	public static List<EventPicture> assembleEventPicture(Integer eventId, String type, List<SubFile> files) {
		List<EventPicture> eventPictures = new ArrayList<EventPicture>();
		for(int i = 0; i< files.size(); i++) {
			EventPicture picture = (EventPicture)files.get(i);
			picture.setEventId(eventId);
			picture.setType(type);
			picture.setIndex(i);
			eventPictures.add(picture);
		}
		return eventPictures;
	}
}
