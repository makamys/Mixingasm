package makamys.mixingasm;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class MixingasmTweaker implements ITweaker {
    
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        Mixingasm.run();
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() {
        return "";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }

}
