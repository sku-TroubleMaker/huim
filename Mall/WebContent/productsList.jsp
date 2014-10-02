<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 상세 보기</title>
    <link rel="stylesheet" href="css/dukeshop.css">
    <style>
		img {
			width: 400px;
			height: 400px;
		}
    	#cost {
    		text-decoration: line-through;
    	}
    	#sellPrice{
    		font-size: 14px;
    	}
    
    </style>
</head>
<body topmargin="0" leftmargin="0">
   <header class="top">
			<img id="headerLogo" src="images/logo.png" alt="휴이엠 로고">
	</header>
            <!-- START of main content-->
    <div class="tableContainer">
        <div class="tableRow">
             <div  class="category">
                <c:import url ="/category.jsp" />
                </div>
            <!-- START of main content-->
            <div class="main">
       			 
                <h4>[상품 상세 정보]</h4>
				<table id = "productdetails">
                	<tr>
						<td><c:import url="/mainTop-Bar.jsp"/></td>
					</tr>
				</table>	
					
                <table>
					<tr>
						<td rowspan="9"><img src="image/Top/ST/ST0001.jpg" border = "0"></td>
					</tr>
					<tr>
						<td id="productNum">상품번호</td>
						<td>A925855476</td>
					</tr>
					<tr>
						<td colspan = "2">[고스트리퍼블릭] 고스트리퍼블릭 가을시즌 Hot 추천 아이템</td>
					</tr>
					<tr>
						<td>판매가</td>
						<td id = "sellPrice"><b>18,900원</b><p id = "cost">31,900원</p></td>
					</tr>
					<tr>
						<td>판매수량</td>
						<td>114개 (남은수량 35,986개)</td>
					</tr>
					<tr>
						<td>제조사</td>
						<td>한국 (서울 강북구)</td>
					</tr>
					<tr>
						<td>배송방법</td>
						<td>택배</td>
					</tr>
					<tr>
						<td>배송비</td>
						<td>무료</td>
					</tr>
					<tr>
                        <td colspan="2" id="details">
                            <table>
                                <tr>
                                    <td>제품설명</td>
                                </tr>
                                <tr>
                                    <td><textarea rows="4" cols="40">${requestScope.selectedProduct.detail}</textarea></td>
                                </tr>
                                <tr>
                                    <td id="purchase">
                                        <p>
                                            구매하시려면 주문갯수를 입력하시고<br>
                                            장바구니넣기 버튼을 눌러주세요
                                        </p>
                                        <form name="ProductDetail" action="product" method="GET">
                                            <input type="hidden" name="action" value="putOne-basket">
                                            <input type="hidden" name="productID" value="${requestScope.selectedProduct.productID}">
                                                주문갯수&nbsp;&nbsp;<input type="text" name="quantity" size="2" value="1"><br><br>
                                            <input type="submit" value="장바구니넣기">&nbsp;
                                            <input type="button" value="바로구매하기" onclick="location='product?action=select-all'">
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
				</table>	
			</div>
            <!-- END of main content-->
        </div>
        
            <div class="tableRow">
            <div class="tableCell"></div>
            <div class="tableCell">
                <c:import url="/WEB-INF/incl/copyright.jsp" />
            </div>
        </div>
    </div>   
</body>
</html>