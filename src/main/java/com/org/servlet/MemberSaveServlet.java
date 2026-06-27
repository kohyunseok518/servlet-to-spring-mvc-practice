package com.org.servlet;

import com.org.domain.Member;
import com.org.repository.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // TODO: POST 요청을 처리하는 doPost 메서드를 오버라이드한다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: req.getParameter("username")으로 username을 읽는다.
        String username = req.getParameter("username");
        // TODO: req.getParameter("age")로 age를 읽고 int로 변환한다.
        int age = Integer.parseInt(req.getParameter("age"));
        // TODO: Member 객체를 만든다.
        Member member = new Member(username,age);
        // TODO: MemberRepository에 저장한다.
        memberRepository.save(member);
        // TODO: response.getWriter()로 저장 결과 HTML을 직접 출력한다.
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("성공");
        writer.println("<ul>");
        writer.println("    <li>id=" + member.getId() + "</li>");
        writer.println("    <li>username=" + member.getUsername() + "</li>");
        writer.println("    <li>age=" + member.getAge() + "</li>");
        writer.println("</ul>");
        writer.println("<a href=\"" + req.getContextPath() + "/members/new\">다시 등록</a>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
