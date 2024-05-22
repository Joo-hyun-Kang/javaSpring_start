package hello.core;

import hello.Order.Order;
import hello.Order.OrderService;
import hello.Order.OrderServiceImpl;
import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		Member member = new Member(1L, "memberA", Grade.VIP);
//		memberService.join(member);
//
//		Member findMember = memberService.findMember(1L);
//		System.out.println("new Member = " + member.getName());
//		System.out.println("find Member = " + findMember.getName());

		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();

		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}

}
