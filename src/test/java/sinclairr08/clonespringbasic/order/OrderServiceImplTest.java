package sinclairr08.clonespringbasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sinclairr08.clonespringbasic.discount.FixDiscountPolicy;
import sinclairr08.clonespringbasic.member.Grade;
import sinclairr08.clonespringbasic.member.Member;
import sinclairr08.clonespringbasic.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}