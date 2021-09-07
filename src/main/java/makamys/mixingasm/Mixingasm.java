package makamys.mixingasm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import makamys.mclib.core.MCLib;
import makamys.mclib.core.MCLibModules;

import static makamys.mixingasm.MixinConfigPlugin.MODID;

@Mod(modid = MODID, version = "@VERSION@")
public class Mixingasm {
    static {
        MCLib.init();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MCLibModules.updateCheckAPI.submitModTask(MODID, "@UPDATE_URL@");
    }
}