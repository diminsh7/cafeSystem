<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		//발주 승인 버튼 클릭
		$('#orderApprovalBtn').click(function(){
			var result = confirm('정말 해당 발주를 승인하시겠습니까?');
			//var statementNumber = $(this).parents('x_title').find('h2').text();
			
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headOrder?statementNumber=${statementNumber}');
			}
		})
	})
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주 상세정보 <small>${shopName}</small></h3>
			</div>
		</div>

		<div class="clearfix"></div>
		
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>전표번호: ${statementNumber}</h2>
						<div class="clearfix"></div>
					</div>
					
					<div class="x_content">
						<table class="table table-bordered">
							<tr>
								<th>총액: ${orderAllPrice} 원</th>
								<th>접수 상태: ${headOrder.get(0).getReceiptCateName()}</th>
								<c:if test="${headOrder.get(0).getOrderApproval() ne null}"><th>발주 승인일: ${headOrder.get(0).getOrderApproval()}</th></c:if>
								<th>발주 신청일: ${headOrder.get(0).getOrderRequest()}</th>
								<c:if test="${headOrder.get(0).getOrderRelease() ne null}"><th>출고일: ${headOrder.get(0).getOrderRelease()}</th></c:if>
								<th>배송상태: ${headOrder.get(0).getOrderCateName()}</th>
								<c:if test="${headOrder.get(0).getHeadEmployeeCode() ne null}"><th>승인담당자: ${headOrder.get(0).getHeadEmployeeCode()}</th></c:if>
							</tr>
						</table>

						<table class="table table-striped">
							<thead>
								<tr>									
									<th>품목명</th>
									<th>수량</th>
									<th>가격</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="headOrder" items="${headOrder}">
									<tr>
										<td>${headOrder.itemName}</td>
										<td>${headOrder.orderAmount}</td>
										<td>${headOrder.orderPriceComma} 원</td>								
									</tr>
								</c:forEach>
							</tbody>				
						</table>
						<div class="text-center">
							<button type="button" class="btn btn-primary" onclick="history.back();">뒤로가기</button>
							<%-- <c:if test="${headOrder.get(0).getHeadEmployeeCode() eq null}"> --%>
								<button type="button" class="btn btn-success" id="orderApprovalBtn">발주승인</button>
							<%-- </c:if> --%>
						</div>
					</div>	
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>