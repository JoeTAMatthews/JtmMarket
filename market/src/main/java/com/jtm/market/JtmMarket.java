package com.jtm.market;

import com.jtm.api.core.util.ItemStackBuilder;
import com.jtm.api.entrypoint.plugin.JtmPlugin;
import com.jtm.market.core.domain.MarketItem;
import com.jtm.market.data.service.MarketService;
import com.jtm.market.entrypoint.commands.MarketCommands;
import com.jtm.market.entrypoint.menu.MarketMenu;
import com.jtm.market.entrypoint.module.MarketModule;
import org.bukkit.Material;

/**
 * GUI Based Market system.
 * Purpose:
 * - Allow users/players to sell & buy items from a global market through a gui
 * - Have a back log of purchased & sold items
 * - GUI Based functionality for selling items on the market
 *
 */
public class JtmMarket extends JtmPlugin {

    @Override
    public void enable() {
        registerModules(new MarketModule());

        registerMenu(getChildInjector().getInstance(MarketMenu.class));
        registerCommands(getChildInjector().getInstance(MarketCommands.class), "market");

        getChildInjector().getInstance(MarketService.class).insert(new MarketItem(new ItemStackBuilder(Material.DIAMOND).withName("&aTest").build()));
    }

    @Override
    public void disable() {

    }
}
