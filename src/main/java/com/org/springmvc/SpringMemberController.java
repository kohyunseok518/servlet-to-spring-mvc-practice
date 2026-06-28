package com.org.springmvc;

import com.org.domain.Member;
import com.org.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberController {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/members/new")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/members")
    public String save(HttpServletRequest req) {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        return "redirect:/spring/members";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }
}
