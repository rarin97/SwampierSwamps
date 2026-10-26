package andrews.swampier_swamps.network;

import andrews.swampier_swamps.network.client.MessageClientGasExplosionParticles;
import andrews.swampier_swamps.network.client.MessageClientSplashParticles;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class SSNetwork {

    public static final String NETWORK_PROTOCOL = "1";

    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(NETWORK_PROTOCOL);

        registrar.playToClient(MessageClientSplashParticles.TYPE, MessageClientSplashParticles.STREAM_CODEC, MessageClientSplashParticles::handle);
        registrar.playToClient(MessageClientGasExplosionParticles.TYPE, MessageClientGasExplosionParticles.STREAM_CODEC, MessageClientGasExplosionParticles::handle);

    }
}