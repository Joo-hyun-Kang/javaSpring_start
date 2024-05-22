package hello.core;

import hello.Order.OrderService;
import hello.Order.OrderServiceImpl;
import hello.discount.DiscountPolicy;
import hello.discount.FixDiscountPolicy;
import hello.discount.RateDiscountPolicy;
import hello.member.MemberRepository;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
