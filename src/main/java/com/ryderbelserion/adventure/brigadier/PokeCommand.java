package com.ryderbelserion.adventure.brigadier;

import com.destroystokyo.paper.ClientOption;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import net.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Locale;

public class PokeCommand implements BasicCommand {

    @Override
    public void execute(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        Player player = (Player) stack.getSender();

        final String locale = player.getClientOption(ClientOption.LOCALE);

        TranslatableComponent component = Component.translatable("get.poked", NamedTextColor.BLUE);

        JSONComponentSerializer.json().serialize(component);

        //final Component component = GlobalTranslator.render(Component.translatable("get.poked", MiniMessage.miniMessage().deserialize(args[0])), Locale.of(locale));

        player.sendMessage(component);
    }
}