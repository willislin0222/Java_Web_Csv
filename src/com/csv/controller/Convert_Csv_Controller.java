package com.csv.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
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
import com.csv.model.EMPDAO;
import com.csv.model.EmpVO;

public class Convert_Csv_Controller extends MultiActionController{

	Connection conn = null;
//	取的oracle資料庫資料
	public ModelAndView ConvertORACLECsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ConvertORACLECsv 方法被呼叫:");
		conn = new GetOracleDataBase().GetOracleConnecct();
		EMPDAO dao = new EMPDAO();
		List<EmpVO> list = dao.getAll(conn);
		//建立檔案
		String name = "/ConverOracleCsv.csv";
		//判斷路徑是否存在，不存在就建立路徑
        File savepath = new File(request.getServletContext().getRealPath("/convert"));
        if(!savepath.exists()){
         	savepath.mkdirs();
        }
        FileWriter fw = new FileWriter(savepath + name);
        String header = "empno,ename,job,hiredate,sal,comm,deptno\r\n";
        fw.write(header);
		//輸出Csv檔
		for(EmpVO alist : list){			   
			StringBuffer str = new StringBuffer();
			str.append(alist.getEmpno() + "," + alist.getEname() + "," + alist.getJob() + "," + alist.getHiredate() + "," + alist.getSal() + ","+ alist.getComm() + "," + alist.getDeptno() + "\r\n") ;
			fw.write(str.toString());	
		}
		fw.flush();
		fw.close();
		return new ModelAndView("redirect:/result/ConvertOK.jsp");
		
	}
	
//	取的mssql資料庫資料
    public ModelAndView ConvertMSSQLCsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ConvertMSSQLCsv 方法被呼叫:");
		conn = new GetMSSQLDataBase().GetMSSQLConnecct();
		EMPDAO dao = new EMPDAO();
		List<EmpVO> list = dao.getAll(conn);
		//建立檔案
		String name = "/ConverMSSQLCsv.csv";
		//判斷路徑是否存在，不存在就建立路徑
        File savepath = new File(request.getServletContext().getRealPath("/convert"));
        if(!savepath.exists()){
         	savepath.mkdirs();
        }
        FileWriter fw = new FileWriter(savepath + name);
        String header = "empno,ename,job,hiredate,sal,comm,deptno\r\n";
        fw.write(header);
		//輸出Csv檔
		for(EmpVO alist : list){			   
			StringBuffer str = new StringBuffer();
			str.append(alist.getEmpno() + "," + alist.getEname() + "," + alist.getJob() + "," + alist.getHiredate() + "," + alist.getSal() + ","+ alist.getComm() + "," + alist.getDeptno() + "\r\n") ;
			fw.write(str.toString());	
		}
		fw.flush();
		fw.close();
		return new ModelAndView("redirect:/result/ConvertOK.jsp");
		
	}
    
//	取的mysql資料庫資料  
    public ModelAndView ConvertMYSQLCsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ConvertMYSQLCsv 方法被呼叫:");
		conn = new GetMYSQLDataBase().GetMYSQLConnecct();
		EMPDAO dao = new EMPDAO();
		List<EmpVO> list = dao.getAll(conn);
		//建立檔案
		String name = "/ConverMYSQLCsv.csv";
		//判斷路徑是否存在，不存在就建立路徑
        File savepath = new File(request.getServletContext().getRealPath("/convert"));
        if(!savepath.exists()){
         	savepath.mkdirs();
        }
        FileWriter fw = new FileWriter(savepath + name);
        String header = "empno,ename,job,hiredate,sal,comm,deptno\r\n";
        fw.write(header);
		//輸出Csv檔
		for(EmpVO alist : list){			   
			StringBuffer str = new StringBuffer();
			str.append(alist.getEmpno() + "," + alist.getEname() + "," + alist.getJob() + "," + alist.getHiredate() + "," + alist.getSal() + ","+ alist.getComm() + "," + alist.getDeptno() + "\r\n") ;
			fw.write(str.toString());	
		}
		fw.flush();
		fw.close();
		return new ModelAndView("redirect:/result/ConvertOK.jsp");
		
	}
}
