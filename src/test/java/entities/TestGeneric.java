package entities;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dsanchez on 12/3/17.
 */
public class TestGeneric {
    @Test
    public void createAccountMoneyWithGenericIssuerAndGetaRegularExpressionInstead() {
        Generic g = new Generic(
                new DataBag(
                        new HashMap<String, Object>(){{
                            put("campaign_id", 1234567890);
                            put("payment_method_id", "*");
                            put("amount", 5);
                            put("issuer_id", "*");
                            put("coupon_amount", 5);
                        }}
                )
        );

        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("campaign_id", 1234567890);
                    put("payment_method_id", ".");
                    put("amount", 5);
                    put("issuer_id", "." );;
                    put("coupon_amount", 5);
                }}
        );
        assertEquals( g.asDataBag(), expected);
    }

}
