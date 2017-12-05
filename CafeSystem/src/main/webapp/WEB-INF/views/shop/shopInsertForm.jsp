<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	// 점포주소 및 점포우편번호
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('shopPostcode').value = data.zonecode; // 5자리 새우편번호 사용
						document.getElementById('shopAddress').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다. // 상세주소입력란이 없어 점포 주소란에 추가로 상세주소 입력
						document.getElementById('shopAddress').focus();
					}
				}).open();
	}
	
	// 점포연락처 번호 자르기
	function OnCheckPhone(oTa) {
		var oForm = oTa.form;
		var sMsg = oTa.value;
		var onlynum = "";
		var imsi = 0;
		onlynum = RemoveDash2(sMsg); // 하이픈 입력시 자동으로 삭제함 
		onlynum = checkDigit(onlynum); // 숫자만 입력받게 함 
		var retValue = "";

		if (event.keyCode != 12) {
			if (onlynum.substring(0, 2) == 02) { // 서울전화번호일 경우  10자리까지만 나타나교 그 이상의 자리수는 자동삭제 
				if (GetMsgLen(onlynum) <= 1)
					oTa.value = onlynum;
				if (GetMsgLen(onlynum) == 2)
					oTa.value = onlynum + "-";
				if (GetMsgLen(onlynum) == 4)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 3);
				if (GetMsgLen(onlynum) == 4)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 4);
				if (GetMsgLen(onlynum) == 5)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 5);
				if (GetMsgLen(onlynum) == 6)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 6);
				if (GetMsgLen(onlynum) == 7)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 5) + "-"
							+ onlynum.substring(5, 7);
				;
				if (GetMsgLen(onlynum) == 8)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 6) + "-"
							+ onlynum.substring(6, 8);
				if (GetMsgLen(onlynum) == 9)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 5) + "-"
							+ onlynum.substring(5, 9);
				if (GetMsgLen(onlynum) == 10)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 6) + "-"
							+ onlynum.substring(6, 10);
				if (GetMsgLen(onlynum) == 11)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 6) + "-"
							+ onlynum.substring(6, 10);
				if (GetMsgLen(onlynum) == 12)
					oTa.value = onlynum.substring(0, 2) + "-"
							+ onlynum.substring(2, 6) + "-"
							+ onlynum.substring(6, 10);
			}
			if (onlynum.substring(0, 2) == 05) { // 05로 시작되는 번호 체크 
				if (onlynum.substring(2, 3) == 0) { // 050으로 시작되는지 따지기 위한 조건문 
					if (GetMsgLen(onlynum) <= 3)
						oTa.value = onlynum;
					if (GetMsgLen(onlynum) == 4)
						oTa.value = onlynum + "-";
					if (GetMsgLen(onlynum) == 5)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 5);
					if (GetMsgLen(onlynum) == 6)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 6);
					if (GetMsgLen(onlynum) == 7)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 7);
					if (GetMsgLen(onlynum) == 8)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 8);
					if (GetMsgLen(onlynum) == 9)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 7) + "-"
								+ onlynum.substring(7, 9);
					;
					if (GetMsgLen(onlynum) == 10)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 8) + "-"
								+ onlynum.substring(8, 10);
					if (GetMsgLen(onlynum) == 11)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 7) + "-"
								+ onlynum.substring(7, 11);
					if (GetMsgLen(onlynum) == 12)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 8) + "-"
								+ onlynum.substring(8, 12);
					if (GetMsgLen(onlynum) == 13)
						oTa.value = onlynum.substring(0, 4) + "-"
								+ onlynum.substring(4, 8) + "-"
								+ onlynum.substring(8, 12);
				} else {
					if (GetMsgLen(onlynum) <= 2)
						oTa.value = onlynum;
					if (GetMsgLen(onlynum) == 3)
						oTa.value = onlynum + "-";
					if (GetMsgLen(onlynum) == 4)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 4);
					if (GetMsgLen(onlynum) == 5)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 5);
					if (GetMsgLen(onlynum) == 6)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 6);
					if (GetMsgLen(onlynum) == 7)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 7);
					if (GetMsgLen(onlynum) == 8)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 6) + "-"
								+ onlynum.substring(6, 8);
					;
					if (GetMsgLen(onlynum) == 9)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 7) + "-"
								+ onlynum.substring(7, 9);
					if (GetMsgLen(onlynum) == 10)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 6) + "-"
								+ onlynum.substring(6, 10);
					if (GetMsgLen(onlynum) == 11)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 7) + "-"
								+ onlynum.substring(7, 11);
					if (GetMsgLen(onlynum) == 12)
						oTa.value = onlynum.substring(0, 3) + "-"
								+ onlynum.substring(3, 7) + "-"
								+ onlynum.substring(7, 11);
				}
			}
			if (onlynum.substring(0, 2) == 03 || onlynum.substring(0, 2) == 04
					|| onlynum.substring(0, 2) == 06
					|| onlynum.substring(0, 2) == 07
					|| onlynum.substring(0, 2) == 08) { // 서울전화번호가 아닌 번호일 경우(070,080포함 // 050번호가 문제군요) 
				if (GetMsgLen(onlynum) <= 2)
					oTa.value = onlynum;
				if (GetMsgLen(onlynum) == 3)
					oTa.value = onlynum + "-";
				if (GetMsgLen(onlynum) == 4)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 4);
				if (GetMsgLen(onlynum) == 5)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 5);
				if (GetMsgLen(onlynum) == 6)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 6);
				if (GetMsgLen(onlynum) == 7)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7);
				if (GetMsgLen(onlynum) == 8)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 6) + "-"
							+ onlynum.substring(6, 8);
				;
				if (GetMsgLen(onlynum) == 9)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 9);
				if (GetMsgLen(onlynum) == 10)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 6) + "-"
							+ onlynum.substring(6, 10);
				if (GetMsgLen(onlynum) == 11)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 11);
				if (GetMsgLen(onlynum) == 12)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 11);
			}
			if (onlynum.substring(0, 2) == 01) { // 휴대폰일 경우 
				if (GetMsgLen(onlynum) <= 2)
					oTa.value = onlynum;
				if (GetMsgLen(onlynum) == 3)
					oTa.value = onlynum + "-";
				if (GetMsgLen(onlynum) == 4)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 4);
				if (GetMsgLen(onlynum) == 5)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 5);
				if (GetMsgLen(onlynum) == 6)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 6);
				if (GetMsgLen(onlynum) == 7)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7);
				if (GetMsgLen(onlynum) == 8)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 8);
				if (GetMsgLen(onlynum) == 9)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 9);
				if (GetMsgLen(onlynum) == 10)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 6) + "-"
							+ onlynum.substring(6, 10);
				if (GetMsgLen(onlynum) == 11)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 11);
				if (GetMsgLen(onlynum) == 12)
					oTa.value = onlynum.substring(0, 3) + "-"
							+ onlynum.substring(3, 7) + "-"
							+ onlynum.substring(7, 11);
			}
			if (onlynum.substring(0, 1) == 1) { // 1588, 1688등의 번호일 경우 
				if (GetMsgLen(onlynum) <= 3)
					oTa.value = onlynum;
				if (GetMsgLen(onlynum) == 4)
					oTa.value = onlynum + "-";
				if (GetMsgLen(onlynum) == 5)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 5);
				if (GetMsgLen(onlynum) == 6)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 6);
				if (GetMsgLen(onlynum) == 7)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 7);
				if (GetMsgLen(onlynum) == 8)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 8);
				if (GetMsgLen(onlynum) == 9)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 8);
				if (GetMsgLen(onlynum) == 10)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 8);
				if (GetMsgLen(onlynum) == 11)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 8);
				if (GetMsgLen(onlynum) == 12)
					oTa.value = onlynum.substring(0, 4) + "-"
							+ onlynum.substring(4, 8);
			}
		}
	}
	// 하이픈 입력시 자동으로 삭제함
	function RemoveDash2(sNo) {
		var reNo = ""
		for (var i = 0; i < sNo.length; i++) {
			if (sNo.charAt(i) != "-") {
				reNo += sNo.charAt(i)
			}
		}
		return reNo
	}
	function GetMsgLen(sMsg) { // 0-127 1byte, 128~ 2byte 
		var count = 0
		for (var i = 0; i < sMsg.length; i++) {
			if (sMsg.charCodeAt(i) > 127) {
				count += 2
			} else {
				count++
			}
		}
		return count
	}
	// 숫자만 입력받게 함
	function checkDigit(num) {
		var Digit = "1234567890";
		var string = num;
		var len = string.length
		var retVal = "";

		for (i = 0; i < len; i++) {
			if (Digit.indexOf(string.substring(i, i + 1)) >= 0) {
				retVal = retVal + string.substring(i, i + 1);
			}
		}
		return retVal;
	}
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장기초정보관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장등록</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="shopInsertForm" action="${pageContext.request.contextPath}/insertShop" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">지역코드<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="localCategoryCode" name="localCategoryCode">
										<c:forEach var="ShopCategoryLocal" items="${CategoryLocalList}">
											<option value='${ShopCategoryLocal.categoryCode}'>${ShopCategoryLocal.categorySmall}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">계약코드<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="contractCode" name="contractCode">
										<c:forEach var="ShopContractCode" items="${ContractCodeList}">
											<option>${ShopContractCode.contractCode}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopName"
										class="form-control col-md-7 col-xs-12"
										name="shopName" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포주소<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopAddress"
										class="form-control col-md-7 col-xs-12"
										name="shopAddress" type="text">
									<input type="button" onclick="sample6_execDaumPostcode()" value="주소 및 우편번호"><br>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포연락처<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopCall"
										class="form-control col-md-7 col-xs-12"
										name="shopCall" type="text" onfocus="OnCheckPhone(this)" onKeyup="OnCheckPhone(this)">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포우편번호<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopPostcode"
										class="form-control col-md-7 col-xs-12"
										name="shopPostcode" type="text" placeholder="주소검색시 자동입력">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포규모<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopSize"
										class="form-control col-md-7 col-xs-12"
										name="shopSize" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/shopList">취소</a>
									<button id="send" type="submit" class="btn btn-success">등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
