package entities;

import java.util.Map;

/**
 * Created by dsanchez on 12/2/17.
 */
public class Generic implements PaymentMethod {
    private final DataBag data;

    public Generic(DataBag data) {
        this.data = data;
        this.data.put("payment_method_id", ".");
        this.data.replaceValueWith("*", ".");

    }

    public final Map asMap() {
        return this.data.asMap();
    }

    @Override
    public final DataBag asDataBag() {
        return this.data;
    }
}
