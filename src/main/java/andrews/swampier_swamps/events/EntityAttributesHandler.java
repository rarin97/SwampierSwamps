package andrews.swampier_swamps.events;

import andrews.swampier_swamps.entities.Dragonfly;
import andrews.swampier_swamps.registry.SSEntities;
import andrews.swampier_swamps.util.Reference;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Reference.MODID)
public class EntityAttributesHandler {
    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(SSEntities.DRAGONFLY.get(), Dragonfly.createAttributes().build());
    }
}
