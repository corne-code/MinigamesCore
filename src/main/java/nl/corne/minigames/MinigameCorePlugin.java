package nl.corne.minigames;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MinigameCorePlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("games").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory menu = Bukkit.createInventory(null, 9, "Minigame Selection Menu");

            ItemStack blockHunt = new ItemStack(Material.OAK_LOG);
            ItemMeta m1 = blockHunt.getItemMeta();
            m1.setDisplayName("BlockHunt (Hide and Seek)");
            blockHunt.setItemMeta(m1);

            ItemStack parkour = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta m2 = parkour.getItemMeta();
            m2.setDisplayName("Lobby Parkour Challenge");
            parkour.setItemMeta(m2);

            ItemStack spleef = new ItemStack(Material.IRON_SHOVEL);
            ItemMeta m3 = spleef.getItemMeta();
            m3.setDisplayName("Spleef Arena Fight");
            spleef.setItemMeta(m3);

            menu.setItem(2, blockHunt);
            menu.setItem(4, parkour);
            menu.setItem(6, spleef);

            player.openInventory(menu);
        }
        return true;
    }
}
