<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		$('#claimInsertButton').click(function(){
			$('#claimInsertForm').submit();
		})
	})
</script>
<form id="claimInsertForm" action="${pageContext.request.contextPath}/claimInsert" method="post">
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>Claim Insert Form</h3>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Text areas<small>Sessions</small></h2>
							<div class="clearfix"></div>
						</div> 
						<div class="form-group"> <!-- 카테고리&제목 입력  -->
							<select class="col-md-1 col-sm-1 col-xs-12 form-control" name="claimCategoryCode">
								<option>1</option>
								<option>2</option>
							</select>
							<input type="text" placeholder="제목을 입력해주세요" class=" col-md-10 col-sm-10 col-xs-12 form-control" name="customerClaimTitle">
						</div>
						<div class="x_content">
							<div id="alerts"></div>
							<div class="btn-toolbar editor" data-role="editor-toolbar" data-target="#editor-one">
								<div class="btn-group">
									<a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="fa fa-font"></i><b class="caret"></b></a>
									<ul class="dropdown-menu">
									</ul>
								</div>
	
								<div class="btn-group">
									<a class="btn dropdown-toggle" data-toggle="dropdown"
										title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a data-edit="fontSize 5"><p style="font-size: 17px">Huge</p></a></li>
										<li><a data-edit="fontSize 3"><p style="font-size: 14px">Normal</p></a></li>
										<li><a data-edit="fontSize 1"><p style="font-size: 11px">Small</p></a></li>
									</ul>
								</div>
	
								<div class="btn-group">
									<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
									<a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
									<a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="fa fa-strikethrough"></i></a>
									<a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
								</div>
	
								<div class="btn-group">
									<a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="fa fa-list-ul"></i></a> 
									<a class="btn" data-edit="insertorderedlist" title="Number list"><i class="fa fa-list-ol"></i></a> 
									<a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="fa fa-dedent"></i></a>
									<a class="btn" data-edit="indent" title="Indent (Tab)"><i class="fa fa-indent"></i></a>
								</div>
	
								<div class="btn-group">
									<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
									<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
									<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
									<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
								</div>
	
								<div class="btn-group">
									<a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></a>
									<div class="dropdown-menu input-append">
										<input class="span2" placeholder="URL" type="text" data-edit="createLink" />
										<button class="btn" type="button">Add</button>
									</div>
									<a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="fa fa-cut"></i></a>
								</div>
	
								<div class="btn-group">
									<a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a> 
									<input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
								</div>
	
								<div class="btn-group">
									<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a> 
									<a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
								</div>
							</div>
							<div id="editor-one" class="editor-wrapper"></div>
							<textarea id="customerClaimContents" name="customerClaimContents" style="display:none;"></textarea>
							<br/>
							<button>취소</button>
							<button id="claimInsertButton">등록</button>
							<br />
	
							<div class="ln_solid"></div>
	
							<div class="form-group">
								<label class="control-label col-md-2 col-sm-2 col-xs-12">Comment</label>
								<div class="col-md-10 col-sm-10 col-xs-12">
									<textarea class="resizable_textarea form-control" name="headEmployeeAdmin" placeholder="담당자 입력"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>