<%--
  Created by IntelliJ IDEA.
  User: Igor_Veremchuk
  Date: 3/13/13
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="java.util.List"
         import="model.Category"
         import="model.Amount"
        %>
<%@ taglib uri="/WEB-INF/tlds/SimpleTag.tld" prefix="ct" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<ct:Hello message="This is simple message" />

<h2>Payments List!</h2>
<% List <Category> categoryList = (List <Category>) request.getAttribute("categoryList"); %>
<% List <Amount> amountList = (List <Amount>) request.getAttribute("amountList"); %>


<table style="width: 400px;" border="1">
    <% for (Amount amount:amountList) { %>
    <tr>
        <td><%=amount.getCategory() %></td>
        <td><%=amount.getName() %></td>
        <td><%=amount.getAmount() %></td>
    </tr>

    <% } %>

</table>
<form method="post" action="">
    <select name="category">

        <% for (Category category:categoryList) { %>
        <option value="<%=category.getName() %>"><%=category.getName() %></option>
        <% } %>



    </select>
    Title: <input type="text" name="title" />
    Amount: <input type="text" name=amount />
    <input type="submit" value="Save" />
</form>

</body>
</html>