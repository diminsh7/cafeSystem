<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
function deleteb(){
	if (confirm("한번 삭제하면 다시 생성할 수 없습니다.") == true){  //삭제처리
		document.$('#DeleteButton').submit();
	}else{   
			return false; //삭제 취소
	};
};
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchPersonnelList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchPersonneel">직원등록</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>선택직원상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix">
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>발주상태</th>
									<th>품명명</th>
									<th>수량</th>
									<th>가격</th>
									<th>발주금액</th>
									<th>신청일</th>
									<th>승인일</th>
									<th>출고일</th>
									<th>접수상태</th>
									<th>배송상태</th>
									<th>승인담당장</th>
									<th>불량여부</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${orderDetail.statementNumber}</td>
									<td>${orderDetail.divideName}</td>
									<td>${orderDetail.itemName}</td>
									<td>${orderDetail.orderAmount}</td>
									<td>${orderDetail.orderPrice}</td>
									<td>${orderDetail.cal}</td>
									<td>${orderDetail.orderRequest}</td>
									<td>${orderDetail.orderApproval}</td>
									<td>${orderDetail.orderRelease}</td>
									<td>${orderDetail.cateReceipt}</td>
									<td>${orderDetail.cateOrder}</td>
									<td>${orderDetail.headName}</td>
									<td>${orderDetail.orderFaultyAble}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>