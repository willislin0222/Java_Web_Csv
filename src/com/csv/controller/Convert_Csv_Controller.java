package com.csv.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.csv.model.DataVO;

public class Convert_Csv_Controller extends MultiActionController{

	public ModelAndView ConvertCsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<DataVO> list = new ArrayList<DataVO>();
		list.add(new DataVO("aaa","0912468337","2018-04-13","1234"));
		list.add(new DataVO("bbb","0912345677","2018-04-13","56779"));
		list.add(new DataVO("ccc","0912213337","2018-04-13","12345454"));
		list.add(new DataVO("ddd","0912132337","2018-04-13","123gdsg4"));
		System.out.println("ConvertCsv 方法被呼叫:");
		//導出Csv檔
		try {
			   String name = "/ConverCsv.csv";
			   //判斷路徑是否存在，不存在就建立路徑
	            File savepath = new File(request.getServletContext().getRealPath("/convert"));
	            if(!savepath.exists()){
	            	savepath.mkdirs();
	            }
	           FileWriter fw = new FileWriter(savepath + name);
			   String header = "name,phone,date,address\r\n";
			   fw.write(header);
			   for (int i = 0; i<list.size(); i++) {
			    StringBuffer str = new StringBuffer();
			     str.append(list.get(i).getName() + "," + list.get(i).getPhone() + "," + list.get(i).getDate() + "," + list.get(i).getAddress() + "\r\n") ;
			    fw.write(str.toString());
			    fw.flush();

			   }
			   fw.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		//return new ModelAndView("redirect:/result/ConvertOK.jsp", "greetingKey", ename);
		return new ModelAndView("redirect:/result/ConvertOK.jsp");
		
	}
}
