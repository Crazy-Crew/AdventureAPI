package com.ryderbelserion.adventure;

import com.ryderbelserion.adventure.brigadier.PokeCommand;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import net.kyori.adventure.util.UTF8ResourceBundleControl;
import org.jetbrains.annotations.NotNull;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdventureStrap implements PluginBootstrap {

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        registerTranslations();

        final LifecycleEventManager<BootstrapContext> manager = context.getLifecycleManager();

        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();

            commands.register("poke", "A poke command", new PokeCommand());
        });
    }

    public void registerTranslations() {
        TranslationRegistry registry = TranslationRegistry.create(Key.key("crazycrew", "translations"));

        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.US, UTF8ResourceBundleControl.get());

        registry.registerAll(Locale.US, bundle, true);

        GlobalTranslator.translator().addSource(registry);
    }
}