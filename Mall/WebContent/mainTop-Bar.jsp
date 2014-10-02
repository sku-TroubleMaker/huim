<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>메인 Top-Bar</title>
			<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	 		<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>	
			<script src="//code.jquery.com/jquery-1.10.2.js"></script>
			<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
			<link rel="stylesheet" href="/resources/demos/style.css">
	<script>
		$(function() {
			$("#speed").selectmenu();
		});
	</script>
	<script>
		$(function() {
			$('option').keyup(function() {
				jQuery.ajax({
					type: "GET",
					url: 'list.jsp', //요청 URL
					data: 'name=' + encodeURIComponent($(this).val()), //explorer에서의 encoding문제 해결
					dataType: 'text', //응답 body에 들어온 것이 무슨 유형인지
					success: function(text) { //200 OK인 상태에서 해야될 일 text는 localvariable이다.
						$('h1').html(text);
					}
				});
			});
		});
	</script>
	<style>
		table {
			text-align: 
		}
		
		label {
			display: block;
			margin: 30px 0 0 0;
		}
		
		select {
			width: 200px;
		}
		
		.overflow {
			height: 200px;
		}
	</style>

</head>
<body>
	<div class="demo">
		<form action="#">			
			<table>
				<tr>
					<td>
						<b>전체상품</b>  90,885<b>개</b>
					</td>
					<td>
						<select name="searchType" id="speed">
							<option selected="selected" id = "popularity">판매인기순</option>
							<option value = "ask">고객조회순</option>
							<option value = "registration">신규등록순</option>
							<option value = "highPrice">높은가격순</option>
							<option value = "rowPrice">낮은가격순</option>
						</select>
					</td>
					<td>
						<input type = "text" size = "30" name = "searchText" value = "상품명 검색"/>
					</td>
					<td>
						<input type="submit" name="search" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>