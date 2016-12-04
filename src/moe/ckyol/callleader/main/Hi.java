package moe.ckyol.callleader.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Hi implements CommandExecutor {
    private final PluginMain plugin;
    private String cheerWord="はい";

    public Hi (PluginMain plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        if(args.length==1){
            try {
                int hiNum = Integer.parseInt(args[0]);
                for (int i = 0; i < hiNum; i++) {
                    if (plugin.isLeader(player.getUniqueId())){
                        Bukkit.broadcastMessage(cheerWord);
                    }
                    else player.sendMessage(cheerWord);
                }
            }
            catch (NumberFormatException e){
                player.sendMessage("Not number");
            }
            return true;
        }
        return false;
    }
}
