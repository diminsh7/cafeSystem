<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		$('#Managerinsert').click(function() {
			if ($('#birth').val().length = 6) {
				alert('생년월일은는 6자리여야 합니다.');
				$('#birth').focus();
			}
			$('#Managerinsert').submit();
		});
	});
</script>

<title>BranchManagerInsertForm 지점 지정장 등록 폼</title>
</head>
<body>
	<div>
		<h1>지점 지점장 등록 폼</h1>
		<form action="">
			<table>
				<tr>
					<th>지역</th>
					<td>
						<select>
							<c:forEach var="local" items="${List}">
							<option>${local.localcode}</option>
							</c:forEach>	
						</select>
					</td>
					<!-- ${BranchManager.localcode} -->
				</tr>
				<tr>
					<th>매장번호</th>
					<td><input type="text" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input type="text" value="지점장" name="" id="" readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" value="" name="birth" id="birth"
						placeholder="ex)990101"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" value="" name="" id=""
						placeholder="ex)000-0000-0000"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>보건증</th>
					<td><input type="file" name="" name="" id=""></td>
				</tr>
				<tr>
					<th>사업자번호</th>
					<td><input type="text" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>사업시작일</th>
					<td><input type="date" value="" name="" id=""></td>
				</tr>
				<tr>
					<th>사업계좌은행명</th>
					<td><select name="" id="">
							<option>우리</option>
							<option>국민</option>
							<option>신한</option>
							<option>하나</option>
							<option>카카오</option>
							<option>신한</option>
							<option>외한은행</option>
							<option>SC은행</option>
							<option>KDB산업은행</option>
					</select></td>
				</tr>
				<tr>
					<th>사업계좌번호</th>
					<td><input type="text" value=""
						placeholder=" ex)100212341234 '-'를 적지마세요"></td>
				</tr>
			</table>
			<input type="button" value="지점장 등록" id="Managerinsert">
		</form>
	</div>

</body>
</html>