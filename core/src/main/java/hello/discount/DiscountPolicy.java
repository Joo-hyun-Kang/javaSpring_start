package hello.discount;

import hello.member.Member;

public interface DiscountPolicy {
    /**
     * @return 割引対象価格
     * */
    int discount(Member member, int price);
}
