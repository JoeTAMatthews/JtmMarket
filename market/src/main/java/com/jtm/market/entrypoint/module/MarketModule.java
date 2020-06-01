package com.jtm.market.entrypoint.module;

import com.google.inject.AbstractModule;
import com.jtm.api.core.entity.repository.Repository;
import com.jtm.api.core.entity.service.Service;
import com.jtm.market.core.usecase.repository.marketitem.MarketItemConfigRepository;
import com.jtm.market.data.manager.MarketManager;
import com.jtm.market.data.service.MarketService;
import com.jtm.market.entrypoint.commands.MarketCommands;
import com.jtm.market.entrypoint.menu.MarketMenu;

public class MarketModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MarketManager.class);
        bind(MarketMenu.class);
        bind(MarketCommands.class);

        bind(Repository.class).to(MarketItemConfigRepository.class);
        bind(Service.class).to(MarketService.class);
    }
}
