package usefulglowberries.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.SignBlockEntity;
//? if >26.2
import net.minecraft.world.level.block.entity.SignTextSlot;
import usefulglowberries.util.SoundUtil;

public class GlowBerriesItem extends BlockItem implements SignApplicator {
	public GlowBerriesItem(final Item.Properties properties) {
		super(Blocks.CAVE_VINES, properties.useItemDescriptionPrefix());
	}

	@Override
	//? if >26.2 {
	public boolean tryApplyToSign(final Level level, final SignBlockEntity sign, final SignTextSlot slot, final ItemStack item, final Player player) {
		if (sign.updateText(text -> text.withGlowingText(true), slot)) {
	//? } else {
	/*public boolean tryApplyToSign(final Level level, final SignBlockEntity sign, final boolean isFrontText, final ItemStack item, final Player player) {
		if (sign.updateText(text -> text.setHasGlowingText(true), isFrontText)) {
	*///? }
			level.playSound(null, sign.getBlockPos(), SoundUtil.GLOW_BERRY_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
			return true;
		}

		return false;
	}
}
