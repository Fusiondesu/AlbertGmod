package net.mcreator.arbiononline.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Map;

public class ShieldingTonicPlayerFinishesUsingItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure ShieldingTonicPlayerFinishesUsingItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 3) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
			}
			entity.attackEntityFrom(DamageSource.MAGIC, (float) 3);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
		} else {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 2.5
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 3) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
				}
				entity.attackEntityFrom(DamageSource.MAGIC, (float) 2.5);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
			} else {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 2
						&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 2.5) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
					}
					entity.attackEntityFrom(DamageSource.MAGIC, (float) 2);
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
				} else {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 1.5
							&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 2) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
						}
						entity.attackEntityFrom(DamageSource.MAGIC, (float) 1.5);
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
					} else {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 1
								&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 1.5) {
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
							}
							entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
						} else {
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 0.75
									&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 1) {
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
								}
								entity.attackEntityFrom(DamageSource.MAGIC, (float) 0.5);
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
							} else {
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
								}
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 160, (int) 4));
							}
						}
					}
				}
			}
		}
	}
}
