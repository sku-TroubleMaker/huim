<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="http://w2ui.com/src/w2ui-1.4.1.min.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://w2ui.com/src/w2ui-1.4.1.min.js"></script>
    <link rel="stylesheet" href="css/huim.css">
    
    
</head>

    <%-- request scope 속성에 에러메시지가 있으면 출력한다. --%>
  
	
     <c:if test="${not empty requestScope.loginErrorMsg}">
	    <script>
	    	
	    	alert('${requestScope.loginErrorMsg}');	
			 
		</script>
	        
	    
    </c:if>

		
    <form action="customer?action=login" method="POST">
	
	<table id="logintable">
            <tr>
                <td class="label" valign="bottom">ID</td>
                <td valign="bottom"><input type="text" name="customerID" size="9"></td>
            </tr>
            <tr>
                <td class="label">PW</td>
                <td><input type="password" name="password" size="9"></td>
            </tr>
            <tr>
               
                <td id="registcustomer" valign="top" colspan="2"><a href="registerMember.jsp">회원가입 </a>|<input type="submit" name="login" value="로그인"> </td>
            </tr>
              
            
        </table> 
    </form>
