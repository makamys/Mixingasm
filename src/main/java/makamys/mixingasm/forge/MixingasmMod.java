package makamys.mixingasm.forge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import makamys.mclib.core.MCLib;
import makamys.mclib.core.MCLibModules;
import makamys.mixingasm.Mixingasm;

@Mod(modid = Mixingasm.MODID, version = "@VERSION@")
public class MixingasmMod {
    
    @EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        MCLib.init();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MCLibModules.updateCheckAPI.submitModTask(Mixingasm.MODID, "@UPDATE_URL@");
    }
}