package sinclairr08.clonespringbasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sinclairr08.clonespringbasic.AppConfig;
import sinclairr08.clonespringbasic.member.Grade;
import sinclairr08.clonespringbasic.member.Member;
import sinclairr08.clonespringbasic.member.MemberService;
import sinclairr08.clonespringbasic.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
