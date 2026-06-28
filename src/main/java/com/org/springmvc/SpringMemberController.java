package com.org.springmvc;

import com.org.domain.Member;
import com.org.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 1. @RequestParam 어노테이션 사용, 스프링 프레임워크가 자동으로 형변환도 해준다.
    // 2. @ModelAttribute 어노테이션 사용으로 필드 이름과 요청으로 들어온 인자의 이름이 같고 해당 객체에 Setter 메서드가 있으면 자동으로 객체를 생성한다.
    /*
        파라미터에 Member member만 적어도 Spring이 자동으로
        1. Member 기본 생성자 호출
        2. username 파라미터를 setUsername()
        3. age 파라미터를 setAge()
        4. Controller 메서드에 전달
     */
    @PostMapping("/members")
    public String save(Member member) {
        memberRepository.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }
}
