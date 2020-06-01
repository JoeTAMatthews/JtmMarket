package com.jtm.market.entrypoint.commands;

import com.jtm.api.core.entity.gui.GuiInventory;
import com.jtm.api.data.manager.GuiManager;
import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;

@RunWith(PowerMockRunner.class)
public class MarketCommandsTest {

    private GuiManager guiManager;
    private MarketCommands marketCommands;

    private Player player;

    @Before
    public void setUp() {
        guiManager = mock(GuiManager.class);
        marketCommands = new MarketCommands(guiManager);

        player = PowerMockito.mock(Player.class);
    }

    @Test
    public void onMarketTest() {
        GuiInventory guiInventory = mock(GuiInventory.class);
        when(guiManager.getGuiByName(anyString())).thenReturn(guiInventory);

        marketCommands.onMarket(player);

        verify(guiManager, times(1)).getGuiByName(anyString());
        verify(guiInventory, times(1)).open(player);
        verifyNoMoreInteractions(guiInventory);

        verify(player, times(1)).sendMessage(anyString());
        verifyNoMoreInteractions(player);
    }
}
