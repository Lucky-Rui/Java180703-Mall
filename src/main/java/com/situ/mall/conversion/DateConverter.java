package com.situ.mall.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/*
 * 日期转换的Converter
 * S:代表页面传过来的类型
 * T:转换后的类型
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if (null != source) {// 2018-01-22
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				return format.parse(source);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}