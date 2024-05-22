package hello.discount;


import hello.member.Grade;
import hello.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000円　割引

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
        {
            return discountFixAmount;
        }

        return 0;
    }
}
