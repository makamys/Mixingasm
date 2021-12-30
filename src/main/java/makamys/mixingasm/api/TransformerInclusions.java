package makamys.mixingasm.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.launchwrapper.Launch;

public class TransformerInclusions {
    
    private static final String INCLUSION_LIST_BLACKBOARD_KEY = "mixingasm.transformerInclusionList";
    
    public static List<String> getTransformerInclusionList(){
        List<String> list = (List<String>)Launch.blackboard.get(INCLUSION_LIST_BLACKBOARD_KEY);
        if(list == null) {
            Launch.blackboard.put(INCLUSION_LIST_BLACKBOARD_KEY, list = new ArrayList<String>());
        }
        return list;
    }
    
}
