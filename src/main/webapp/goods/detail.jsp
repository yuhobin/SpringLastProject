<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="4">
						<img src="${vo.goods_poster }" style="width: 290px; height: 330px">
					</td>
					<td colspan="2">
						<h3 style="color: blue;">${vo.goods_name }&nbsp;<span style="color:orange;">${vo.goods_discount }</span></h3>
					</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">가격</td>
					<td width="55%">${vo.goods_price }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">초기가격</td>
					<td width="55%">${vo.goods_first_price }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">배송</td>
					<td width="55%">${vo.goods_delivery }</td>
				</tr>
				<tr>
					<td colspan="3">${vo.goods_sub }</td>
				</tr>
				<tr>
					<td colspan="3" class="text-right">
						<a href="../goods/goods.do" class="btn btn-sm btn-danger">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>