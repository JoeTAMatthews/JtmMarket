package com.jtm.market.entrypoint.commands;

import com.google.inject.Inject;
import com.jtm.api.core.entity.command.annotations.Command;
import com.jtm.api.core.entity.command.annotations.Usage;
import com.jtm.api.core.util.UtilString;
import com.jtm.api.data.manager.GuiManager;
import org.bukkit.entity.Player;

public class MarketCommands {

    private final GuiManager guiManager;

    @Inject
    public MarketCommands(GuiManager guiManager) {
        this.guiManager = guiManager;
    }

    @Command("market")
    @Usage("/market")
    public void onMarket(Player player) {
        guiManager.getGuiByName("market").open(player);
        player.sendMessage(UtilString.colour("&aOpening &bMarket &aMenu."));
    }
}
