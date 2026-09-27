package usefulglowberries.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.block.SignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import usefulglowberries.item.GlowBerriesSignApplicator;

@Mixin(SignBlock.class)
public class SignBlockMixin {

	private static final SignApplicator SIGN_APPLICATOR = new GlowBerriesSignApplicator();

	@ModifyVariable(method = "useItemOn", at = @At("STORE"), name = "signApplicator")
	private SignApplicator onUseItemOn(SignApplicator original, final ItemStack itemStack) {
		if (original == null && itemStack.is(Items.GLOW_BERRIES)) {
			return SIGN_APPLICATOR;
		}

		return original;
	}
}
