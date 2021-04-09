<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Dictionary</title>
   </head>

   <body>
      <h2>Введите слово</h2>
      <form:form method = "POST" action = "/addword">
         <table>
            <tr>
               <td><form:label path = "key_word">Слово</form:label></td>
               <td><form:input path = "key_word" /></td>
            </tr>
            <tr>
               <td><form:label path = "value_word">Значение</form:label></td>
               <td><form:input path = "value_word" /></td>
            </tr>
            <tr>
               <td><form:label path = "dictionary">Значение</form:label></td>
               <td><form:input path = "dictionary" /></td>
               </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>