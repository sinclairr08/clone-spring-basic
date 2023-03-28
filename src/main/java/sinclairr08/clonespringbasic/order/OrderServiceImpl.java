package sinclairr08.clonespringbasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sinclairr08.clonespringbasic.annotation.MainDiscountPolicy;
import sinclairr08.clonespringbasic.discount.DiscountPolicy;
import sinclairr08.clonespringbasic.member.Member;
import sinclairr08.clonespringbasic.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // For test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
