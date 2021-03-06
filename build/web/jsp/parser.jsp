<%-- 
    Document   : parser
    Created on : 25.05.2014, 21:22:25
    Author     : Anna
--%>

<jsp:directive.page contentType="text/html; charset=UTF-8"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parser</title>
    </head>
    <body>
        <c:out value="${parser}"/>
        <hr />
        <table>
      <c:forEach var="medicine" items="${medicines}">
        <tr>
          <td>${medicine.id}</td>
          <td>${medicine.name}</td>
          <td>${medicine.company}</td>
          <td>${medicine.group}</td>
          <td>${medicine.consistence}</td>
          <td>${medicine.dosageId}</td>
          <td>${medicine.dosageFrequency}</td>
          <td>${medicine.dosageNumber}</td>
          <td>${medicine.isAfterFood}</td>
          <td>${medicine.packageId}</td>
          <td>${medicine.packageType}</td>
          <td>${medicine.packagePrice}</td>
          <td>${medicine.numberPerPackage}</td>
        </tr>
      </c:forEach>
    </table>
    </body>
</html>
