package com.jtm.market.core.usecase.repository.marketitem;

import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import com.jtm.api.core.entity.database.Database;
import com.jtm.api.core.usecase.repository.ConfigRepository;
import com.jtm.api.core.util.Logging;
import com.jtm.market.core.domain.MarketItem;

import java.util.Map;

public class MarketItemConfigRepository extends ConfigRepository<MarketItem, String> {

    @Inject
    public MarketItemConfigRepository(Logging logging, Database database, Map<Class<?>, JsonSerializer<?>> jsonSerializerMap) {
        super(MarketItem.class, logging, database, "market_items", jsonSerializerMap);
    }
}
