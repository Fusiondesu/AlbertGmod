package net.mcreator.arbiononline.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Map;

public class ShipmentItemInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure ShipmentItemInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShipmentItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((itemstack).getCount() < 10 && (itemstack).getCount() >= 5) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1));
		} else {
			if ((itemstack).getCount() < 15 && (itemstack).getCount() >= 10) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 2));
			} else {
				if ((itemstack).getCount() < 20 && (itemstack).getCount() >= 15) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 3));
				} else {
					if ((itemstack).getCount() < 25 && (itemstack).getCount() >= 20) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 4));
					} else {
						if ((itemstack).getCount() < 30 && (itemstack).getCount() >= 25) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 5));
						} else {
							if ((itemstack).getCount() < 35 && (itemstack).getCount() >= 30) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 6));
							} else {
								if ((itemstack).getCount() < 40 && (itemstack).getCount() >= 35) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 7));
								} else {
									if ((itemstack).getCount() < 45 && (itemstack).getCount() >= 50) {
										if (entity instanceof LivingEntity)
											((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 9));
									} else {
										if ((itemstack).getCount() < 55 && (itemstack).getCount() >= 45) {
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 8));
										} else {
											if ((itemstack).getCount() < 60 && (itemstack).getCount() >= 55) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 9));
											} else {
												if ((itemstack).getCount() >= 60) {
													if (entity instanceof LivingEntity)
														((LivingEntity) entity)
																.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 10));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
