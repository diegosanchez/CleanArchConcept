package entities;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dsanchez on 12/3/17.
 */
public class TestDiscount {
    @Test
    public void createDiscountFromData() {
        final List<Map> listOfPayments = Arrays.asList(
                new HashMap<String, Object>(){{
                    put("campaign_id", 1234567890);
                    put("payment_method_id", "account_money");
                    put("amount", 5);
                    put("issuer_id", "*");
                    put("coupon_amount", 5);
                }},
                new HashMap<String, Object>(){{
                    put("campaign_id", 1234567890);
                    put("payment_method_id", "*");
                    put("amount", 5);
                    put("issuer_id", "*");
                    put("coupon_amount", 5);
                }}
        );

        final List<Map> listOfCoupons = Arrays.asList(
            new HashMap<String, Object>(){{
                put("code", "MP10OFF");
                put("discount_ammount", 120);
            }}
        );

        DataBag discountFromApi = new DataBag(
            new HashMap<String, Object>(){{
                put("id", "fe1bfae0-b372-11e7-abc4-cec278b6b50a");
                put("discount_amount", 120);
                put("payments", listOfPayments);
                put("coupons", listOfCoupons);
            }}
        );

        Discount d = new Discount( discountFromApi );

        final List<Map> expectedListOfPayments = Arrays.asList(
            new HashMap<String, Object>(){{
                put("campaign_id", 1234567890);
                put("payment_method_id", "account_money");
                put("amount", 5);
                put("issuer_id", ".");
                put("coupon_amount", 5);
            }},
            new HashMap<String, Object>(){{
                put("campaign_id", 1234567890);
                put("payment_method_id", ".");
                put("amount", 5);
                put("issuer_id", ".");
                put("coupon_amount", 5);
            }}
        );

        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("id", "fe1bfae0-b372-11e7-abc4-cec278b6b50a");
                    put("discount_amount", 120);
                    put("payments", expectedListOfPayments);
                }}
        );
        assertEquals(expected, d.getModel());
    }
}
