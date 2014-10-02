<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>

  <link rel="stylesheet" type="text/css" href="http://w2ui.com/src/w2ui-1.4.1.min.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://w2ui.com/src/w2ui-1.4.1.min.js"></script>
     <link rel="stylesheet" href="css/huim.css">
	<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
	
	
	
	
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
	    
	    

	   
	    function fsubmit() {
	        // 문제) 아이디, 패스워드, 이름이 채워지지 않은 경우는 submit 차단
	        if(document.registform.customerID.value == "" || document.registform.password.value == ""
	                || document.registform.name.value == "") {
	            alert("아이디, 패스워드, 이름은 필수 항목입니다.");
	            return false;
	        }
	        if(!document.registform.agree.checked  ){
	            alert("회원약관에 동의해 주시기 바랍니다.");	            
	            return false;   // scubmit 진행 차단   
	        }
	        else {
	          return true;  // 정상적인 submit 진행       
	        }        
	    }
	</script>  
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
		  <tbody align="center">
		<tr>
	        <td> <form  id="registermember" name="registform" action="customer?action=register" method="POST" onsubmit="return fsubmit();">
	                <h2 class="head2">회원 가입</h2>
	               
	                    <table class="registertable">
	                        <tr>
	                            <td class="label">이름 :</td>
	                            <td><input type="text" name="name" size="20" maxlength="20" onkeyup="update()"></td>
	                        </tr>
	                        <tr>
	                            <td class="label">회원ID :</td>
	                            <td><input type="text"  name="customerID" size="20" maxlength="15" onkeyup="update()"></td>
	                        </tr>
	                        <tr>
	                            <td class="label">비밀번호 :</td>
	                            <td><input type="password"   name="password" size="20" maxlength="20" onkeyup="update()"></td>
	                        </tr>
	                        <tr>
	                            <td class="label">연락처 :</td>
	                            <td> <select name="tel1" id="number">
									<option selected="selected">010</option>
									<option>02</option>
									<option>031</option>
									<option>032</option>
									<option>033</option>
									<option>041</option>
									<option>042</option>
									<option>043</option>
									<option>044</option>
									<option>051</option>
									<option>052</option>
									<option>053</option>
									<option>054</option>
									<option>055</option>
									<option>061</option>
									<option>062</option>
									<option>063</option>
									<option>064</option>	
									</select>
	                            -<input type="text" name="tel2" size="4" maxlength="4" onkeyup="update()">-<input type="text" name="tel3" size="4" maxlength="4" onkeyup="update()"></td>
	                        </tr>
	                        <tr>
	                            <td class="label">이메일 :</td>
	                            <td><input type="email" name="email" size="30" maxlength="60" onkeyup="update()"></td>
	                        </tr>
	                        <tr>
	                            <td class="label">우편 번호 :</td>
	                            <td><input type="text" id="post1"  name="zipcode1"  size="3"  onkeyup="update()"> - <input type="text" id="post2" name="zipcode2"  size="3" onkeyup="update()">
								<input type="button" onclick="openDaumPostcode()" value="우편번호 찾기"></td>
								                       
	                        </tr>
	                        <tr>
	                            <td class="label">주소 :</td>
	                            <td><input type="text"   id="addr" name="address1" size="50" maxlength="70" onkeyup="update()"></td>
	                        </tr>
	                       <tr>
	                       		<td></td>
	                            <td><input type="text"  id="addr2" name="address2" size="50" maxlength="70" onkeyup="update()"></td>
	                        </tr>
	                       
	                        <tr>
	                            <td colspan="100">
	                        </tr>
	                    </table>
							<h3>회원 약관</h3>
						<table class="readme">
							<tr>
								<td class="textArea"><textarea name="readoc1"  style="width: 500px; height: 80px; resize: none">
	
제 1 장 총칙

제1조(목적)

이 약관은 Huim(이하 "회사")가 운영하는 HuimMall 사이트(이하 "사이트"라 한다)를 이용함에 있어 회사와 이용자의 권리. 의무, 책임사항 및 기타 필요한 사항을 규정함을 목적으로 합니다.


제 2 조 (약관의 효력과 변경)

1. 귀하가 본 약관 내용에 동의하는 경우, 사이트의 서비스 제공 행위 및 귀하의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다.

2. 사이트는 본 약관을 사전 고지 없이 변경할 수 있고, 변경된 약관은 사이트 내에 공지하거나 e-mail을 통해 회원에게 공지하며, 공지와 동시에 그 효력이 발생됩니다. 이용자가 변경된 약관에 동의하지 않는 경우, 이용자는 본인의 회원등록을 취소(회원탈퇴)할 수 있으며 계속 사용의 경우는 약관 변경에 대한 동의로 간주됩니다.
	                      
	                       		</textarea></td>
							</tr>
							<tr>
							<td><input type="checkbox"  name="agree" value="yes">위 약관에 동의합니다.</td>
							</tr>
							<tr>
								<td><input type="submit" value="가입 신청" >
								 <input type="reset" value="취소"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</tbody>	    
	          
	            <!-- END of main content-->
	  
		
			<tfoot  class="tfoot" align="center">
				<tr>
	                <td><c:import url="/WEB-INF/incl/copyright.jsp" /></td>
	            </tr>
			</tfoot>
	    </table>
	</div>

	
         
           
</body>
</html>