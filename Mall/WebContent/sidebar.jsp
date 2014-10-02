<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>sidebar</title>
      <link rel="stylesheet" href="css/huim.css"> 
</head>
<body>

			<div>
			<table id="sidebar">
				<tr>
					<td id="login" background="images/sidebar.png" valign="top">
					<c:if test="${ empty sessionScope.loginCustomer}" >
						<c:import url="login.jsp" />
					</c:if>

					<c:if test="${not empty sessionScope.loginCustomer}">
						<c:import url="logout.jsp" />
					</c:if>
				</td>
			</tr>
			</table>
			</div>      

			<div id="review">
				 <img src="images/review.png" alt="최근 본 상품 ">
		    </div>

</body>
</html>