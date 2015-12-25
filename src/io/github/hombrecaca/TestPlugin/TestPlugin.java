/*
 	Test Plugin for Spigot
    Copyright (C) 2015  Guillem Castro

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

 */


package io.github.hombrecaca.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class TestPlugin extends JavaPlugin {
	String plugin_name = "TestPlugin";
    @Override
    public void onEnable() {
        getLogger().info(plugin_name + " loaded");
    }
    
    @Override
    public void onDisable() {
       getLogger().info(plugin_name + " disabled"); 
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("suicidar")) {
            if (!(sender instanceof Player) && args.length != 1) {
                sender.sendMessage("Este comando solo puede ser ejecutado por un jugador");
                return true;
            }
            else if (args.length != 1){
                ((Damageable) sender).setHealth(0);
                Bukkit.getServer().broadcastMessage(sender.getName() + " se suicidó");
                return true;
            }
            else if (args.length == 1){
            	Player target = Bukkit.getServer().getPlayer(args[0]);
            	if (target == null) sender.sendMessage(args[0] + " no esta conectado!");
            	else {
            		target.setHealth(0);
            		Bukkit.getServer().broadcastMessage(target.getName() + " se suicidó");
            	}
            	return true;
            }
        }
		return false;
    }
}
