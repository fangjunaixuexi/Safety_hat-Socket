package com.dajingzhu.socket;

import java.text.SimpleDateFormat;

public class ToDateTime {
	public String Time_conversion(String a) throws Exception {

		SimpleDateFormat format1 = new SimpleDateFormat("ddMMyy-hhmmss");

		long time = format1.parse(a).getTime() / 1000;

		time = time + (8 * 3600);

		SimpleDateFormat format2 = new SimpleDateFormat("20yy-MM-dd hh:mm:ss");
		time = time * 1000;

		String format = format2.format(time);

		return format;

	}
}
