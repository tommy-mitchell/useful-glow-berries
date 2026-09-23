package usefulglowberries.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import usefulglowberries.UsefulGlowBerries;

public class SoundUtil {
	public static SoundEvent GLOW_BERRY_USE = registerSound("item.glow_berry.use");

	private static SoundEvent registerSound(String id) {
		var identifier = UsefulGlowBerries.id(id);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

	// Class initialization registers sounds
	public static void initializeSounds() {}
}
