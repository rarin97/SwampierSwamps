package andrews.swampier_swamps.network.client;

import andrews.swampier_swamps.SwampierSwamps;
import andrews.swampier_swamps.network.client.util.ClientPacketHandlerClass;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageClientGasExplosionParticles(BlockPos pos) implements CustomPacketPayload {
    public static final Type<MessageClientGasExplosionParticles> TYPE = new Type<>(SwampierSwamps.asResource("gas_explosion_particles"));

    public static final StreamCodec<FriendlyByteBuf, MessageClientGasExplosionParticles> STREAM_CODEC =
            StreamCodec.composite(BlockPos.STREAM_CODEC, MessageClientGasExplosionParticles::pos, MessageClientGasExplosionParticles::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageClientGasExplosionParticles message, IPayloadContext context) {
        context.enqueueWork(() -> ClientPacketHandlerClass.handleSpawnGasExplosionParticles(message));
    }
}