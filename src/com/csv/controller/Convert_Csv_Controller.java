package com.csv.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.csv.model.DataVO;

public class Convert_Csv_Controller extends MultiActionController{

	public void ConvertCsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<DataVO> list = new ArrayList<DataVO>();
		list.add(new DataVO("aaa","0912468337","2018-04-13","1234"));
		list.add(new DataVO("bbb","0912345677","2018-04-13","56779"));
		list.add(new DataVO("ccc","0912213337","2018-04-13","12345454"));
		list.add(new DataVO("ddd","0912132337","2018-04-13","123gdsg4"));
		list.add(new DataVO("eee","0912455337","2018-04-13","12fdsfdsf34"));
		System.out.println("ConvertCsv 方法被呼叫:");
		//導出Csv檔
		try {

			   FileWriter fw = new FileWriter("h:\\ConvertCsv.csv");
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
		
		
	}
}
