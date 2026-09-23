package usefulglowberries.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import java.util.function.Function;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import usefulglowberries.item.GlowBerriesItem;

@Mixin(Items.class)
public class ItemsMixin {
	@Definition(id = "registerItem", method = "Lnet/minecraft/world/item/Items;registerItem(Lnet/minecraft/references/BlockItemId;Ljava/util/function/Function;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/Item;")
	@Definition(id = "GLOW_BERRY_CROP", field = "Lnet/minecraft/references/BlockItemIds;GLOW_BERRY_CROP:Lnet/minecraft/references/BlockItemId;")
	@Expression("registerItem(GLOW_BERRY_CROP, @(?), ?)")
	@Redirect(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
	private static Function<Properties, Item> redirectGlowBerriesItemFactory(final Block block) {
		return p -> new GlowBerriesItem(p);
	}
}
