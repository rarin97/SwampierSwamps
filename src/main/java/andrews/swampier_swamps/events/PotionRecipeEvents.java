package andrews.swampier_swamps.events;

import andrews.swampier_swamps.config.SSConfigs;
import andrews.swampier_swamps.registry.SSItems;
import andrews.swampier_swamps.util.Reference;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = Reference.MODID)
public class PotionRecipeEvents {

    @SubscribeEvent
    public static void registerBrewingRecipe(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        if (SSConfigs.commonConfig.alterRecipes.get()) {
            builder.addMix(Potions.AWKWARD, SSItems.FROG_LEG.get(), Potions.LEAPING);
        }
    }
}
