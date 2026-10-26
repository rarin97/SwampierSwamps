package andrews.swampier_swamps;

import andrews.swampier_swamps.config.SSConfigs;
import andrews.swampier_swamps.network.SSNetwork;
import andrews.swampier_swamps.particles.DecayBubblesParticle;
import andrews.swampier_swamps.particles.SwampGasParticle;
import andrews.swampier_swamps.registry.*;
import andrews.swampier_swamps.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod(Reference.MODID)
public class SwampierSwamps {

    public SwampierSwamps(IEventBus eventBus, ModContainer modContainer, Dist dist) {

        SSFrogVariants.FROG_VARIANTS.register(eventBus);
        SSItems.ITEMS.register(eventBus);
        SSBlocks.BLOCKS.register(eventBus);
        SSFeatures.FEATURES.register(eventBus);
        SSEntities.ENTITIES.register(eventBus);
        SSParticles.PARTICLES.register(eventBus);
        SSBlockEntities.BLOCK_ENTITY_TYPES.register(eventBus);
        SSTrunkPlacers.TRUNK_PLACERS.register(eventBus);
        SSTreeDecorators.TREE_DECORATORS.register(eventBus);
        SSPlacements.PLACEMENT_MODIFIER.register(eventBus);

        if (dist.isClient()) {
            eventBus.addListener(this::setupClient);
            eventBus.addListener(this::setupParticles);
        }
        eventBus.addListener(this::setupCommon);
        eventBus.addListener(SSNetwork::register);

        SSConfigs.registerConfigs();
    }

    void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->
        {
            SSFlammables.registerFlammables();
            SSCompostable.registerCompostable();
        });
    }

    void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
        // Thread Safe Stuff Bellow
    }

    void setupParticles(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SSParticles.DECAY_BUBBLES.get(), DecayBubblesParticle.Factory::new);
        event.registerSpriteSet(SSParticles.SWAMP_GAS.get(), SwampGasParticle.Factory::new);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MODID, path);
    }
}