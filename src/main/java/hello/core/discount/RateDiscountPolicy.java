package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {

    final double discountRate = 0.1;

    int discountAmount = 0;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            discountAmount = (int)(price * discountRate);
        }
        return discountAmount;
    }
}
