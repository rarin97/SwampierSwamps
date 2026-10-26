package andrews.swampier_swamps.config.util;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConfigHelper {

    public static <T> T register(final ModConfig.Type configType, final BiFunction<ModConfigSpec.Builder, Subscriber, T> configBuilder, final String registerConfig) {
        return register(ModLoadingContext.get().getActiveContainer(), configType, configBuilder, registerConfig);
    }

    public static <T> T register(final ModContainer container, final ModConfig.Type configType, final BiFunction<ModConfigSpec.Builder, Subscriber, T> configBuilder, final String registerConfig) {
        final List<ConfigValueListener<?>> subscriptionList = new ArrayList<>();
        final Pair<T, ModConfigSpec> entry = new ModConfigSpec.Builder().configure(builder -> configBuilder.apply(builder, getSubscriber(subscriptionList)));
        final T config = entry.getLeft();
        final ModConfigSpec spec = entry.getRight();

        container.registerConfig(configType, spec, registerConfig);

        final Consumer<ModConfigEvent> configUpdate = event ->
        {
            if (event.getConfig().getSpec() == spec) {
                for (ConfigValueListener<?> value : subscriptionList) {
                    value.update();
                }
            }
        };
        container.getEventBus().addListener(configUpdate);
        return config;
    }

    private static Subscriber getSubscriber(final List<ConfigValueListener<?>> list) {
        return new Subscriber(list);
    }

    public static class Subscriber {
        final List<ConfigValueListener<?>> list;

        Subscriber(final List<ConfigValueListener<?>> list) {
            this.list = list;
        }

        public <T> ConfigValueListener subscribe(final ConfigValue<T> value) {
            return ConfigValueListener.of(value, this.list);
        }
    }

    public static class ConfigValueListener<T> implements Supplier<T> {
        private T value;
        private final ConfigValue<T> configValue;

        private ConfigValueListener(final ConfigValue<T> configValue) {
            this.configValue = configValue;
            this.value = configValue.getDefault();
        }

        public static <T> ConfigValueListener<T> of(final ConfigValue<T> configValue, final List<ConfigValueListener<?>> valueList) {
            final ConfigValueListener<T> value = new ConfigValueListener<>(configValue);
            valueList.add(value);
            return value;
        }

        public void update() {
            this.value = this.configValue.get();
        }

        @Override
        public T get() {
            return this.value;
        }
    }
}
