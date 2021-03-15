<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="mvc.Bean"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Skånetrafiken</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="#">Tomt...</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">

				<p class="lead">

					<%
					Bean bean = (Bean) request.getAttribute("bean");
					out.print("<ul class='list-unstyled'>");
					for (int i = 0; i < bean.getNames().size(); i++) {
						out.print("<li>");
						out.print(bean.getNames().get(i));
						out.print("</li>");
					}
					out.print("</ul>");
					%>
				</p>

			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="\bootstrap\vendor\jquery\jquery.min.js"></script>
	<script src="/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="/lib/startbootstrap-bare-gh-pages/vendor/jquery/jquery.slim.min.js"></script>
	<script
		src="/lib/startbootstrap-bare-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>