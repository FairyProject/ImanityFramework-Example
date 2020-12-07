package org.imanity.example.handler;

import org.bukkit.ChatColor;
import org.imanity.example.timer.ExampleTimer;
import org.imanity.framework.Autowired;
import org.imanity.framework.bukkit.bossbar.BossBar;
import org.imanity.framework.bukkit.bossbar.BossBarAdapter;
import org.imanity.framework.bukkit.bossbar.BossBarData;
import org.imanity.framework.bukkit.timer.TimerHandler;
import org.imanity.framework.util.FormatUtil;

public class ExampleBossBarHandler implements BossBarAdapter {

    /**
     *
     * The Autowired Annotation, it will automatically inject bean into the marked field
     * For example in this case, I want to get the TimerHandler instance, so we put the TimerHandler variable
     * While it start up, the TimerHandler instance will be automatically injected and you can use it
     *
     */
    @Autowired
    private TimerHandler timerHandler;

    /**
     *
     * This will be called basically when the boss bar is updated
     *
     */
    @Override
    public BossBarData tick(BossBar bossBar) {
        ExampleTimer exampleTimer = this.timerHandler.getTimer(ExampleTimer.class);

        if (exampleTimer == null) {
            return null;
        }

        long time = exampleTimer.timeRemaining();
        return new BossBarData(ChatColor.GOLD + "You will be dead in " + FormatUtil.formatToSecondsAndMinutes(exampleTimer.secondsRemaining()) + "!", time > 0 ? (time / (float) ExampleTimer.EXAMPLE_TIME) * 100.0F : 0);
    }
}
