<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		//listReply(); // **댓글 목록 불러오기
			listReply2(); // ** json 리턴방식

		// ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
		$("#btnReply").click(function() {
			var claimReplyContents = $("#claimReplyContents").val();
			var customerClaimCode = "${claim.customerClaimCode}"
			var param = "claimReplyContents=" + claimReplyContents + "&customerClaimCode=" + customerClaimCode;
			$.ajax({
				type : "post",
				url : "${path}/insertReply",
				data : param,
				success : function() {
					alert("댓글이 등록되었습니다.");
					listReply2();
				}
			});
		});

		// 게시글 목록 버튼 클릭 이벤트 : 버튼 클릭시 상세보기화면에 있던 페이지, 검색옵션, 키워드 값을 가지로 목록으로 이동
		/* $("#btnList").click(function() {
			location.href = "${path}/board/list.do?curPage=${curPage}&searchOption=${searchOption}&keyword=${keyword}";
		}); */

		/* // 게시글 삭제 버튼 클릭이벤트
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "${path}/board/delete.do";
				document.form1.submit();
			}
		}); */

		// 게시글 수정 버튼 클릭이벤트
		/* $("#btnUpdete").click(function() {
			//var title = document.form1.title.value; ==> name속성으로 처리할 경우
			//var content = document.form1.content.value;
			//var writer = document.form1.writer.value;
			var title = $("#title").val();
			var content = $("#content").val();
			//var writer = $("#writer").val();
			if (title == "") {
				alert("제목을 입력하세요");
				document.form1.title.focus();
				return;
			}
			if (content == "") {
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			if(writer == ""){
			    alert("이름을 입력하세요");
			    document.form1.writer.focus();
			    return;
			} 
			document.form1.action = "${path}/board/update.do"
			// 폼에 입력한 데이터를 서버로 전송
			document.form1.submit();
		});
	}); */

	// RestController방식 (Json)
	// **댓글 목록2 (json)
	function listReply2() {
		$.ajax({
			type : "get",
			//contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
			url : "${path}/reply/listJson.do?bno=${claim.customerClaimCode}",
			success : function(result) {
				console.log(result);
				var output = "<table>";
				for ( var i in result) {
					output += "<tr>";
					output += "<td>" + result[i].userName;
					output += "(" + changeDate(result[i].regdate) + ")<br>";
					output += result[i].replytext + "</td>";
					output += "<tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	// **날짜 변환 함수 작성
	function changeDate(date) {
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
				+ ":" + second;
		return strDate;
	}
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h2>게시글 보기</h2>
				<form name="form1" method="post">
					<div>
						<input type="text" class=" col-md-10 col-sm-10 col-xs-12 form-control" name="customerClaimTitle" value="${claim.customerClaimTitle}">
					</div>
					<div>
						<textarea name="customerClaimContents">${claim.customerClaimContents}</textarea>
					</div>
					<!-- 게시물번호를 hidden으로 처리 -->
					<input type="hidden" name="bno" value="${claim.customerClaimCode}">
				</form>
				<div style="width: 650px; text-align: center;">
					<br>
					<textarea rows="5" cols="80" id="replytext"
						placeholder="댓글을 작성해주세요"></textarea>
					<br>
					<button type="button" id="btnReply">댓글 작성</button>
				</div>
				<!-- **댓글 목록 출력할 위치 -->
				<div id="listReply"></div>
			</div>
		</div>
	</div>
</div>