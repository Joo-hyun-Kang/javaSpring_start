package hello.Order;

import hello.discount.DiscountPolicy;
import hello.discount.FixDiscountPolicy;
import hello.discount.RateDiscountPolicy;
import hello.member.Member;
import hello.member.MemberRepository;
import hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //テスト用
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
