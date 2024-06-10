package net.mcreator.arbiononline.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.arbiononline.ArbiononlineMod;

import java.util.Random;
import java.util.Map;

public class WhiteTasselLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ArbiononlineMod.LOGGER.warn("Failed to load dependency entity for procedure WhiteTasselLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double crit = 0;
		crit = (MathHelper.nextDouble(new Random(), 1, 100));
		if (crit >= 23) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("critical damage").setDamageBypassesArmor(), (float) 2);
			}
		}
	}
}
