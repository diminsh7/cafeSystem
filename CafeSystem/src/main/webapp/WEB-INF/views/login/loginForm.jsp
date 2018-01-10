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
						alert('パスワードを入力して下さい。');
						$('input[name="pw"]').focus();
						return false;
					}
				}else{
					alert('IDを入力して下さい。');
					$('input[name="id"]').focus();
					return false;
				}
			}else{
				alert('本社、または支店を選択して下さい');
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
					<small>
						自動的に入力されているIDは支店のアカウントですが <br/>
						ポートフォリオのため本社の機能まで使えるようになっています。<br/><br/>
					</small>
					<div>
						<div>
							<div id="division" class="btn-group" data-toggle="buttons">
								<label class="btn btn-default" data-toggle-class="btn-primary"
									data-toggle-passive-class="btn-default">
									<input type="radio" name="division" id="headDiv" value="head"> &nbsp; 本社
									&nbsp;
								</label>
								<label class="btn btn-default" data-toggle-class="btn-primary"
									data-toggle-passive-class="btn-default">
									<input type="radio" name="division" id="branchDiv" value="branch"> &nbsp; 支店
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
						<button type="button" class="btn btn-primary" id="loginButton" >ログイン</button>
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
