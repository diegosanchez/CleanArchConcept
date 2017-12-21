package useCases.AppsResponses;

import entities.Android;
import entities.Discount;
import useCases.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dsanchez on 12/5/17.
 */
public class AppsRspEditView implements Response {
    private final Discount discount;

    public AppsRspEditView(Discount discount, Android client) {
        this.discount = discount;
    }

    @Override
    public Map<String, Object> asMap() {

        Map<String, Object> model = new HashMap<String, Object>(){{
            put("title", "Cupón");
            put("coupons", new AppsCouponView(discount).toString());
        }};


        return new HashMap<String,Object>(){{
            put("type", "edit_modal");
            put("model", model);
        }};
    }
}
