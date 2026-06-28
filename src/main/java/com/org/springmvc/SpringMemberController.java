package com.org.springmvc;

import com.org.domain.Member;
import com.org.repository.MemberRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class SpringMemberController {

    private final MemberRepository memberRepository;

    public SpringMemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
    public String members(Model model, Authentication authentication) {
        List<Member> members = memberRepository.findAll();
        // 모델은 바구니고 members라는 이름표가 달린 members 객체를 담은 건가?
        // 그러면 그냥 바구니한에 이름표 달고 객체를 넣은게 모델인가?
        // 이렇게 넣으면 각 컨트롤러마다 해당 DTO를 만들지 않아도 되서 유용한건가? 이름표로 레포의 데이터를 바로 쏘니까 데이터의 형식의 오염도 줄고
        // A. Model은 데이터를 View로 전달하는 통로, DTO는 전달할 데이터의 구조, 화면에 필요한 데이터가 많이지면 DTO를 따로 만들 수 있음
        model.addAttribute("members", members);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("authorities", authentication.getAuthorities());
        return "members";
    }
}
