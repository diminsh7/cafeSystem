<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function boardBtn(btn){
		if(btn == "list"){
			//console.log("rollback Board List");
			$(location).attr('href', '${pageContext.request.contextPath}/boardList');
		} 
		if(btn == "update"){
			$(location).attr('href', '${pageContext.request.contextPath}/boardUpdate?boardCode=${board.boardCode}');
		}
		if(btn == "delete"){
			result = confirm('정말 삭제하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/boardDelete?boardCode=${board.boardCode}');
			}		
		}
	}
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h3>
						통합 게시판
					</h3>
					<div class="clearfix"></div>
				</div>
                  <h5><a id="boardCategoryCode" name="categoryCode" readonly >&nbsp;${board.categorySmall}</a><small>&nbsp;&nbsp;카테고리</small></h5><br/>
					
					<div class="col-md-10 col-sm-10 col-xs-10">					
						<h4><span style="color: navy;">Title</span>　 <a class="font-gray-dark" id="boardTitle"  name="boardTitle" value="" readonly>${board.boardTitle}</a></h4>
					</div>
					<div class="col-md-2 col-sm-5 col-xs-3">	
							<h5>작성자: <a id="employeeCode" name="employeeCode" readonly>${board.employeeCode}</a></h5>
					</div><br/>
				<div class="docs-data">
					<div class="ln_solid"></div>
					<div class="x_content">
						<div id="alerts"></div>
						<div class="btn-toolbar editor" data-role="editor-toolbar" data-target="#editor-one">
							<div class="btn-group" >
								<a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn">
									<i class="fa fa-picture-o"></i>
								</a> 
								<input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" 
									value="${board.boardFile}" name="boardFile" readonly/>
							</div>
						</div>
						<textarea name="boardContent" rows="8" class="resizable_textarea form-control" readonly>${board.boardContent}</textarea>
						<br />
						<div class="col-md-6 col-md-offset-5">
							<input type="button" class="btn btn-primary" value="목록" onclick="boardBtn('list')" name="list">
							<input type="button" class="btn btn-success" value="수정" onclick="boardBtn('update')" name="update">
							<input type="button" class="btn btn-primary" value="삭제" onclick="boardBtn('delete')" name="delete">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
