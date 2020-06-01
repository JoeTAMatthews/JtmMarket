package com.jtm.market.data.service;

import com.google.inject.Inject;
import com.jtm.api.core.entity.repository.Repository;
import com.jtm.api.core.usecase.service.ServiceImpl;
import com.jtm.api.data.manager.DatabaseManager;
import com.jtm.market.core.domain.MarketItem;

public class MarketService extends ServiceImpl<MarketItem, String> {

    @Inject
    public MarketService(DatabaseManager databaseManager, Repository configRepository) {
        super(databaseManager, configRepository, null, null);
    }
}
