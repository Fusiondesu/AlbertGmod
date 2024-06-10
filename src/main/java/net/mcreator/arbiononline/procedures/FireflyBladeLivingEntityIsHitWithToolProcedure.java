package net.mcreator.arbiononline.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.potion.FireflyDescendPotionEffect;
import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Random;
import java.util.Map;
import java.util.Collection;

public class FireflyBladeLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure FireflyBladeLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FireflyBladeLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double dice = 0;
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == FireflyDescendPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(sourceentity)) {
			dice = (MathHelper.nextDouble(new Random(), 1, 100));
			if (dice <= new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == FireflyDescendPotionEffect.potion)
								return effect.getAmplifier();
						}
					}
					return 0;
				}
			}.check(sourceentity) * 20) {
				entity.setFire((int) 5);
			}
		}
	}
}
