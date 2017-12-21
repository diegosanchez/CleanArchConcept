package useCases.AppsResponses;

import entities.Android;
import entities.DataBag;
import entities.Discount;
import useCases.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dsanchez on 12/5/17.
 */
public class AppsResponse implements Response {
    private Map<String, Response>  sections;

    public AppsResponse(Discount discount, Android client) {
         sections = new HashMap<>();

         sections.put("model", new AppsRspModel(discount, client));
         sections.put("congrats_view", new AppsRspCongratsView(discount, client));
         sections.put("edit_view", new AppsRspEditView(discount, client));
    }

    @Override
    public Map<String, Object> asMap() {
        DataBag result = new DataBag();
        
        for( String section :  sections.keySet()) {
            result.put(section, sections.get(section).asMap());
            
        }
        return result.asMap();
    }
}
