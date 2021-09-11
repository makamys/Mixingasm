package makamys.mixingasm;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

import net.minecraft.launchwrapper.Launch;

public class Mixingasm {
    
    public static final String MODID = "mixingasm";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static void run() {
        List<String> badTransformers = getBadTransformers();
        LOGGER.debug("Read bad transformer list: " + badTransformers);
        for(String badTransformer : badTransformers) {
            MixinEnvironment.getCurrentEnvironment().addTransformerExclusion(badTransformer);
        }
    }
    
    private static List<String> getBadTransformers() {
        ConfigHelper helper = new ConfigHelper(MODID);
        File listFile = new File(Launch.minecraftHome, "config/" + MODID + "/transformer_exclusion_list.txt");
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
