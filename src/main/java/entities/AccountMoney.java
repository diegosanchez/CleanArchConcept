package entities;


import java.util.Map;

/**
 * Created by dsanchez on 12/2/17.
 */
public class AccountMoney implements PaymentMethod {
    private DataBag data;

    public AccountMoney(DataBag data) {
        this.data = data;

        this.data.put("payment_method_id", "account_money");

        this.data.replaceValueWith("*", ".");
    }

    @Override
    public final Map asMap() {
        return this.data.asMap();
    }

    @Override
    public final DataBag asDataBag() {
        return this.data;
    }
}
