# Mixingasm
Mod for Minecraft 1.7.10 that improves compatibility between mixin mods and ASM mods.
See [transformer_inclusion_list_default.txt](src/main/resources/assets/mixingasm/default_config/mixingasm/transformer_inclusion_list_default.txt) for more info on how it works.

The mod is a workaround for https://github.com/SpongePowered/Mixin/issues/309.

# Usage
Just drop it in your mods folder. Config is available in the `config/mixingasm` folder.

**Warning**: if Mixin is not present, this mod will cause the game to crash on startup.

**Note:** Mixingasm is included in [GasStation](https://github.com/FalsePattern/GasStation) and [UniMixins](https://github.com/LegacyModdingMC/UniMixins). If you are using one of those, you don't need to install Mixingasm separately.

## License
This project is licensed under the [Unlicense](UNLICENSE).
