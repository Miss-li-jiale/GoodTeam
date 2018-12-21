package cn.jbit.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jbit.pojo.Categoryid;
import cn.jbit.pojo.Entry;
import cn.jbit.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Resource
	BookService bookService;
	
	@RequestMapping("/listInfo.html")
	public String findByInfo(@RequestParam(value="categoryId",required=false)String categoryId,Model model){
		Integer id=null;
		if (categoryId !=null) {
			id=Integer.parseInt(categoryId);
		}
		//��ȡֵ---��service
		List<Entry> list= bookService.findgetByEx(id);
		List<Categoryid> list2=bookService.findAllCate();
		//��ֵ��װ��model��ҳ���ϵ���
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		return "info";
	}
	@RequestMapping("/selectOne.html")
	public String findInfo(@RequestParam(value="eid")Integer eid,Model model){
		//��ȡֵentry
		Entry entry =bookService.findById(eid);
		String date=new SimpleDateFormat("yyyy.MM.dd").format(entry.getCreateDate());
		//��entry�ŵ�ҳ��
		model.addAttribute("entry", entry);
		model.addAttribute("date",date);
		return "update";
	}
		@RequestMapping("/update.html")
		public String update(Entry entry,Model model,@RequestParam(value="date")String date){
			//��������
			Date cateDate=null;
			try {
			 cateDate =new SimpleDateFormat("yyyy.MM.dd").parse(date);
			} catch (Exception e) {
			e.printStackTrace();
			}
			entry.setCreateDate(cateDate);
			//ִ���޸�
			int num=bookService.updateEntry(entry);
			if (num>0) {
				return "redirect:/book/listInfo.html";
			}
			model.addAttribute("entry", entry);
			return "updte";
		}
		@ResponseBody
		@RequestMapping("/delete.html")
		public String delete(@RequestParam("eid")String eid){
			Integer id =null;
			if (eid !=null) {
				id =Integer.parseInt(eid);	//ת��Ϊint���͵�id
				
			}
			int num=bookService.deleteById(id);
			if (num==0) {
				return "false";
			}
			return "true";
		}
		
		@RequestMapping("/gotoInsert.html")
		public String gotoInsert(@RequestParam("cid")String cid,Model model){
			model.addAttribute("cid", cid);
			return "insert";
			
		}
		//����
		@RequestMapping("/insert.html")
		public String insert(Entry entry,Model model,@RequestParam("date")String date){
			try {
				Date caDate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
				entry.setCreateDate(caDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int num=bookService.save(entry);
			if (num>0) {
				return "redirect:/book/listInfo.html";
			}
			model.addAttribute("entry",entry);
			return "insert";
			
		}
		
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	

}
