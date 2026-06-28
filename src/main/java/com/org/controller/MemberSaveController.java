//package com.org.controller;
//
//import com.org.domain.Member;
//import com.org.repository.MemberRepository;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
//// 해당 컨트롤러의 책임은 회원 저장 후 목록으로 redirect
//public class MemberSaveController implements Controller{
//    private MemberRepository memberRepository = MemberRepository.getInstance();
//
//    @Override
//    public String process(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        int age = Integer.parseInt(req.getParameter("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        return "redirect:/mvc/members";
//    }
//}
