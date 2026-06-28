<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<form action="<%= request.getContextPath() %>/members" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>