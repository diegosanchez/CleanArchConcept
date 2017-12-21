package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dsanchez on 12/3/17.
 */
public class Discount {
    private final DataBag discountFromApi;

    public Discount(DataBag discountFromApi) {

        this.discountFromApi = discountFromApi;
    }

    private PaymentMethod getPaymentMethod(Map paymentMethodFromApi) {
        return new PaymentMethodFactory().buildBaseOn( new DataBag(paymentMethodFromApi) );
    }
    private List<Map> getPaymentMethods() {
        List<Map> result = new ArrayList<>();
        List<Map> payments = this.discountFromApi.getList("payments");

        for( Map m : payments) {
            result.add( this.getPaymentMethod(m).asMap() );
        }

        return result;
    };

    public DataBag getModel() {
        DataBag result = this.discountFromApi.pick(
            "id",
            "discount_amount"
        );

        result.put("payments", getPaymentMethods() );


        return result;
    }
}
