<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript">
	$(document).ready(function(){
		$("#branchDiv").prop("checked", true);
		$('#loginButton').click(function(){
			var lenDiv = $('input[name="division"]:checked').length;
			var lenId = $('input[name="id"]').val().length;
			var lenPw = $('input[name="pw"]').val().length;
			if(lenDiv > 0){
				if(lenId > 0) {
					if(lenPw > 0) {
						$('#login').submit();
					}else{
						alert('비밀번호를 입력하세요.');
						$('input[name="pw"]').focus();
						return false;
					}
				}else{
					alert('아이디를 입력하세요.');
					$('input[name="id"]').focus();
					return false;
				}
			}else{
				alert('본사 혹은 지점을 선택하세요.');
				$('input[name="division"]').eq(0).focus();
				return false;
			}
		});
	});
</script>

<div class="right_col" role="main">
	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				<form id="login" action="${pageContext.request.contextPath}/login" method="post" >
					<h1>Login</h1>
					<div>
						<div>
							<div id="division" class="btn-group" data-toggle="buttons">
								<label class="btn btn-default" data-toggle-class="btn-primary"
									data-toggle-passive-class="btn-default">
									<input type="radio" name="division" id="headDiv" value="head"> &nbsp; 본사
									&nbsp;
								</label>
								<label class="btn btn-default" data-toggle-class="btn-primary"
									data-toggle-passive-class="btn-default">
									<input type="radio" name="division" id="branchDiv" value="branch"> &nbsp; 지점
									&nbsp;
								</label>
							</div>
						</div>
					</div>
					<br/>
					<div>
						<input type="text" name="id" class="form-control" placeholder="ID" value="worud"/>
					</div>
					<div>
						<input type="password" name="pw" class="form-control"
							placeholder="Password" value="980328"/>
					</div>
					<div>
						<button type="button" class="btn btn-primary" id="loginButton" >log in</button>
					</div>

					<div class="clearfix"></div>

					<div class="separator">
						<div class="clearfix"></div>
						<br />
						<div>
							<h1>
								<i class="fa fa-coffee"></i> Bean Place
							</h1>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>
</div>
