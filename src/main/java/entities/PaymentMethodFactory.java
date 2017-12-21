package entities;

/**
 * Created by dsanchez on 12/5/17.
 */
public class PaymentMethodFactory {
    public PaymentMethod buildBaseOn( DataBag paymentMethodFromApi ) {
        if (paymentMethodFromApi.get("payment_method_id") == "account_money") {

            return new AccountMoney( paymentMethodFromApi );
        }

        return new Generic( paymentMethodFromApi );

    }
}
