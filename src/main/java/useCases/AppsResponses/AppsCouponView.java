package useCases.AppsResponses;

import entities.Discount;

/**
 * Created by dsanchez on 12/5/17.
 */
public class AppsCouponView {
    private final Discount discount;

    public AppsCouponView(Discount discount) {
        this.discount = discount;
    }
}
