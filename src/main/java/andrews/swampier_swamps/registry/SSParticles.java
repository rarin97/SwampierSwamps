package andrews.swampier_swamps.registry;

import andrews.swampier_swamps.util.Reference;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class SSParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Reference.MODID);

    public static final Supplier<SimpleParticleType> DECAY_BUBBLES = PARTICLES.register("decay_bubbles", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> SWAMP_GAS = PARTICLES.register("swamp_gas", () -> new SimpleParticleType(false));
}