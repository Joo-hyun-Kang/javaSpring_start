package hello.discount;

import hello.member.Grade;
import hello.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIPは割引が適用すべきだ")
    void vip_o() {
        //given
        Member m1 = new Member(1L, "m1", Grade.VIP);

        //when
        int price = 1234;
        int discountPrice = discountPolicy.discount(m1, price);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(price * 10 / 100);
    }

    @Test
    @DisplayName("VIPではなければ、割引適用ができない")
    void vip_x() {
        //given
        Member m2 = new Member(1L, "m2", Grade.BASIC);

        //when
        int price = 1234;
        int discountPrice = discountPolicy.discount(m2, price);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}