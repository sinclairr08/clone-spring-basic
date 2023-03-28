package sinclairr08.clonespringbasic.discount;

import sinclairr08.clonespringbasic.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     * */
    int discount(Member member, int price);
}
