package com.jtm.market.entrypoint.menu;

import com.google.inject.Inject;
import com.jtm.api.core.entity.gui.GuiItem;
import com.jtm.api.core.util.ItemStackBuilder;
import com.jtm.market.core.domain.MarketItem;
import com.jtm.market.core.usecase.gui.MarketInventory;
import com.jtm.market.data.manager.MarketManager;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MarketMenu extends MarketInventory {

    private final MarketManager marketManager;

    @Inject
    public MarketMenu(MarketManager marketManager) {
        super("market", 54, "&bGlobal Market");
        this.marketManager = marketManager;
    }

    @Override
    public void registerItems() {
//        for (int i = 0; i < 100; i++) {
//            addItem(new GuiItem("&eTest #" + i, new ItemStackBuilder(Material.DIAMOND_AXE).addLore("$1000").build()));
//        }

        for (MarketItem marketItem : marketManager.getMarketService().findAll()) {
            addItem(new GuiItem("test", "&bTest", marketItem.getMaterial(), "&6Test lore", "", "&eTesting..."));
            System.out.println(marketItem.getMaterial());
        }
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {

    }
}
