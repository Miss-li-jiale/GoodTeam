package cn.jbit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jbit.dao.BookMapper;
import cn.jbit.pojo.Categoryid;
import cn.jbit.pojo.Entry;
import cn.jbit.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	BookMapper bookMapper;

	@Override
	public List<Entry> findgetByEx(Integer id) {
		
		return bookMapper.findgetByEx(id);
	}

	public BookMapper getBookMapper() {
		return bookMapper;
	}

	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public List<Categoryid> findAllCate() {
		
		return bookMapper.findAllCate();
	}

	@Override
	public Entry findById(Integer Id) {
				return bookMapper.findById(Id);
	}

	@Override
	public int updateEntry(Entry entry) {
		
		return bookMapper.updateEntry(entry);
	}

	@Override
	public int deleteById(Integer id) {

		return bookMapper.deleteById(id);
	}

	@Override
	public int save(Entry entry) {
		// TODO Auto-generated method stub
		return bookMapper.save(entry);
	}	
	

}
