package sinclairr08.clonespringbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sinclairr08.clonespringbasic.discount.DiscountPolicy;
import sinclairr08.clonespringbasic.discount.FixDiscountPolicy;
import sinclairr08.clonespringbasic.discount.RateDiscountPolicy;
import sinclairr08.clonespringbasic.member.MemberRepository;
import sinclairr08.clonespringbasic.member.MemberService;
import sinclairr08.clonespringbasic.member.MemberServiceImpl;
import sinclairr08.clonespringbasic.member.MemoryMemberRepository;
import sinclairr08.clonespringbasic.order.OrderService;
import sinclairr08.clonespringbasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService()  {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
