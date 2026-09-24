package usefulglowberries.mixin;

import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.block.SignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import usefulglowberries.item.GlowBerriesSignApplicator;

@Mixin(SignBlock.class)
public class SignBlockMixin {

	private static final SignApplicator SIGN_APPLICATOR = new GlowBerriesSignApplicator();

	@Expression("null")
	@ModifyExpressionValue(method = "useItemOn", at = @At(value = "MIXINEXTRAS:EXPRESSION", ordinal = 0))
	private Object onUseItemOn(Object original, @Local final ItemStack itemStack) {
		return itemStack.is(Items.GLOW_BERRIES) ? SIGN_APPLICATOR : original;
	}
}
