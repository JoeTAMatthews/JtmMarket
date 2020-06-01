package com.jtm.market.core.domain;

import com.jtm.api.core.entity.database.BaseEntity;
import com.jtm.api.core.util.ItemStackBuilder;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

@Data
public class MarketItem extends BaseEntity<String> {

    private String material;
    private transient ItemStack item;

    public MarketItem(ItemStack itemStack) {
        super(UUID.randomUUID().toString());
        this.material = itemStack.getType().name();
        this.item = itemStack;
    }

    public Material getMaterial() {
        return Material.valueOf(material);
    }

    public ItemStack getItemStack() {
        return new ItemStackBuilder(Material.valueOf(material.toUpperCase())).build();
    }
}
