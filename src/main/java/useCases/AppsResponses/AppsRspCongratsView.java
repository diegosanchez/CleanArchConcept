package useCases.AppsResponses;

import entities.Android;
import entities.Discount;
import useCases.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dsanchez on 12/5/17.
 */
public class AppsRspCongratsView implements Response {
    public AppsRspCongratsView(Discount discount, Android client) {
    }

    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> model = new HashMap<String, Object>(){{
            put("status", "success");
            put("substatus", null);
            put("subtitle", "Ahora paga con VISA crédito y obtén un 25 % de descuento.");
        }};

        return new HashMap<String,Object>(){{
            put("type", "model");
            put("model", model);

        }};
    }
}
