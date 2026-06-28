<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<form action="<%= request.getContextPath() %>/spring/members" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>