package moe.ckyol.callleader.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.UUID;

public class Call implements CommandExecutor {

    private final PluginMain plugin;

    public Call (PluginMain plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        if(args.length==0){
            sender.sendMessage("応援の命令：");
            sender.sendMessage("/call leader:コールリーダーになる");
            sender.sendMessage("/call end:ライブが終わった後、コールリーダーを解く");
            sender.sendMessage("/hi [数]:はい");
            sender.sendMessage("/fu :ふふ");
            sender.sendMessage("/fw [数]:ふわふわ");
            sender.sendMessage("/kh :GT 警報");
            sender.sendMessage("/ph [数]:PPPH");
            return true;
        }
        else if(args.length==1 ) {
            if (args[0].equals("leader")) {
                if (!plugin.hasLeader()) {
                    UUID id = player.getUniqueId();
                    plugin.setId(id);
                    sender.sendMessage("コールリーダーになった");
                } else {
                    sender.sendMessage("すみません、コールリーダーがいった");
                }
                return true;
            }

            if(args[0].equals("end")) {
                plugin.setId(null);
                sender.sendMessage("終わった");
                return true;
            }

        }
        return false;
    }
}
