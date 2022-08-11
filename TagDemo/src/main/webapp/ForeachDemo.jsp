<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String cities[]= {"Mumbai","UP","Delhi"};
pageContext.setAttribute("mycity",cities);%>

<c:forEach var="city" items="${mycity}">
${city}<br>
</c:forEach>

</body>
</html>