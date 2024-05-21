package hello.core;

import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new Member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}

}
