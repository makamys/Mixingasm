package makamys.mixingasm;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;

public class Mixingasm {
    
    public static final String MODID = "mixingasm";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static void run() {
        List<String> badTransformers = getBadTransformers();
        LOGGER.debug("Excluding transformers: " + badTransformers);
        for(String badTransformer : badTransformers) {
            MixinEnvironment.getCurrentEnvironment().addTransformerExclusion(badTransformer);
        }
    }
    
    private static List<String> getBadTransformers() {
        List<String> badTransformers = new ArrayList<>();
        List<String> goodTransformerPatterns = getGoodTransformerPatterns();
        for(IClassTransformer trans : Launch.classLoader.getTransformers()) {
            String name = trans.getClass().getCanonicalName();
            if(!goodTransformerPatterns.stream().anyMatch(p -> patternMatches(name, p))) {
                LOGGER.debug("  Not trusting transformer " + name);
                badTransformers.add(name);
            } else {
                LOGGER.debug("      Trusting transformer " + name);
            }
        }
        return badTransformers;
    }
    
    private static boolean patternMatches(String str, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr.replace(".", "\\.").replace("*", ".*"));
        return pattern.matcher(str).matches();
    }
    
    private static List<String> getGoodTransformerPatterns() {
        return readConfig("transformer_inclusion_list.txt");
    }
    
    private static List<String> readConfig(String name){
        ConfigHelper helper = new ConfigHelper(MODID);
        File listFile = new File(Launch.minecraftHome, "config/" + MODID + "/" + name);
        helper.createDefaultConfigFileIfMissing(listFile.getParentFile(), false);
        try {
            return IOUtils.readLines(new FileReader(listFile)).stream().filter(l -> !l.isEmpty() && !l.startsWith("#")).collect(Collectors.toList());
        } catch(Exception e) {
            System.out.println("Failed to read " + listFile);
            e.printStackTrace();
        }
        return Arrays.asList();
    }
    
}
