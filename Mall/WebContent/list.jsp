<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 리스트</title>
    <style>
    	
    
    	#menu b{
    		font-size: 15px;
    	}
    	#cost {    	
    		text-decoration: line-through;
    		font-size: 12px;
    	}
    	#rate{
    		font-size : 10px;
    		color: red;
    	}

    </style>
    
     <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script>
	    // 문서 객체 추가 함수
	    var appendDocument = function () {
	        for (var i = 1; i <= 10; i++) {
	            // 요소를 생성하여 삽입
	            $('<div><a href="<c:url value = "/productsList.jsp"/>"><img src="image/Top/ST/ST000' + i + '.jpg" border="0" onmouseover= "this.src = "image/Top/ST/ST000'+ i +'_on.jpg"" onmouseout="this.src = "image/Top/ST/ST000'+ i +'.jpg""/></a></div>').appendTo('#contents');
	        }
	    };
    
        // 문서가 로드되면 호출. $(document).ready(function(){});과 동일    
        $(function () {
            // 최초 문서 객체들을 추가
            appendDocument();
            // 스크롤 이벤트를 처리할 핸들러 등록
            $(window).scroll(function () {
                var scrollHeight = $(window).scrollTop() + $(window).height();
                var documentHeight = $(document).height();
                // 문서 아래까지 스크롤되면 문서 객체 추가
                if (scrollHeight == documentHeight) {
                    appendDocument();
                }
            });
        });
    </script>
</head>
<body>
    <div class="tableContainer">
        <div class="tableRow">
            <!-- START of main content-->
            
            	<div id="contents">
                
                <table id = "mainTop-Bar">
                	<tr>
						<td><c:import url="mainTop-Bar.jsp"/></td>
					</tr>
				</table>
				<div id = "table1">		
                <table>
					<tr>
						<td>
							<a href="<c:url value = "productsList.jsp"/>">
							<img src="images/Top/ST/ST0001.jpg" border="0" onmouseover= "this.src = 'image/Top/ST/ST0001_on.jpg'" onmouseout="this.src = 'image/Top/ST/ST0001.jpg'"/></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="<c:url value = "/productsList.jsp"/>">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="<c:url value = "/productsList.jsp"/>">
							<img src="images/Top/ST/ST0002.jpg" border="0" onmouseover= "this.src = 'image/Top/ST/ST0002_on.jpg'" onmouseout="this.src = 'image/Top/ST/ST0002.jpg'"/></a>
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0003.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0004.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<br><br>
				    <table>					
					<tr>
						<td>
							<a href="#"><img src="images/Top/ST/ST0005.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0006.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0007.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0008.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<br><br>
				                <table>					
					<tr>
						<td>
							<a href="#"><img src="images/Top/ST/ST0009.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/ST/ST0010.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/NT/NT0001.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
						
						<td>
							<a href="#"><img src="images/Top/NT/NT0002.jpg" /></a>	
							<div id="menu">
								<p><a href="">장바구니담기</a> | <a href="">미리보기</a></p>
								<a href="">3+1/맥블랙신상입고 2XL~4XL 오버사이즈 맨투맨/후드</a>
								<table>
									<tr>
									<td><b>26,900원</b></td>
									<td id = "cost">31,900원</td>
									<td id = "rate">↓40%</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<br><br>
				</div>
            </div>
            <!-- END of main content-->
        </div>
        
         <div class="tableRow">
            <div class="tableCell">
                <c:import url="/WEB-INF/incl/copyright.jsp" />
            </div>
        </div>
           
</body>
</html>