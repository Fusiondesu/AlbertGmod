
package net.mcreator.arbiononline.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.arbiononline.procedures.OmegaTonicPlayerFinishesUsingItemProcedure;
import net.mcreator.arbiononline.ArbiononlineModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@ArbiononlineModElements.ModElement.Tag
public class OmegaTonicItem extends ArbiononlineModElements.ModElement {
	@ObjectHolder("arbiononline:omega_tonic")
	public static final Item block = null;

	public OmegaTonicItem(ArbiononlineModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(10).isImmuneToFire().rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("omega_tonic");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 32;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A tonic that gives various effects with dependecies."));
			list.add(new StringTextComponent("Each time the tonic is consumed"));
			list.add(new StringTextComponent("the effect checks will be applied from top to bottom."));
			list.add(new StringTextComponent("When consumed"));
			list.add(new StringTextComponent("4 HP is regenerated over 4 seconds."));
			list.add(new StringTextComponent("If regeneration is already present"));
			list.add(new StringTextComponent("tonic gives resistance instead."));
			list.add(new StringTextComponent("If resistance is already present"));
			list.add(new StringTextComponent("tonic gives strength instead."));
			list.add(new StringTextComponent("If strength is already present"));
			list.add(new StringTextComponent("tonic gives movement speed."));
			list.add(new StringTextComponent("If all the effects above are already present"));
			list.add(new StringTextComponent("tonic improves the benefits of the tonic"));
			list.add(new StringTextComponent("cleanses all other temporary effects"));
			list.add(new StringTextComponent("and make their durations will be set to 6 seconds!"));
			list.add(new StringTextComponent("Every time tonic is consumed"));
			list.add(new StringTextComponent("its effect durations will be reset."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			OmegaTonicPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
