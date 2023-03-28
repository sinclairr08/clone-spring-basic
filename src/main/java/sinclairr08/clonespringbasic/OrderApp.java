package sinclairr08.clonespringbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sinclairr08.clonespringbasic.member.Grade;
import sinclairr08.clonespringbasic.member.Member;
import sinclairr08.clonespringbasic.member.MemberService;
import sinclairr08.clonespringbasic.member.MemberServiceImpl;
import sinclairr08.clonespringbasic.order.Order;
import sinclairr08.clonespringbasic.order.OrderService;
import sinclairr08.clonespringbasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
