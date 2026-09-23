package usefulglowberries.util;

import eu.pb4.polymer.core.api.other.PolymerSoundEvent;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import usefulglowberries.UsefulGlowBerries;

public class PolymerUtil {
	public static void initialize() {
		PolymerResourcePackUtils.addModAssets(UsefulGlowBerries.MOD_ID);
		PolymerResourcePackUtils.markAsRequired();

		PolymerSoundEvent.registerOverlay(SoundUtil.GLOW_BERRY_USE);
	}
}
