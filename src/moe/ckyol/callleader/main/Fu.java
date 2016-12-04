package moe.ckyol.callleader.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Fu implements CommandExecutor {
    private final PluginMain plugin;
    private String cheerWord="ふふ";

    public Fu (PluginMain plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        if (plugin.isLeader(player.getUniqueId())){
                Bukkit.broadcastMessage(cheerWord);
        }
        else player.sendMessage(cheerWord);

        return true;
    }
}
