//package com.org.servlet;
//
//import com.org.domain.Member;
//import com.org.repository.MemberRepository;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//public class MemberServlet extends HttpServlet {
////    private MemberRepository memberRepository = MemberRepository.getInstance();
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        List<Member> members = memberRepository.findAll();
//
//        // 요청에 리스트 담기
//        // request 바구니에 "members"라는 이름표를 붙여서 회원 목록 데이터를 넣는다.
////        req.setAttribute("members", members);
//        resp.setContentType("text/html; charset=UTF-8");
//
//        String viewPath = "/WEB-INF/views/members.jsp";
//        // 이 요청과 응답을 그대로 들고 서버 안에서 members.jsp에게 넘긴다.
//        // 브라우저는 이 사실을 모르고 서버 내부에서만 MemberServlet이 처리하다가 members.jsp에 넘겨버림
//        // forward - request를 유지한 채 JSP에게 화면 만들기를 맡기기
//        req.getRequestDispatcher(viewPath).forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // 요청으로 받은 파라미터를 꺼냄
//        String username = req.getParameter("username");
//        int age = Integer.parseInt(req.getParameter("age"));
//
//        // 해당 파라미터로 member 생성
//        Member member = new Member(username, age);
//        // 저장소에 저장
////        memberRepository.save(member);
//        resp.setContentType("text/html;charset=UTF-8");
//
//        resp.sendRedirect(req.getContextPath() + "/members");
//    }
//}
