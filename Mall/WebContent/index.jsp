<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
<head>
	<meta charset="UTF-8">
	<title>HUIM Store</title>
    <link rel="stylesheet" href="css/huim.css">
</head>
<body>
 <div class="index" align="center">
	<table>
		<thead class="thead" align="center">
			<tr class="top">
				<td colspan="2"><img id="headerLogo" src="images/logo.png" alt="휴이엠 로고"></td>	
			</tr>
			<tr>
				<td colspan="2" class="category"><c:import url ="/category.jsp" /></td>
			</tr>
		</thead>
	    
	    <tbody class="tbody" align="center">
			<tr>
				<td id = "banner"><c:import url="banner.jsp" /><br><br></td>
				<td valign="top" align = "left"><c:import url="sidebar.jsp" /></td>
			</tr>      
			
			<tr id = "centerList">
				<td><c:import url="list.jsp" /></td>
			</tr>  
	    </tbody>
		
		<tfoot  class="tfoot" align="center">
			<tr>
                <td><c:import url="/WEB-INF/incl/copyright.jsp" /></td>
            </tr>
		</tfoot>
    </table>
</div>
</body>
</html>
