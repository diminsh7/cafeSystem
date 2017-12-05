<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	
	$(document).ready(function(){
		var beanTea = "601";
		var syrupSource = "602";
		var powder = "603";
		var drinkWhip = "604"; 
		var takeOutItem = "606";
		var cafeItem = "607";
		var freeze = "608";
				
		//수량 증가 시 
		$(document).on('click', '.countPlus', function(){
			
			//수량(숫자) 증가
			var itemCountSelect = $(this).parents('td').find('input');
			var itemCount = itemCountSelect.val();
			var itemCodeSelect = $(this).parents('tr').children('.itemCode').text();
			itemCount++;
			itemCountSelect.val(itemCount);
			
			//수량에 따른 총액 계산
			var itemPriceSelect = $(this).parents('tr').children('.itemPrice').find('input');
			$.ajax({
				url:"branchOrder/itemPriceCal"
					, type:'GET'
					, data:{"itemCount":itemCount, "itemCodeSelect":itemCodeSelect}
					, success:function(data){
						var itemPriceResult = JSON.parse(data);
						itemPriceSelect.val(itemPriceResult);	
					}
					, error:function(request, status, error){
						alert('실패');
					}
			});
		});
		
		//수량 감소
		$(document).on('click', '.countMinus', function(){
			var itemSelect = $(this).parents('td').find('input');
			var itemCount = itemSelect.val();
			var itemCodeSelect = $(this).parents('tr').children('.itemCode').text();
			if(itemCount < 1){
				alert('최소 수량입니다');
			} else {
				itemCount--;
				itemSelect.val(itemCount);
				
				var itemPriceSelect = $(this).parents('tr').children('.itemPrice').find('input');
				$.ajax({
					url:"branchOrder/itemPriceCal"
						, type:'GET'
						, data:{"itemCount":itemCount, "itemCodeSelect":itemCodeSelect}
						, success:function(data){
							var itemPriceResult = JSON.parse(data);
							itemPriceSelect.val(itemPriceResult);
							
							$('#orderPrice').val();
							
						}
						, error:function(request, status, error){
							alert('실패');
						}
				});
			}
		});
		
		//장바구니로 옮기기
		$(document).on('click', '.itemAddBtn', function(){
			var leftItem = $(this).parents('tr').clone();
			leftItem.find('.itemPrice').before('<td><button type="button" class="countMinus">-</button><input type="text" class="itemCount" style="text-align: center; width: 25px;" value=1><button type="button" class="countPlus">+</button></td>');
			leftItem.find('.itemAddBtn').removeClass().addClass('itemDelBtn').text('삭제');
			$('.basket').append(leftItem);
			//$(this).parents('tr').remove();
		});	
		
		//장바구니에서 삭제
		$(document).on('click', '.itemDelBtn', function(){
			var rightItem = $(this).parents('tr').clone();
			rightItem.find('.itemDelBtn').removeClass().addClass('itemAddBtn').text('담기');
			//rightItem.find('.itemCountBlock').remove();
			//$('#tbody').append(rightItem);
			$(this).parents('tr').remove();
		});
		
		//원두/티 카테고리 품목 요청
		$('#beanTea').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":beanTea}
				, success:function(data){
					var list = JSON.parse(data);
					var tbody = [];
					$(list).each(function(i, list){						
						tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//시럽/소스 카테고리 품목 요청
		$('#syrupSource').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":syrupSource}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//파우더 카테고리 품목 요청
		$('#powder').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":powder}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//음료/휘핑 카테고리 품목 요청
		$('#drinkWhip').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":drinkWhip}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					});
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//테이크아웃용품 카테고리 품목 요청
		$('#takeOutItem').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":takeOutItem}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//카페용품 카테고리 품목 요청
		$('#cafeItem').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":cafeItem}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" class="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//냉동품 카테고리 품목 요청
		$('#freeze').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":freeze}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){					
						tbody.push('<tr>');
						tbody.push('<td scope="row" class="itemCode">'+list.itemCode+'</td>');
						tbody.push('<td>'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td class="itemPrice"><input type="text" style="text-align:center; width:60px;" value="'+list.itemPrice+'" readonly></td>');
						tbody.push('<td><button type="button" id="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
		
		//주문
		$("#orderBtn").click(function(){
			result = confirm('주문하시겠습니까?');
			if(result){
				$('#basketForm').submit();
			}
		})
	});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주 신청<small> 지점</small></h3>
			</div>

			<div class="title_right">
				<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search for...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<small>
								<button type="button" id="beanTea">원두/티</button>
								<button type="button" id="syrupSource">시럽/소스</button>
								<button type="button" id="powder">파우더</button>
								<button type="button" id="drinkWhip">음료/휘핑</button>
								<button type="button" id="takeOutItem">테이크아웃용품</button>
								<button type="button" id="cafeItem">카페용품</button>
								<button type="button" id="freeze">냉동품</button>
							</small>
						</h2>
						
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<table class="table table-striped">
							<thead>
								<tr>
									<th>코드</th>
									<th>구분</th>
									<th>품목명</th>
									<th>용량(g/ml)</th>
									<th>가격(원)</th>
									<th>담기</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach var="branchOrderList" items="${branchOrderList}">								
									<tr class="itemList">
										<td class="itemCode">${branchOrderList.itemCode}</td>
										<td>${branchOrderList.itemCateName}</td>
										<td>${branchOrderList.itemName}</td>
										<td>${branchOrderList.itemSize}</td>
										<td class="itemPrice"><input class="itemPriceNum" type="text" style="text-align:center; width:60px;" value="${branchOrderList.itemPrice}" readonly></td>			
										<td><button type="button" class="itemAddBtn">담기</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>


			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><small>장바구니</small></h2>
						
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					
					<form id="basketForm" action="${pageContext.request.contextPath}/branchOrderList" method="post">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>코드</th>
									<th>구분</th>
									<th>품목명</th>
									<th>용량(g/ml)</th>
									<th>수량</th>
									<th>가격(원)</th>								
									<th>삭제</th>
								</tr>
							</thead>
							<tbody class="basket">
							</tbody>
						</table>
						<div class="text-center">
							<button id="orderBtn" type="button">발주신청</button>
						</div>
					</form>
					</div>
				</div>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</div>