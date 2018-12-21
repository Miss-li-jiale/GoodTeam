package cn.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Categoryid;
import cn.jbit.pojo.Entry;

public interface BookMapper {
	List<Entry> findgetByEx(@Param("id")Integer id);
	List<Categoryid> findAllCate();
	
	Entry findById(@Param("id")Integer Id);
	//�޸�
	int updateEntry(Entry entry);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id")Integer id);

	//����
	int save(Entry entry);
}
