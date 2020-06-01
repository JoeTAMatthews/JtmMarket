package com.jtm.market.core.usecase.gui;

import com.jtm.api.core.entity.gui.GuiHolder;
import com.jtm.api.core.entity.gui.GuiInventory;
import com.jtm.api.core.entity.gui.GuiItem;
import com.jtm.api.core.util.ItemStackBuilder;
import com.jtm.api.core.util.UtilString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import java.util.Collections;
import java.util.List;

public class MarketInventory extends GuiInventory {

    public MarketInventory(String name, int size, String displayName) {
        super(name, size, displayName, true, false);
    }

    @Override
    public void initInventory() {
        int neededPages = Math.round((float) getItems().size() / (getSize() - 14));

        if (neededPages == 0) neededPages = 1;

        for (int i = 0; i < neededPages; i++)  this.getInventories().add(Bukkit.createInventory(new GuiHolder(getUuid(), i), getSize(), UtilString.colour(getDisplayName())));

        for (int i = 0; i < getInventories().size(); i++) {
            int page = i + 1;
            Inventory inventory = getInventories().get(i);

            registerSettings(inventory);

            for (GuiItem guiItem : getPage(page)) inventory.addItem(guiItem.getItemStack());

            for (int z = inventory.getSize() - 9; z < inventory.getSize(); z++) {
                switch (z) {
                    case 47:
                        if (page > 1)
                            inventory.setItem(z, new ItemStackBuilder(Material.REDSTONE_BLOCK).withName("&cPrevious Page").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
                        break;
                    case 51:
                        if (getInventories().size() > page)
                            inventory.setItem(z, new ItemStackBuilder(Material.EMERALD_BLOCK).withName("&cNext Page").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
                        break;
                }

                if (inventory.getItem(z) == null)
                    inventory.setItem(z, new ItemStackBuilder(Material.GLASS_PANE).withName(" ").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
            }
        }
    }

    @Override
    public void registerItems() {

    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {

    }

    @Override
    public void sortInventories() {
        for (int i = 0; i < getInventories().size(); i++) {
            int page = i + 1;
            Inventory inventory = getInventories().get(i);
            inventory.clear();

            registerSettings(inventory);

            for (GuiItem guiItem : getPage(page)) inventory.addItem(guiItem.getItemStack());

            for (int z = inventory.getSize() - 9; z < inventory.getSize(); z++) {
                switch (z) {
                    case 47:
                        if (page > 1)
                            inventory.setItem(z, new ItemStackBuilder(Material.REDSTONE_BLOCK).withName("&cPrevious Page").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
                        break;
                    case 51:
                        if (getInventories().size() > page)
                            inventory.setItem(z, new ItemStackBuilder(Material.EMERALD_BLOCK).withName("&cNext Page").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
                        break;
                }

                if (inventory.getItem(z) == null)
                    inventory.setItem(z, new ItemStackBuilder(Material.GLASS_PANE).withName(" ").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
            }
        }
    }

    private void registerSettings(Inventory inventory) {
        int[] slots = new int[]{0, 9, 18, 27, 36};
        int rows = (getSize() / 9) - 1;

        for (int i = 0; i < rows; i++) {
            switch (i) {
                case 0:
                    inventory.setItem(slots[i], new ItemStackBuilder(Material.CHEST).withName("&aFilters").build());
                    break;
                case 1:
                    inventory.setItem(slots[i], new ItemStackBuilder(Material.ENDER_CHEST).withName("&bItem Mail").build());
                    break;
                case 2:
                    inventory.setItem(slots[i], new ItemStackBuilder(Material.BOOK).withName("&e&lMarket Help").build());
                    break;
                case 3:
                    inventory.setItem(slots[i], new ItemStackBuilder(Material.DIAMOND).withName("&6Selling items").build());
                    break;
                case 4:
                    inventory.setItem(slots[i], new ItemStackBuilder(Material.BLACK_CONCRETE).withName("&bBidding&f|&cSelling&f|&aBuying&f|&eAll").build());
                    break;
            }
        }
    }

    @Override
    public List<GuiItem> getPage(int page) {
        if (page <= 0) throw new IllegalArgumentException("Invalid page number: " + page);

        int fromIndex = (page - 1) * (getSize() - 14);
        if (getItems() == null || getItems().size() < fromIndex) return Collections.emptyList();

        return getItems().subList(fromIndex, Math.min(fromIndex + (getSize() - 14), getItems().size()));
    }
}
