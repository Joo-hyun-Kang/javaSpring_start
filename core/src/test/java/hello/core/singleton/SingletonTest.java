package hello.core.singleton;

import hello.core.AppConfig;
import hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("springなし、純粋DIコンテイナー")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //ユーザーのリクエスト１
        MemberService memberService1 = appConfig.memberService();

        //ユーザーのリクエスト２
        MemberService memberService2 = appConfig.memberService();

        //異なるオブジェクト
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("シングルトンパタンを適用したオブジェクトを使用")
    public void singletonServiceTest() {
//        new SingletonService(); プライペートコンストラクターなのでコンパイルエラーが生じる

        //ユーザーのリクエストごと、同じオブジェクトが返る
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //レファランスが同じことを確認する
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        //singletonService1 == singletonService2
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("springコンテイナーとシングルトン")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //リクエストの時、同じインスタンスを返る
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //レファランスが同じことを確認する
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
