package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.level.decorators.LeaveSwampVineDecorator;
import andrews.swampier_swamps.util.Reference;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class SSTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, Reference.MODID);

    public static final Supplier<TreeDecoratorType<LeaveSwampVineDecorator>> LEAVE_SWAMP_VINE = TREE_DECORATORS.register("leave_swamp_vine", () -> new TreeDecoratorType<>(LeaveSwampVineDecorator.CODEC));
}
