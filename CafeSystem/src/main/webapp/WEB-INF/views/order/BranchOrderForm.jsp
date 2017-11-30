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
		
		//원두/티 카테고리 품목 요청
		$('#beanTea').click(function(){			
			$.ajax({ 
				url:"branchOrder/itemSelect"
				, type:'GET'
				, data:{"itemCate":beanTea}
				, success:function(data){
					var list = JSON.parse(data);
					console.log(list);
					var tbody = [];
					console.log(list.itemCateName);
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
					$(list).each(function(i, list){
						tbody.push('<tr>');
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
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
						tbody.push('<form>');
						tbody.push('<tr>');
						tbody.push('<td scope="row">'+list.itemCateName+'</td>');
						tbody.push('<td>'+list.itemName+'</td>');
						tbody.push('<td>'+list.itemSize+'</td>');
						tbody.push('<td>'+list.itemPrice+'</td>');
						tbody.push('<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>');
						tbody.push('<td><button type="button" id="itemAddBtn">담기</button></td>');
						tbody.push('</tr>');
						tbody.push('</form>');
					})
					$('#tbody').empty().html(tbody.join(''));
				}
				, error:function(request, status, error){
					alert('실패');
				}
			});
		});
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
									<th>구분</th>
									<th>품목명</th>
									<th>용량(g/ml)</th>
									<th>가격(원)</th>
									<th>수량</th>
									<th>담기</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach var="branchOrderList" items="${branchOrderList}">
									<tr>
										<td scope="row">${branchOrderList.itemCateName}</td>
										<td>${branchOrderList.itemName}</td>
										<td>${branchOrderList.itemSize}</td>
										<td>${branchOrderList.itemPrice}</td>
										<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>	
										<td><button type="button" id="itemAddBtn">담기</button></td>
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

						<table class="table table-striped">
							<thead>
								<tr>
									<th>구분</th>
									<th>품목명</th>
									<th>용량(g/ml)</th>
									<th>가격(원)</th>
									<th>수량</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>								
								<tr>
									<td scope="row"></td>
									<td></td>
									<td></td>
									<td></td>
									<td><input type="number" id="numberUpDown" name="numberUpDown" style="text-align:center; width:45px;" min="0" value="0"></td>	
									<td><button type="button" id="itemAddBtn">삭제</button></td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</div>
