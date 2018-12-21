package cn.jbit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Categoryid;
import cn.jbit.pojo.Entry;

public interface BookService {
	List<Entry> findgetByEx(Integer id);

	List<Categoryid> findAllCate();
	Entry findById(@Param("id")Integer Id);
	//ÐÞ¸Ä
	int updateEntry(Entry entry);
	//É¾³ý
	int deleteById(@Param("id")Integer id);
	//ÐÂÔö
	int save(Entry entry);
}
