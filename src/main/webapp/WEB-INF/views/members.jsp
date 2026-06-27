<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.org.domain.Member" %>

<%
    List<Member> members = (List<Member>) request.getAttribute("members");
%>

<html>
<body>
<a href="<%= request.getContextPath() %>/members/new">회원 등록</a>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
    %>
    <tr>
        <td><%= member.getId() %></td>
        <td><%= member.getUsername() %></td>
        <td><%= member.getAge() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>