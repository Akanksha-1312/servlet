<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

.div1{
align-content: center;
}
.div1,h1{
color:Green;
}

</style>

</head>
<body>

<div id="div1">
	<h1>Output is </h1>
</div>
<%

out.print(session.getAttribute("list"));

%>

</body>
</html>