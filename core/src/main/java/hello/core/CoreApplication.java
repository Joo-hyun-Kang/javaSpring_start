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
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order);
	}

}
