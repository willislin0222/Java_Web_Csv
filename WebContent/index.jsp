<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Convert Csv Demo</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ConvertCsv/ConvertORACLECsv.do">
		<input type="submit" value="導出ORacleCSV">
	</form>
	
	<form action="<%=request.getContextPath()%>/ConvertCsv/ConvertMSSQLCsv.do">
		<input type="submit" value="導出MSSQLCSV">
	</form>
	
	<form action="<%=request.getContextPath()%>/ConvertCsv/ConvertMYSQLCsv.do">
		<input type="submit" value="導出MYSQLCSV">
	</form>
</body>
</html>