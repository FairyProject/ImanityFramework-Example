package org.imanity.example.handler;

import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.tablist.ImanityTabAdapter;
import org.imanity.framework.bukkit.tablist.util.BufferedTabObject;

import java.util.Set;

public class ExampleTablistHandler implements ImanityTabAdapter {

    @Override
    public Set<BufferedTabObject> getSlots(Player player) {
        return null;
    }

    @Override
    public String getFooter(Player player) {
        return null;
    }

    @Override
    public String getHeader(Player player) {
        return null;
    }
}
