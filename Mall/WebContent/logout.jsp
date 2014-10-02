<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<head>
	    <title>login</title>
	    <link rel="stylesheet" type="text/css" href="http://w2ui.com/src/w2ui-1.4.1.min.css" />
	    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	    <script type="text/javascript" src="http://w2ui.com/src/w2ui-1.4.1.min.js"></script>
	    <link rel="stylesheet" href="css/huim.css">
	</head>
    
    <form action="<c:url value='/customer?action=logout'/>" method="POST">
        <table id="logouttable">
            <tr>
            	
                <td class="message" valign="bottom">${sessionScope.loginCustomer.name } 님<br> 환영합니다.</td>
            </tr>
            <tr>
            	
                <td class="message" >나의 등급 :${sessionScope.loginCustomer.grade }</td>
            </tr>
            <tr>
            	
                <td class="message"  valign="top" colspan="2"><a href="updateMember.jsp">내정보</a>|<input type="submit" name="logout" value="로그아웃"></td>
            </tr>
        </table>
    </form>
