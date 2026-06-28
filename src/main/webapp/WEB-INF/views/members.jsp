<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<a href="${pageContext.request.contextPath}/members/new">회원 등록</a>

<table>
    <thead>
    <p>로그인 사용자: ${username}</p>
    <p>권한: ${authorities}</p>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <button type="submit">로그아웃</button>
    </form>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.id}</td>
            <td>${member.username}</td>
            <td>${member.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>