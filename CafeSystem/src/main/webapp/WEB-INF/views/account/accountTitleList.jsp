<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script type="text/javascript" >
/* 	$(document).ready( function(){
	    $("#accountTitleDeleteButton").click( function() {
	        if(confirm("종료 하시겠습니까?")) {
	            $(this).parent().click();
	        } else {
	            return false;
	        }
	    });
	}); */
	$(document).ready(function button_event(){
		if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		    document.$('#accountTitleDeleteButton').submit();
		}else{   //취소
		    return false;
		}
	});
</script>
  <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>계정과목관리</h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>계정과목 리스트</h2>      
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                     <h2>게시글 목록</h2>
                   	</p>
		    <form name="form1" method="post" action="${pageContext.request.contextPath}/accountTitleList">
		        <select name="searchOption">
		            <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
		            <option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >계정과목명+내용</option>
		            <option value="account_title_name" <c:out value="${map.searchOption == 'account_title_name'?'selected':''}"/> >계정과목명</option>
		            <option value="account_title_content" <c:out value="${map.searchOption == 'account_title_content'?'selected':''}"/> >내용</option>
		        </select>
		        <input name="keyword" value="${map.keyword}">
		        <input type="submit" value="조회">
		        <button type="button" id="btnWrite">글쓰기</button>
		    </form>
		    <!-- 레코드의 갯수를 출력 -->
		    ${map.count}개의 게시물이 있습니다.
		     <table id="datatable" class="table table-striped table-bordered">
		        <tr>
		            <th>계정과목코드</th>
                          <th>계정과목명</th>
                          <th>상세내용</th>
                          <th>수정</th>
                          <th>삭제</th>
		        </tr>
		        <c:forEach var="map" items="${map.list}">
		        <tr>
		            <td>${map.accountTitleCode}</td>
		            <td>${map.accountTitleName}</td>
		            <td>${map.accountTitleContent}</td>
		            <td><a id="accountTitleUpdateButton" href ="${pageContext.request.contextPath}/accountTitleUpdateForm?accountTitleCode=${accountTitle.accountTitleCode}">수정</a></td>
                    <td><a  onclick="button_event()" id="accountTitleDeleteButton" href ="${pageContext.request.contextPath}/accountTitleDelete?accountTitleCode=${accountTitle.accountTitleCode}">삭제</a></td>
		       </tr>    
		        </c:forEach>
		        </table>
                   	<div>전체 수: ${totalRowCount}</div>
                   
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>계정과목코드</th>
                          <th>계정과목명</th>
                          <th>상세내용</th>
                          <th>수정</th>
                          <th>삭제</th>
                        </tr>
                      </thead><!--branchManagerList  -->
                      <tbody >
                      <c:forEach var="accountTitle" items="${accountlist}">
                     	<tr>
                          <td>${accountTitle.accountTitleCode}</td>
                          <td>${accountTitle.accountTitleName}</td>
                          <td>${accountTitle.accountTitleContent}</td>
                          <td><a id="accountTitleUpdateButton" href ="${pageContext.request.contextPath}/accountTitleUpdateForm?accountTitleCode=${accountTitle.accountTitleCode}">수정</a></td>
                          <td><a onclick="button_event();" id="accountTitleDeleteButton" href ="${pageContext.request.contextPath}/accountTitleDelete?accountTitleCode=${accountTitle.accountTitleCode}">삭제</a></td>
                        </tr>
                      </c:forEach>                                                        
                      </tbody>
                    </table>
	                    <ul class="pager">
	                    	<if test="${currentPage>1}">
	                    		<li class="previous"><a href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage-1}">이전</a></li>
	                    	</if>
	                    	<if test="${currentPage>lastPage}">
	                    		<li class="next"><a href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage+1}">다음</a></li>
	                    	</if>          	
	                    </ul>
                    <div>
                    	<a href="${pageContext.request.contextPath}/accountTitleInsert">계정과목 입력</a>
                    </div> 
                  </div>
                </div>
              </div>
             </div>
            </div>
           </div>
           