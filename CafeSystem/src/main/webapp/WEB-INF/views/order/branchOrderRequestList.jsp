<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function(){
		$('.cancelBtn').click(function(){			
			 var orderCate = $(this).parents('tr').find('.orderCate').val();
			 var receiptCate = $(this).parents('tr').find('.receiptCate').val();
			 var statmentNumber = $(this).parents('tr').find('.statementNumber').text();
			 
			console.log("statmentNumber: " + statmentNumber);
			if(orderCate == '711' || orderCate == '710'){
				alert('해당 상품은 배송중이므로 취소가 불가능합니다.');
				return false;
			}else{
				result = confirm('정말 해당 주문을 취소신청 하시겠습니까?');
				if(result){
					 $(location).attr('href','${pageContext.request.contextPath}/branchOrderCancel?statementNumber='+statmentNumber+'&receiptCategoryCode='+receiptCate+'&orderCategoryCode='+orderCate+'');
					 alert('정상 처리되었습니다');
				}
			}      
		});	
		
});          
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주관리</h3>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주신청내역 조회 <small></small></h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						신청내역 리스트
						
						<form id="SearchForm" action="${pageContext.request.contextPath}/branchOrderRequestList" method="post">
							<div>
								<div>
									<select name="cate" id="cate" required class="input-sm">
										<option id="opt" value="${cate}" class="input-sm">검색 조건 선택</option>
										<option value="statement_number" class="input-sm">전표번호</option>
										<option value="divideName" class="input-sm">접수상태</option>
										<option value="cateOrder" class="input-sm">배송상태</option>
									</select>
									<div class="input-group">
										<input type="text" name="input" id="input" value="${input}"	required class="input-sm"> <span>
										<input type="submit" class="btn btn-default" id="SearchBtn" value="검색">
										</span>
									</div>
								</div>
							</div>
						</form>						
				
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>총가격</th>
									<th>접수상태</th>
									<th>신청일</th>
									<th>배송상태</th>
									<th>발주승인 담당자</th>
									<th>발주/불량구분</th>
									<th>환불 신청</th>
									<th>취소 신청</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="request" items="${orderRequestList}">
									<tr>
										<td class="statementNumber"><a href="${pageContext.request.contextPath}/branchOrderRequestDetail?statementNumber=${request.statementNumber}">${request.statementNumber}</a></td>
										<td>${request.calComma}원</td>
										<td><input class="receiptCate"type="hidden" value="${request.receiptCategoryCode}">${request.cateReceipt}</td>
										<td><input class="orderCate" type="hidden" value="${request.orderCategoryCode}" >${request.orderRequest}</td>
										<td>${request.cateOrder}</td>
										<td>${request.headName}</td>
										<td>${request.divideName}</td>
										<td><a href="${pageContext.request.contextPath}/?statementNumber=${request.statementNumber}">환불신청</a></td>
										<td><button class="cancelBtn" type="button">취소신청</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>