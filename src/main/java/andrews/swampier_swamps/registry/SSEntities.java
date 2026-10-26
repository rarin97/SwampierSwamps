package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.entities.Dragonfly;
import andrews.swampier_swamps.entities.SwampGas;
import andrews.swampier_swamps.util.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SSEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Reference.MODID);

    public static final Supplier<EntityType<Dragonfly>> DRAGONFLY = ENTITIES.register("dragonfly", () -> EntityType.Builder.of(Dragonfly::new, MobCategory.CREATURE).sized(0.5F, 0.25F).clientTrackingRange(10).build(ResourceLocation.fromNamespaceAndPath(Reference.MODID, "dragonfly").toString()));
    public static final Supplier<EntityType<SwampGas>> SWAMP_GAS = ENTITIES.register("swamp_gas", () -> EntityType.Builder.of(SwampGas::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(8).build(ResourceLocation.fromNamespaceAndPath(Reference.MODID, "swamp_gas").toString()));

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(DRAGONFLY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dragonfly::checkDragonflySpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
    }
}