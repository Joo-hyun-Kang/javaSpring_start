package hello.discount;


import hello.annotataion.MainDiscountPolicy;
import hello.member.Grade;
import hello.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
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
