package org.imanity.example.handler;

import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.tablist.ImanityTabAdapter;
import org.imanity.framework.bukkit.tablist.util.BufferedTabObject;
import org.imanity.framework.bukkit.tablist.util.TabColumn;
import org.imanity.framework.bukkit.util.Skin;

import java.util.HashSet;
import java.util.Set;

public class ExampleTablistHandler implements ImanityTabAdapter {

    @Override
    public Set<BufferedTabObject> getSlots(Player player) {
        Set<BufferedTabObject> tabObjects = new HashSet<>();

        tabObjects.add(new BufferedTabObject().text("§dFirst column").column(TabColumn.LEFT));
        tabObjects.add(new BufferedTabObject().text("§5Second column").column(TabColumn.MIDDLE));
        tabObjects.add(new BufferedTabObject().text("You also can custom ping, skin...").ping(200).skin(Skin.fromPlayer(player)));

        return tabObjects;
    }

    @Override
    public String getFooter(Player player) {
        return "§b§lThis is a footer I guess";
    }

    @Override
    public String getHeader(Player player) {
        return "§6§lPLAY.YOURSERVER.COM\n§e§lHEY " + player.getName();
    }
}
