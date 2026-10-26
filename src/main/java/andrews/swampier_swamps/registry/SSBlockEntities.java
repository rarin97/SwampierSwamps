package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.block_entities.DecayingKelpBlockEntity;
import andrews.swampier_swamps.util.Reference;
import com.google.common.collect.Sets;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SSBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MODID);

    public static final Supplier<BlockEntityType<DecayingKelpBlockEntity>> DECAYING_KELP = BLOCK_ENTITY_TYPES.register("decaying_kelp", () -> new BlockEntityType<>(DecayingKelpBlockEntity::new, Sets.newHashSet(SSBlocks.DECAYING_KELP.get()), null));

    public static void registerBlockEntityRenderers() {

    }
}