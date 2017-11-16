<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="right_col" role="main">
	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				<form id="login" method="post">
					<h1>Login</h1>
					<div>
						<input type="text" name="id" class="form-control" placeholder="ID" />
					</div>
					<div>
						<input type="password" name="pw" class="form-control" placeholder="Password" />
					</div>
					<div>
						<a class="btn btn-primary" href="javascript:login.submit();">log in</a>
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
