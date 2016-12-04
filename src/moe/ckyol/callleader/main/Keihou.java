package moe.ckyol.callleader.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Keihou implements CommandExecutor{
    private final PluginMain plugin;
    private String[] cheerWord={"せーの","はーい","はーい","はいはいはいはい"};

    public Keihou (PluginMain plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        for (int i=0;i<cheerWord.length;i++){
            if (plugin.isLeader(player.getUniqueId())){
                Bukkit.broadcastMessage(cheerWord[i]);
            }
            else player.sendMessage(cheerWord[i]);
        }
        return true;


    }
}
