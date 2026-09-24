package usefulglowberries.mixin;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import usefulglowberries.util.SoundUtil;

@Mixin(Frog.class)
public abstract class FrogMixin extends Animal {
	private static final Holder<MobEffect> EFFECT = MobEffects.LUCK;
	private static final int EFFECT_DURATION = 6000; // 5 minutes in ticks (20tps)

	private FrogMixin(final EntityType<? extends Animal> type, final Level level) {
		super(type, level);
	}

	private boolean isGlowBerried() {
		return this.hasEffect(EFFECT);
	}

	private void applyGlowBerryEffect() {
		this.addEffect(new MobEffectInstance(EFFECT, EFFECT_DURATION));
	}

	@Override
	public InteractionResult mobInteract(final Player player, final InteractionHand hand) {
		if (!this.isGlowBerried() && player instanceof ServerPlayer) {
			var itemStack = player.getItemInHand(hand);

			if (itemStack.is(Items.GLOW_BERRIES)) {
				this.applyGlowBerryEffect();
				this.playSound(SoundUtil.FROG_EAT_GLOW_BERRY);
				this.usePlayerItem(player, hand, itemStack);

				if (player instanceof ServerPlayer) {
					return InteractionResult.SUCCESS_SERVER;
				} else if (this.level().isClientSide()) {
					return InteractionResult.CONSUME;
				}
			}
		}

		return super.mobInteract(player, hand);
	}
}
