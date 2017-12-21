package useCases;

import entities.Android;
import entities.CouponId;
import entities.Discount;
import org.junit.Test;
import services.DiscountRestClient;
import useCases.AppsResponses.AppsResponse;

import static org.junit.Assert.assertEquals;


/**
 * Created by dsanchez on 12/5/17.
 */
public class TestAppsAskForCoupon {

    @Test
    public void testAndroidAppsAskForCoupons() {
        Android client = new Android();

        DiscountRestClient discountService = new DiscountRestClient();

        Discount discount = discountService.find( new CouponId("ITEMxxx"));

        AppsResponse response = new AppsResponse(discount, client);

        String expected = "{congrats_view={model={substatus=null, subtitle=Ahora paga con VISA crédito y obtén un 25 % de descuento., status=success}, type=model}, model={discount_amount=120, payments=[{coupon_amount=5, issuer_id=., payment_method_id=account_money, amount=5, campaign_id=1234567890}, {coupon_amount=5, issuer_id=., payment_method_id=., amount=5, campaign_id=1234567890}], id=fe1bfae0-b372-11e7-abc4-cec278b6b50a}, edit_view={model={coupons=useCases.AppsResponses.AppsCouponView@73c6c3b2, title=Cupón}, type=edit_modal}}";
        assertEquals(response.asMap().toString(), expected);




    }
}
