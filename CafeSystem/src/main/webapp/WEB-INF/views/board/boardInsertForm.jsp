<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function boardBtn(btn){
		if(btn == 'list'){
			//console.log("rollback Claim List");
			result = confirm('작성을 취소하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/boardList');
			} else {
				
			}
		} 
		if(btn == 'insert'){
			//console.log("Claim Insert Action");
			result = confirm('등록하시겠습니까?');
			if(result){
				$('#boardInsertForm').submit();
			} else {
				
			}
		}
	}
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						통합 게시판
					</h2>
					<div class="clearfix"></div>
				</div>
				<form id="boardInsertForm" action="${pageContext.request.contextPath}/boardInsert" method="post">
					<div class="x_content">
						<div class="col-md-8 col-xs-8">
							<select name="categoryCode" class="btn btn-default dropdown-toggle">
								<option value="board1">공지사항</option>
								<option value="board2">뉴스</option>
								<option value="board3">본사소식</option>
								<option value="board4">이벤트</option>
								<option value="board5">기타</option>
								<option value="board6">인수인계(지점별)</option>
							</select>
							<!-- drop 버튼 시작-->
							<!-- <button data-toggle="dropdown"
								class="btn btn-default dropdown-toggle" type="button"
								aria-expanded="false"
								value="menu">
								카테고리 
								<span class="caret"></span>
							</button>
							
							<ul role="menu" class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
							drop 버튼 끝 -->
							<input type="text" id="fullname" class="form-control" name="boardTitle" required="">
						</div>
					</div>
					
					<div class="x_content">
						<div id="alerts"></div>
						<div class="btn-toolbar editor" data-role="editor-toolbar"
							data-target="#editor-one">
							<div class="btn-group">
								<a class="btn dropdown-toggle" data-toggle="dropdown"
									title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a data-edit="fontSize 5">
											<p style="font-size: 17px">Huge</p>
									</a></li>
									<li><a data-edit="fontSize 3">
											<p style="font-size: 14px">Normal</p>
									</a></li>
									<li><a data-edit="fontSize 1">
											<p style="font-size: 11px">Small</p>
									</a></li>
								</ul>
							</div>
	
							<div class="btn-group">
								<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)">
									<i class="fa fa-bold"></i>
								</a> 
								<a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)">
									<i class="fa fa-italic"></i>
								</a> 
								<a class="btn" data-edit="strikethrough" title="Strikethrough">
									<i class="fa fa-strikethrough"></i>
								</a> 
								<a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)">
									<i class="fa fa-underline"></i>
								</a>
							</div>
	
							<div class="btn-group">
								<a class="btn" data-edit="insertunorderedlist" title="Bullet list">
									<i class="fa fa-list-ul"></i>
								</a> 
								<a	class="btn" data-edit="insertorderedlist" title="Number list">
									<i class="fa fa-list-ol"></i>
								</a> 
								<a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)">
									<i class="fa fa-dedent"></i></a>
								<a class="btn" data-edit="indent" title="Indent (Tab)">
									<i class="fa fa-indent"></i></a>
							</div>
	
							<div class="btn-group">
								<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)">
									<i class="fa fa-align-left"></i>
								</a>
								<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)">
									<i class="fa fa-align-center"></i>
								</a>
								<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)">
									<i class="fa fa-align-right"></i>
								</a> 
								<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)">
									<i class="fa fa-align-justify"></i>
								</a>
							</div>
	
							<div class="btn-group">
								<a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink">
									<i class="fa fa-link"></i>
								</a>
								<div class="dropdown-menu input-append">
									<input class="span2" placeholder="URL" type="text" data-edit="createLink" name="link" />
									<button class="btn" type="button">Add</button>
								</div>
								<a class="btn" data-edit="unlink" title="Remove Hyperlink">
									<i class="fa fa-cut"></i>
								</a>
							</div>
	
							<div class="btn-group" >
								<a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn">
									<i class="fa fa-picture-o"></i>
								</a> 
								<input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" name="boardFile"/>
							</div>
	
							<div class="btn-group">
								<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)">
									<i class="fa fa-undo"></i>
								</a> 
								<a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)">
									<i class="fa fa-repeat"></i>
								</a>
							</div>
						</div>
						<textarea name="boardContent" rows="8" class="resizable_textarea form-control"></textarea>
						<br />
						<div class="col-md-6 col-md-offset-5">
							<input type="button" class="btn btn-primary" value="목록" onclick="boardBtn('list')" name="list">
							<input type="button" class="btn btn-success" value="등록" onclick="boardBtn('insert')" name="insert">
							<!-- <button type="submit" class="btn btn-primary">Cancel</button>
							<button id="send" type="submit" class="btn btn-success">Submit</button> -->
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



<%-- 	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>boardInsertForm</h3>
				</div>
			</div>
		</div> 
 		<div>
			<select id="claimCategoryCode" name="claimCategoryCode">
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.categoryCode}">${category.categorySmall}</option>
				</c:forEach>
			</select>
			<input type="text" id="customerClaimTitle" name="customerClaimTitle">
		</div>
		<div>
			<textarea id="customerClaimContents" name="customerClaimContents"></textarea>
		</div>
		<div>
			<input type="file" id="customerClaimFile" name="customerClaimFile">
		</div>
		<div>
			<input type="button" id="claimListBtn" value="목록" onclick="claimBtn('list')">
			<input type="button" id="claimInsertBtn" value="등록" onclick="claimBtn('insert')">
		</div> 
 --%>





