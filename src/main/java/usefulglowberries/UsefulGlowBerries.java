package usefulglowberries;

import dev.kikugie.fletching_table.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import usefulglowberries.util.PolymerUtil;
import usefulglowberries.util.SoundUtil;

@Entrypoint
public class UsefulGlowBerries implements ModInitializer {
	public static final String MOD_ID = "useful-glow-berries";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SoundUtil.initializeSounds();

		if (FabricLoader.getInstance().isModLoaded("polymer-core")) {
			PolymerUtil.initialize();
		}
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
