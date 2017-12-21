package useCases.AppsResponses;

import entities.Android;
import entities.Discount;
import useCases.Response;

import java.util.Map;

/**
 * Created by dsanchez on 12/5/17.
 */
public class AppsRspModel implements Response {
    private final Android client;
    private final Discount discount;

    public AppsRspModel(Discount discount, Android client) {
        this.discount = discount;
        this.client = client;
    }

    @Override
    public Map<String, Object> asMap() {

        return this.discount.getModel().asMap();
    }
}
