package net.mcreator.arbiononline.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Random;
import java.util.Map;

public class PoisonedShardesItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonedShardesItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double dice = 0;
		dice = (MathHelper.nextInt(new Random(), 0, 2000));
		if (dice <= 200) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 1));
		}
	}
}
