<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
      <title>Dictionary</title>
   </head>

   <body>
      <h2>${label}</h2>
      <a href="/addword">Добавить значение</a>
      <br/>
      <a href="/deleteWord">Удалить значение</a>
            <table>
             <th>Слово</th><th>Значение</th>
             <c:forEach var="rows" items="${resultSet}">
             <tr><td>${rows.key_word}</td><td>${rows.value_word}</td></tr> </c:forEach>
            </table>
   </body>
</html>