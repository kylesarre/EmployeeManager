<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<sb:head/>
	<style>
	
		html, body {
		    margin: 0;
		    height: 100%;
		}
		
		.center{
		margin: auto;
    	width: 50%;
		}
		.container-fluid{
		 height:100%;
		 position: absolute;
		 display:table;
		 width: 100%;
		 padding: 0;
		}
		.row-fluid {
		display:table-cell; 
		vertical-align: middle;
		float: none;
		}
		.centering {
		 margin-left:auto;
		 margin-right:auto;
		 width: 100%;
		}
	</style>
	<sb:head/>
</head>

<body>
	<div class="container-fluid">	
		<div class="row-fluid">
			<div class="centeringr">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-primary">
						<div class="panel-heading text-center" id="footer">
							<h1>User Login</h1>
						</div>
						<div class="panel-body" id="body" class="center">
							
							<s:if test="hasActionErrors()">
							   <div class="errors">
							      <s:actionerror/>
							   </div>
							</s:if>			
							<s:form action="login" method="post" theme="bootstrap" cssClass="form-horizontal">		
								<s:textfield name="username" placeholder="Username"></s:textfield>
								<s:textfield type="password" name="password" placeholder="Password"></s:textfield>
								<s:submit cssClass="btn btn-primary" method="post" value="Login"></s:submit>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>