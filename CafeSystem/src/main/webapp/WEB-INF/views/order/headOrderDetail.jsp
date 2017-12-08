<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		//발주 승인 버튼 클릭
		$('#orderApprovalBtn').click(function(){
			var result = confirm('정말 해당 발주를 승인하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headOrder?statementNumber=${statementNumber}');
			}
		})
		
		//발송 완료 버튼 클릭
		$('#orderDeliveryBtn').click(function(){
			var result = confirm('발송 완료 처리 하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headOrderDelivery?statementNumber=${statementNumber}');
			}
		})
		
		//취소 승인 버튼 클릭
		$('#orderCancelBtn').click(function(){
			var result = confirm('해당 발주의 취소요청을 승인하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headOrderCancel?statementNumber=${statementNumber}');
			}
		})
		
		//환불 승인 버튼 클릭
		$('#orderRefundBtn').click(function(){
			var result = confirm('해당 발주의 환불요청을 승인하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headOrderRefund?statementNumber=${statementNumber}');
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
								<c:if test="${headOrder.get(0).getOrderApproval() ne null}">
									<th>발주 승인일: ${headOrder.get(0).getOrderApproval()}</th>
								</c:if>
								<th>발주 신청일: ${headOrder.get(0).getOrderRequest()}</th>
								<c:if test="${headOrder.get(0).getOrderRelease() ne null}">
									<th>출고일: ${headOrder.get(0).getOrderRelease()}</th>
								</c:if>
								<th>배송상태: ${headOrder.get(0).getOrderCateName()}</th>
								<c:if test="${headOrder.get(0).getHeadEmployeeCode() ne null}">
									<th>승인담당자: ${headOrder.get(0).getHeadEmployeeCode()}</th>
								</c:if>								
							</tr>
							<tr>
								<c:if test="${headOrderCancel.orderCancelRequest ne null}">
									<th>취소 신청일: ${headOrderCancel.orderCancelRequest}</th>
								</c:if>
								<c:if test="${headOrderCancel.orderCancelApproval ne null}">
									<th>취소 승인일: ${headOrderCancel.orderCancelApproval}</th>
								</c:if>
								<c:if test="${headOrderCancel.headEmployeeCode ne null}">
									<th>취소 승인 담당자: ${headOrderCancel.headEmployeeCode}</th>
								</c:if>
								<c:if test="${headOrderCancel.orderRefundAble ne null}">
									<th>환불여부: ${headOrderCancel.orderRefundAble}</th>
								</c:if>
								<c:if test="${headOrderCancel.orderRefundStatement ne null}">
									<th>환불 전표번호: ${headOrderCancel.orderRefundStatement}</th>
								</c:if>
								<c:if test="${headOrderCancel.orderRefundDate ne null}">
									<th>환불 날짜: ${headOrderCancel.orderRefundDate}</th>
								</c:if>
								<c:if test="${headOrderCancel.orderRefundAdmin ne null}">
									<th>환불 승인담당자: ${headOrderCancel.orderRefundAdmin}</th>
								</c:if>	
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
							<c:if test="${headOrderCancel.orderCancelRequest eq null}">
								<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/headOrderList'">목록으로</button>
							</c:if>
							<c:if test="${headOrderCancel.orderCancelRequest ne null}">
								<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/headOrderCancelList'">목록으로</button>
							</c:if>	
							<c:if test="${headOrder.get(0).getHeadEmployeeCode() eq null}">
								<button type="button" class="btn btn-default" id="orderApprovalBtn">발주승인</button>
							</c:if>
							<c:if test="${headOrder.get(0).getOrderCateCode() eq '709'}">
								<button type="button" class="btn btn-default" id="orderDeliveryBtn">발송완료</button>
							</c:if>
							<c:if test="${headOrderCancel.headEmployeeCode eq null}">
								<button type="button" class="btn btn-default" id="orderCancelBtn">취소승인</button>
							</c:if>
							<c:if test="${headOrderCancel.orderRefundAdmin eq null}">
								<button type="button" class="btn btn-default" id="orderRefundBtn">환불승인</button>
							</c:if>
						</div>
					</div>	
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>