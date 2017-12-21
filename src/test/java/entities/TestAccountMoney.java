package entities;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dsanchez on 12/2/17.
 */
public class TestAccountMoney {
    @Test
    public void createAccountMoneyWithGenericIssuerAndGetaRegularExpressionInstead() {
        AccountMoney am = new AccountMoney(
                new DataBag(
                        new HashMap<String, Object>(){{
                            put("campaign_id", 1234567890);
                            put("payment_method_id", "account_money");
                            put("amount", 5);
                            put("issuer_id", "*");
                            put("coupon_amount", 5);
                        }}
                )
        );

        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("campaign_id", 1234567890);
                    put("payment_method_id", "account_money");
                    put("amount", 5);
                    put("issuer_id", "." );;
                    put("coupon_amount", 5);
                }}
        );
        assertEquals( am.asDataBag(), expected);
    }
}
