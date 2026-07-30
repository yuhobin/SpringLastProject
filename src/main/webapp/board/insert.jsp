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
	width: 800px;	
}
h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>글쓰기</h3>
			<table class="table">
				<tr>
					<th width="15%" class="text-center success">이름</th>
					<td width="85%">
						<input type="text" name="name" size="20" class="input-sm">
					</td> 
				</tr>
				<tr>
					<th width="15%" class="text-center success">제목</th>
					<td width="85%">
						<input type="text" name="subject" size="60" class="input-sm">
					</td> 
				</tr>
				<tr>
					<th width="15%" class="text-center success">내용</th>
					<td width="85%">
						<textarea rows="10" cols="62" name="content"></textarea>
					</td> 
				</tr>
				<tr>
					<th width="15%" class="text-center success">비밀번호</th>
					<td width="85%">
						<input type="password" name="pwd" size="10" class="input-sm">
					</td> 
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<button class="btn-sm btn-danger" type="submit">글쓰기</button>
						<button class="btn-sm btn-info" type="button"
							onclick="javascript:history.back()"
						>취소</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>