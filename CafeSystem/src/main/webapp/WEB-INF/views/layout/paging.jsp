<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
		$('document').ready(function(){
			//이전 다음 버튼 눌렀을시 검색조건 그대로 유지하며 리스트 
			$('.paging').click(function(){
				var url = $(location).attr('pathname')+$(this).attr('href')
				var str = '&cate='+$('#cate').val()+'&input='+$('#input').val()
				$(this).attr('href', url+str)
			})			
		})
</script>
	<ul class="pager">
	    <c:if test="${currentPage > 1}">
	        <li class="previous"><a class="paging btn-default btn-sm" href="?currentPage=${currentPage-1}">이전</a></li>
	    </c:if>
    	<c:forEach var="page" begin="${startPage}" end="${endPage}" step="1">
			<c:choose>
				<c:when test="${page == currentPage}">
					<li class="active"><a>${page}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="?currentPage=${page}">${page}</a></li>
				</c:otherwise>	
			</c:choose>	
		</c:forEach>
	    <c:if test="${currentPage < lastPage}">
	        <li class="next"><a class="paging btn-default btn-sm" href="?currentPage=${currentPage+1}">다음</a></li>
	    </c:if>
	</ul>