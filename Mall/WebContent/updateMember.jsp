<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mall.domain.Customer"  %>
<%@ page import="java.util.*"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css"
	href="http://w2ui.com/src/w2ui-1.4.1.min.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="http://w2ui.com/src/w2ui-1.4.1.min.js"></script>
<link rel="stylesheet" href="css/huim.css">
<script>
	    function openDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	                // 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
	                document.getElementById('post1').value = data.postcode1;
	                document.getElementById('post2').value = data.postcode2;
	                document.getElementById('addr').value = data.address;
	
	                //전체 주소에서 연결 번지 및 ()로 묶여 있는 부가정보를 제거하고자 할 경우,
	                //아래와 같은 정규식을 사용해도 된다. 정규식은 개발자의 목적에 맞게 수정해서 사용 가능하다.
	                //var addr = data.address.replace(/(\s|^)\(.+\)$|\S+~\S+/g, '');
	                //document.getElementById('addr').value = addr;
	
	                document.getElementById('addr2').focus();
	            }
	        }).open();
	    }
</script>

<%
	String customerID = ((Customer) session.getAttribute("loginCustomer")).getCustomerID();
      
      // 세션을 통해 HTML 폼 데이터를 얻어낸다.
      String tel = ((Customer) session.getAttribute("loginCustomer")).getTel();
      String address = ((Customer) session.getAttribute("loginCustomer")).getAddress();
      
      System.out.println(tel);
      System.out.println(address);
      StringTokenizer telTokenizer = new StringTokenizer(tel, "|");
      StringTokenizer addrTokenizer = new StringTokenizer(address,"|");      
      String name = ((Customer) session.getAttribute("loginCustomer")).getName();    
      String grade = ((Customer) session.getAttribute("loginCustomer")).getGrade();   
      String password = ((Customer) session.getAttribute("loginCustomer")).getPassword();
      String tel1 = telTokenizer.nextToken();
      String tel2 = telTokenizer.nextToken();
      String tel3 = telTokenizer.nextToken();
      String email = ((Customer) session.getAttribute("loginCustomer")).getEmail();
      String zipcode1 = addrTokenizer.nextToken();
      String zipcode2 = addrTokenizer.nextToken();
      String address1 = addrTokenizer.nextToken();
      String address2 = addrTokenizer.nextToken();
      
      %>

</head>
<body>
	<div class="index" align="center">
		<table>
			<thead class="thead" align="center">
				<tr class="top">
					<td colspan="2"><a href="index.jsp"><img id="headerLogo" src="images/logo.png"
						alt="휴이엠 로고"></a></td>
				</tr>
				<tr>
					<td colspan="2" class="category"><c:import url="/category.jsp" /></td>
				</tr>
			</thead>
			<tbody align="center">
				<tr>
					<td>
						<form id="updatemember" name="updateform"
							action="customer?action=update" method="POST">
							<h1>==========회원 정보 수정==========</h1>
							<table class="registertable">
								<tr>
									<td class="label">회원ID :</td>
									<td><%= customerID %></td>
								</tr>
								<tr>
									<td class="label">회원등급 :</td>
									<td><%= grade %></td>
								</tr>
								<tr>
									<td class="label">비밀번호 :</td>
									<td><input type="password" name="password" size="20"
										maxlength="20" value="<%= password %>"></td>
								</tr>
								<tr>
									<td class="label">이름 :</td>
									<td><input type="text" name="name" size="20"
										maxlength="20" value="<%= name %>"></td>
								</tr>
								<tr>
									<td class="label">이메일 :</td>
									<td><input type="text" name="email" size="30"
										maxlength="60" value="<%= email %>"></td>
								</tr>
								<tr>
									<td class="label">전화번호 :</td>
									<td><input type="text" name="tel1" size="3" maxlength="3"
										value="<%= tel1 %>">-<input type="text" name="tel2" size="4" maxlength="4"
										value="<%= tel2 %>">-<input type="text" name="tel3" size="4" maxlength="4"
										value="<%= tel3 %>"></td>
								</tr>
								<tr>
									<td class="label">우편번호 :</td>
									<td><input type="text" name="zipcode1" size="3"
										maxlength="7" value="<%= zipcode1 %>">-<input type="text" name="zipcode2" size="3"
										maxlength="7" value="<%= zipcode2 %>">  <input type="button" onclick="openDaumPostcode()" value="우편번호 찾기"></td>
								</tr>
								<tr>
									<td class="label">주소 :</td>
										<td><input type="text" name="address1" size="50"
										maxlength="50" value="<%= address1 %>"></td>
								</tr>
								<tr>	
										<td></td>
										<td><input type="text" name="address2" size="50"
										maxlength="50" value="<%= address2 %>"></td>
									
								</tr>
								<tr>
									<td colspan="2">
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="정보수정"> <input
										type="reset" value="취소"></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</tbody>
			<!-- END of main content-->
			<tfoot class="tfoot" align="center">
				<tr>
					<td><c:import url="/WEB-INF/incl/copyright.jsp" /></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>