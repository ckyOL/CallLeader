package moe.ckyol.callleader.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;


public class PluginMain extends JavaPlugin {
    private UUID leader;

    public boolean hasLeader(){
        if (leader!=null){
            return true;
        }
        return false;
    }

    public void setId(UUID id){
        leader=id;
    }

    public boolean isLeader(UUID id){
        if (leader==id){
            return true;
        }
        else return false;
    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("plugin open");
        this.getCommand("call").setExecutor(new Call(this));
        this.getCommand("ph").setExecutor(new PPPH(this));
        this.getCommand("kh").setExecutor(new Keihou(this));
        this.getCommand("fu").setExecutor(new Fu(this));
        this.getCommand("fw").setExecutor(new Fuwa(this));
        this.getCommand("hi").setExecutor(new Hi(this));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("plugin close");
    }


}
