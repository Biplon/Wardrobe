package wr.java.Listener;

import wr.java.GUI.WardrobeGUI;
import wr.java.Wardrobe;
import wr.java.Work.GUIWork;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class WardrobeListener implements Listener
{

    public Wardrobe plugin;
    public String Ver = Bukkit.getServer().getVersion();

    public WardrobeListener(Wardrobe plugin)
    {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e)
    {
        if (e.getView().getTitle().equals(WardrobeGUI.Page1Name) || e.getView().getTitle().equals(WardrobeGUI.Page2Name))
        {
            if (e.getCursor() != null && e.getCursor().hasItemMeta() &&  e.getCursor().getItemMeta().hasDisplayName() &&  e.getCursor().getItemMeta().getDisplayName().equals(" "))
            {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if (e.getView().getTitle().equals(WardrobeGUI.Page1Name) || e.getView().getTitle().equals(WardrobeGUI.Page2Name))
        {
            if (e.getClickedInventory() == null)
            {
                return;
            }
            if (e.getClickedInventory().getType() == InventoryType.PLAYER)
            {
                if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT)
                {
                    if (e.getCurrentItem() == null)
                    {
                        return;
                    }
                    Player p = (Player) e.getWhoClicked();
                    if (GUIWork.ShiftClick(e.getSlot(), e.getInventory(), p, e.getCurrentItem(), e.getView().getTitle()))
                    {
                        e.getClickedInventory().setItem(e.getSlot(), null);
                        p.updateInventory();
                    }
                }
                return;
            }
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getSlot() == Wardrobe.ConfigData.getConfig().getInt("Next-Page-Button.Slot") && Wardrobe.ConfigData.getConfig().getBoolean("Next-Page-Button.Enable") && !(e.getInventory().getItem(e.getSlot()).getType().toString().contains("STAINED_GLASS_PANE")))
            {
                if (e.getWhoClicked().getItemOnCursor() != null)
                {
                    e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getItemOnCursor().clone());
                    e.getWhoClicked().setItemOnCursor(null);
                }
                WardrobeGUI.CreateWardrobePage2(p);
            }
            if (e.getSlot() == Wardrobe.ConfigData.getConfig().getInt("Previous-Page-Button.Slot") && Wardrobe.ConfigData.getConfig().getBoolean("Previous-Page-Button.Enable") && !(e.getInventory().getItem(e.getSlot()).getType().toString().contains("STAINED_GLASS_PANE")))
            {
                if (e.getWhoClicked().getItemOnCursor() != null)
                {
                    e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getItemOnCursor().clone());
                    e.getWhoClicked().setItemOnCursor(null);
                }
                WardrobeGUI.CreateWardrobePage1(p);
            }
            if (e.getSlot() == Wardrobe.ConfigData.getConfig().getInt("Go-Back-Button.Slot") && Wardrobe.ConfigData.getConfig().getBoolean("Go-Back-Button.Enable") && !(e.getInventory().getItem(e.getSlot()).getType().toString().contains("STAINED_GLASS_PANE")))
            {
                if (e.getWhoClicked().getItemOnCursor() != null)
                {
                    e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getItemOnCursor().clone());
                    e.getWhoClicked().setItemOnCursor(null);
                }
                p.performCommand(Wardrobe.ConfigData.getConfig().getString("Go-Back-Button.Command"));
            }
            if (e.getSlot() == Wardrobe.ConfigData.getConfig().getInt("Close-Button.Slot") && Wardrobe.ConfigData.getConfig().getBoolean("Close-Button.Enable") && !(e.getInventory().getItem(e.getSlot()).getType().toString().contains("STAINED_GLASS_PANE")))
            {
                if (e.getWhoClicked().getItemOnCursor() != null)
                {
                    e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getItemOnCursor().clone());
                    e.getWhoClicked().setItemOnCursor(null);
                }
                p.closeInventory();
            }
            if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT)
            {
                ItemStack PresentButton = new ItemStack(Material.DIRT);
                if (e.getSlot() >= 0 && e.getSlot() <= 8)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 36);
                }
                else if (e.getSlot() >= 9 && e.getSlot() <= 17)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 27);
                }
                else if (e.getSlot() >= 18 && e.getSlot() <= 26)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 18);
                }
                else if (e.getSlot() >= 27 && e.getSlot() <= 35)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 9);
                }
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("RED_DYE") || ButtonCheck.contains("RED DYE"))
                {
                    p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
                    String sound = "";
                    if (Ver.contains("1.8"))
                    {
                        sound = "VILLAGER_NO";
                    }
                    if (Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12") || Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                    {
                        sound = "ENTITY_VILLAGER_NO";
                    }
                    p.playSound(p.getLocation(), Sound.valueOf(sound), 1.0f, 1.0f);
                    return;
                }
                GUIWork.ShiftClickInv(p, e.getInventory(), e.getSlot(), e.getView().getTitle());
            }
            else
            {
                ItemStack PresentButton = new ItemStack(Material.DIRT);
                if (e.getSlot() >= 0 && e.getSlot() <= 8)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 36);
                }
                else if (e.getSlot() >= 9 && e.getSlot() <= 17)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 27);
                }
                else if (e.getSlot() >= 18 && e.getSlot() <= 26)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 18);
                }
                else if (e.getSlot() >= 27 && e.getSlot() <= 35)
                {
                    PresentButton = e.getClickedInventory().getItem(e.getSlot() + 9);
                }
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("RED_DYE") || ButtonCheck.contains("RED DYE"))
                {
                    p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
                    String sound = "";
                    if (Ver.contains("1.8"))
                    {
                        sound = "VILLAGER_NO";
                    }
                    if (Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12") || Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                    {
                        sound = "ENTITY_VILLAGER_NO";
                    }
                    p.playSound(p.getLocation(), Sound.valueOf(sound), 1.0f, 1.0f);
                    return;
                }
                ItemStack ClickedItem = e.getCurrentItem();
                ItemStack ItemOnCursor = p.getItemOnCursor();
                GUIWork.SetAllowItem(e.getSlot(), e.getInventory(), p, ClickedItem, ItemOnCursor, e.getView().getTitle());
                p.updateInventory();
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClose(InventoryCloseEvent e)
    {
        if (e.getView().getTitle().equals(WardrobeGUI.Page1Name))
        {
            Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".name", e.getPlayer().getName());
            for (int i = 0; i <= 8; i++)
            {
                if (e.getInventory().getItem(i).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Helmet", "none");
                }
                else
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Helmet", e.getInventory().getItem(i));
                }
                if (e.getInventory().getItem(i + 9).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Chestplate", "none");
                }
                else
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Chestplate", e.getInventory().getItem(i + 9));
                }
                if (e.getInventory().getItem(i + 18).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Leggings", "none");
                }
                else
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Leggings", e.getInventory().getItem(i + 18));
                }
                if (e.getInventory().getItem(i + 27).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Boots", "none");
                }
                else
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Boots", e.getInventory().getItem(i + 27));
                }
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = e.getInventory().getItem(i + 36).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = e.getInventory().getItem(i + 36).getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Button", "Equipped");
                }
                else if (ButtonCheck.contains("GRAY_DYE") || ButtonCheck.contains("GRAY DYE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Button", "Empty");
                }
                else if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE"))
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Button", "Ready");
                }
                else
                {
                    Wardrobe.Page_1.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 1) + ".Button", "Locked");
                }
            }
            Wardrobe.Page_1.saveConfig();
            Wardrobe.Page_1.ReloadConfig();
        }
        else if (e.getView().getTitle().equals(WardrobeGUI.Page2Name))
        {
            Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".name", e.getPlayer().getName());
            for (int i = 0; i <= 8; i++)
            {
                if (e.getInventory().getItem(i).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Helmet", "none");
                }
                else
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Helmet", e.getInventory().getItem(i));
                }
                if (e.getInventory().getItem(i + 9).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Chestplate", "none");
                }
                else
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Chestplate", e.getInventory().getItem(i + 9));
                }
                if (e.getInventory().getItem(i + 18).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Leggings", "none");
                }
                else
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Leggings", e.getInventory().getItem(i + 18));
                }
                if (e.getInventory().getItem(i + 27).getType().toString().contains("STAINED_GLASS_PANE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Boots", "none");
                }
                else
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Boots", e.getInventory().getItem(i + 27));
                }
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = e.getInventory().getItem(i + 36).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = e.getInventory().getItem(i + 36).getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Button", "Equipped");
                }
                else if (ButtonCheck.contains("GRAY_DYE") || ButtonCheck.contains("GRAY DYE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Button", "Empty");
                }
                else if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE"))
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Button", "Ready");
                }
                else
                {
                    Wardrobe.Page_2.getConfig().set(e.getPlayer().getUniqueId() + ".Slot-" + (i + 10) + ".Button", "Locked");
                }
            }
            Wardrobe.Page_2.saveConfig();
            Wardrobe.Page_2.ReloadConfig();
        }
    }
}
