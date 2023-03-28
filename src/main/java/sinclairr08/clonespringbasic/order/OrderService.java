package sinclairr08.clonespringbasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
