package com.jtm.market.data.manager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jtm.market.core.domain.MarketItem;
import com.jtm.market.data.service.MarketService;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@Getter
@Singleton
public class MarketManager {

    private final Map<String, MarketItem> items = new HashMap<>();
    private final MarketService marketService;

    @Inject
    public MarketManager(MarketService marketService) {
        this.marketService = marketService;
    }

    public MarketItem addMarketItem(ItemStack itemStack) {
        MarketItem marketItem = new MarketItem(itemStack);
        return  items.put(marketItem.getId(), marketItem);
    }

    public MarketItem getMarketItem(String id) {
        return items.get(id);
    }

    public MarketItem removeMarketItem(String id) {
        return items.remove(id);
    }
}
