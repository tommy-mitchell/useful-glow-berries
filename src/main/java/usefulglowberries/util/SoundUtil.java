package usefulglowberries.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import usefulglowberries.UsefulGlowBerries;

public class SoundUtil {
	private static SoundEvent registerSound(String id) {
		var identifier = UsefulGlowBerries.id(id);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

	public static SoundEvent FROG_EAT_GLOW_BERRY = registerSound("entity.frog.eat_glow_berry");
	public static SoundEvent GLOW_BERRY_USE = registerSound("item.glow_berry.use");

	// Class initialization registers sounds
	public static void initializeSounds() {}
}
