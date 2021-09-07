package makamys.mixingasm;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Mixingasm.MODID, version = Mixingasm.VERSION)
public class Mixingasm
{
    public static final String MODID = "mixingasm";
    public static final String VERSION = "@VERSION@";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
