//package com.org.controller;
//
//import com.org.domain.Member;
//import com.org.repository.MemberRepository;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//public class MemberListController implements Controller {
//    private MemberRepository memberRepository = MemberRepository.getInstance();
//
//    @Override
//    public String process(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model) throws ServletException, IOException {
//        List<Member> members = memberRepository.findAll();
//        model.put("members", members);
//        return "members";
//    }
//}
