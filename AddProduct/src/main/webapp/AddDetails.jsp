<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="org.hibernate.Session , com.main.ProductInfo , com.samples.utils.HibernateUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("pid"));
long cost=Integer.parseInt(request.getParameter("pcost"));
String name=request.getParameter("name");

Session session1 = HibernateUtil.getSessionFactory().openSession();
session1.beginTransaction();
ProductInfo obj= new ProductInfo( id,name,cost);

session1.save(obj);

session1.getTransaction().commit();

session1.close();

%>


</body>
</html>