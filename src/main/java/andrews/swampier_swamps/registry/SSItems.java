package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.objects.items.GasBottleItem;
import andrews.swampier_swamps.util.Reference;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MODID);

    public static final DeferredItem<Item> FROG_LEG = ITEMS.register("frog_leg", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> COOKED_FROG_LEG = ITEMS.register("cooked_frog_leg", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> GAS_BOTTLE = ITEMS.register("gas_bottle", () -> new GasBottleItem(new Item.Properties().stacksTo(1)));
    // Spawn Eggs
    public static final DeferredItem<Item> DRAGONFLY_SPAWN_EGG = ITEMS.register("dragonfly_spawn_egg", () -> new DeferredSpawnEggItem(SSEntities.DRAGONFLY, 0x2b3f8a, 0x94de2c, new Item.Properties()));
}