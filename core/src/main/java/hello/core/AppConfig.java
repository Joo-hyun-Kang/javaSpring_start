package hello.core;

import hello.Order.OrderService;
import hello.Order.OrderServiceImpl;
import hello.discount.RateDiscountPolicy;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy()
        );
    }
}
