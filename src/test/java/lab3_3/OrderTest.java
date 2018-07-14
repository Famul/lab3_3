package lab3_3;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;
import edu.iis.mto.time.OrderItem;
import edu.iis.mto.time.TimeSource;
import edu.iis.mto.time.TimeSrc;

public class OrderTest {

    @Test
    public void confirmingExpiredOrderShouldThrowOrderExpiredException() {
        TimeSource timeSource = new TimeSrc();
        Order order = new Order();
        order.setTimeSource(timeSource);
        order.addItem(new OrderItem());
        order.submit();
        timeSource.addHours(25);
        try {
            order.confirm();
            fail();
        } catch (OrderExpiredException e) {
            Assert.assertEquals(e.getClass(), OrderExpiredException.class);
        }
    }
}
