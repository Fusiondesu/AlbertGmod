package net.mcreator.arbiononline.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.potion.AshenNighttarHealingPotionEffect;
import net.mcreator.arbiononline.potion.AshenNightstarPotionEffect;
import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Map;
import java.util.Collection;

public class PolarStarProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure PolarStarProjectileHitsLivingEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PolarStarProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double stack = 0;
		if (new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AshenNightstarPotionEffect.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(sourceentity) == 4) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity)
						.addPotionEffect(new EffectInstance(AshenNighttarHealingPotionEffect.potion, (int) 85, (int) 4, (false), (false)));
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(AshenNightstarPotionEffect.potion, (int) 80, (int) 4));
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("frostbite").setDamageBypassesArmor(), (float) 2);
			}
		} else {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity)
						.addPotionEffect(new EffectInstance(AshenNighttarHealingPotionEffect.potion, (int) 85, (int) (new Object() {
							int check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == AshenNighttarHealingPotionEffect.potion)
											return effect.getAmplifier();
									}
								}
								return 0;
							}
						}.check(sourceentity) + 1), (false), (false)));
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(AshenNightstarPotionEffect.potion, (int) 80, (int) (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == AshenNightstarPotionEffect.potion)
									return effect.getAmplifier();
							}
						}
						return 0;
					}
				}.check(sourceentity) + 1)));
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("frostbite").setDamageBypassesArmor(), (float) (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == AshenNightstarPotionEffect.potion)
									return effect.getAmplifier();
							}
						}
						return 0;
					}
				}.check(sourceentity) * 0.5));
			}
		}
	}
}
