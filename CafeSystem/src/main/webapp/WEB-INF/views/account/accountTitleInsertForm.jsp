<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>account_title_insert_form</h1>
	<form action="./insertAccountTitle" method="post">
		<table border="1">
			<tr>
				<td>account_title_name</td>
				<td><input type="text" name="accountTitleName"></td>				
			</tr>
			<tr>
				<td>account_title_content</td>
				<td><input type="text" name="accountTitleContent"></td>				
			</tr>
		</table>
		<input type="submit" value="insertAccountTitle">
	</form>

</body>
</html>