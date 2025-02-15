package wr.java.Work;

import org.bukkit.configuration.file.FileConfiguration;
import wr.java.GUI.WardrobeGUI;
import wr.java.Wardrobe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GUIWork
{

    public static String Ver = Bukkit.getServer().getVersion();

    @SuppressWarnings("deprecation")
    public static boolean ShiftClick(int ClickedSlot, Inventory inv, Player p, ItemStack ClickedItem, String Title)
    {
        for (int i = 0; i <= 53; i++)
        {
            ItemStack CheckBackground = inv.getItem(i);
            String CheckBackgroundType = CheckBackground.getType().toString();
            String ClickedItemType = ClickedItem.getType().toString();
            List<String> ClickedItemLore = new ArrayList<String>();
            if (ClickedItem != null && ClickedItem.getItemMeta() != null)
            {
                ClickedItemLore = ClickedItem.getItemMeta().getLore();
            }
            if (i >= 0 && i <= 8)
            {
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = inv.getItem(i + 36).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = inv.getItem(i + 36).getType().toString();
                }
				if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
				{
					continue;
				}
            }
            else if (i >= 9 && i <= 17)
            {
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = inv.getItem(i + 27).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = inv.getItem(i + 27).getType().toString();
                }
				if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
				{
					continue;
				}
            }
            else if (i >= 18 && i <= 26)
            {
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = inv.getItem(i + 18).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = inv.getItem(i + 18).getType().toString();
                }
				if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
				{
					continue;
				}
            }
            else if (i >= 27 && i <= 35)
            {
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = inv.getItem(i + 9).getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = inv.getItem(i + 9).getType().toString();
                }
				if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
				{
					continue;
				}
            }
            if (CheckBackgroundType.contains("STAINED_GLASS_PANE") && !(CheckBackgroundType.contains("STAINED_GLASS_PANE(15)")) && !(CheckBackgroundType.contains("BLACK_STAINED_GLASS_PANE")))
            {
                if (i >= 0 && i <= 8)
                {
                    if (ClickedItemType.contains("_HELMET"))
                    {
                        inv.setItem(i, ClickedItem);
                        inv.setItem(i + 36, WardrobeGUI.CreateReadyButton(i, inv, Title));
                        return true;
                    }
                    else
                    {
                        if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
                        {
                            if (ClickedItemLore != null)
                            {
                                for (int j = 0; j < ClickedItemLore.size(); j++)
                                {
                                    if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Specific-Check-Lore")))
                                    {
                                        inv.setItem(i, ClickedItem);
                                        inv.setItem(i + 36, WardrobeGUI.CreateReadyButton(i, inv, Title));
                                        return true;
                                    }
                                }
                            }
                        }
                        if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore").equalsIgnoreCase("none"))
                        {
                            continue;
                        }
                        int CheckAmount = 0;
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name").equalsIgnoreCase("none")))
						{
							if (ClickedItem.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name"))))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore").equalsIgnoreCase("none")))
						{
							if (ClickedItemLore != null)
							{
								for (int j = 0; j < ClickedItemLore.size(); j++)
								{
									if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore")))
									{
										CheckAmount++;
									}
								}
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").equalsIgnoreCase("none")))
						{
							if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").contains(ClickedItemType)))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
                        if (CheckAmount == 3)
                        {
                            inv.setItem(i, ClickedItem);
                            inv.setItem(i + 36, WardrobeGUI.CreateReadyButton(i, inv, Title));
                            return true;
                        }
                    }
                }
                else if (i >= 9 && i <= 17)
                {
                    if (ClickedItemType.contains("_CHESTPLATE"))
                    {
                        inv.setItem(i, ClickedItem);
                        inv.setItem(i + 27, WardrobeGUI.CreateReadyButton(i - 9, inv, Title));
                        return true;
                    }
                    else
                    {
                        if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
                        {
                            if (ClickedItemLore != null)
                            {
                                for (int j = 0; j < ClickedItemLore.size(); j++)
                                {
                                    if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Specific-Check-Lore")))
                                    {
                                        inv.setItem(i, ClickedItem);
                                        inv.setItem(i + 27, WardrobeGUI.CreateReadyButton(i - 9, inv, Title));
                                        return true;
                                    }
                                }
                            }
                        }
                        if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore").equalsIgnoreCase("none"))
                        {
                            continue;
                        }
                        int CheckAmount = 0;
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name").equalsIgnoreCase("none")))
						{
							if (ClickedItem.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name"))))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore").equalsIgnoreCase("none")))
						{
							if (ClickedItemLore != null)
							{
								for (int j = 0; j < ClickedItemLore.size(); j++)
								{
									if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore")))
									{
										CheckAmount++;
									}
								}
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").equalsIgnoreCase("none")))
						{
							if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").contains(ClickedItemType)))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
                        if (CheckAmount == 3)
                        {
                            inv.setItem(i, ClickedItem);
                            inv.setItem(i + 27, WardrobeGUI.CreateReadyButton(i - 9, inv, Title));
                            return true;
                        }
                    }
                }
                else if (i >= 18 && i <= 26)
                {
                    if (ClickedItemType.contains("_LEGGINGS"))
                    {
                        inv.setItem(i, ClickedItem);
                        inv.setItem(i + 18, WardrobeGUI.CreateReadyButton(i - 18, inv, Title));
                        return true;
                    }
                    else
                    {
                        if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
                        {
                            if (ClickedItemLore != null)
                            {
                                for (int j = 0; j < ClickedItemLore.size(); j++)
                                {
                                    if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Specific-Check-Lore")))
                                    {
                                        inv.setItem(i, ClickedItem);
                                        inv.setItem(i + 18, WardrobeGUI.CreateReadyButton(i - 18, inv, Title));
                                        return true;
                                    }
                                }
                            }
                        }
                        if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore").equalsIgnoreCase("none"))
                        {
                            continue;
                        }
                        int CheckAmount = 0;
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name").equalsIgnoreCase("none")))
						{
							if (ClickedItem.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name"))))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore").equalsIgnoreCase("none")))
						{
							if (ClickedItemLore != null)
							{
								for (int j = 0; j < ClickedItemLore.size(); j++)
								{
									if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore")))
									{
										CheckAmount++;
									}
								}
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").equalsIgnoreCase("none")))
						{
							if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").contains(ClickedItemType)))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
                        if (CheckAmount == 3)
                        {
                            inv.setItem(i, ClickedItem);
                            inv.setItem(i + 18, WardrobeGUI.CreateReadyButton(i - 18, inv, Title));
                            return true;
                        }
                    }
                }
                else if (i >= 27 && i <= 35)
                {
                    if (ClickedItemType.contains("_BOOTS"))
                    {
                        inv.setItem(i, ClickedItem);
                        inv.setItem(i + 9, WardrobeGUI.CreateReadyButton(i - 27, inv, Title));
                        return true;
                    }
                    else
                    {
                        if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
                        {
                            if (ClickedItemLore != null)
                            {
                                for (int j = 0; j < ClickedItemLore.size(); j++)
                                {
                                    if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Specific-Check-Lore")))
                                    {
                                        inv.setItem(i, ClickedItem);
                                        inv.setItem(i + 9, WardrobeGUI.CreateReadyButton(i - 27, inv, Title));
                                        return true;
                                    }
                                }
                            }
                        }
                        if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").equalsIgnoreCase("none") &&
                                Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore").equalsIgnoreCase("none"))
                        {
                            continue;
                        }
                        int CheckAmount = 0;
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name").equalsIgnoreCase("none")))
						{
							if (ClickedItem.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name"))))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore").equalsIgnoreCase("none")))
						{
							if (ClickedItemLore != null)
							{
								for (int j = 0; j < ClickedItemLore.size(); j++)
								{
									if (ClickedItemLore.get(j).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore")))
									{
										CheckAmount++;
									}
								}
							}
						}
						else
						{
							CheckAmount++;
						}
						if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").equalsIgnoreCase("none")))
						{
							if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").contains(ClickedItemType)))
							{
								CheckAmount++;
							}
						}
						else
						{
							CheckAmount++;
						}
                        if (CheckAmount == 3)
                        {
                            inv.setItem(i, ClickedItem);
                            inv.setItem(i + 9, WardrobeGUI.CreateReadyButton(i - 27, inv, Title));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public static void SetAllowItem(int ClickedSlot, Inventory inv, Player p, ItemStack ClickedItem, ItemStack ItemOnCursor, String Title)
    {
        String ClickedItemType = ClickedItem.getType().toString();
        String ItemOnCursorType = ItemOnCursor.getType().toString();
        List<String> ItemOnCursorLore = new ArrayList<String>();
        if (ItemOnCursor != null && ItemOnCursor.getItemMeta() != null)
        {
            ItemOnCursorLore = ItemOnCursor.getItemMeta().getLore();
        }
        if (ClickedSlot >= 0 && ClickedSlot <= 8)
        {
            if (ClickedItemType.contains("STAINED_GLASS_PANE") && !(ClickedItemType.contains("STAINED_GLASS_PANE(15)")) && !(ClickedItemType.contains("BLACK_STAINED_GLASS_PANE")))
            {
                if (ItemOnCursor != null)
                {
                    if (CheckHelmet(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                    {
                        inv.setItem(ClickedSlot, ItemOnCursor);
                        p.setItemOnCursor(null);
                        return;
                    }
                }
            }
            else
            {
                ItemStack PresentButton = inv.getItem(ClickedSlot + 36);
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
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
                if (CheckHelmet(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                {
                    inv.setItem(ClickedSlot, ItemOnCursor);
                    p.setItemOnCursor(ClickedItem);
                    return;
                }
                else
                {
                    p.setItemOnCursor(ClickedItem);
                    inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
                    String CheckSlot1 = inv.getItem(ClickedSlot).getType().toString();
                    String CheckSlot2 = inv.getItem(ClickedSlot + 9).getType().toString();
                    String CheckSlot3 = inv.getItem(ClickedSlot + 18).getType().toString();
                    String CheckSlot4 = inv.getItem(ClickedSlot + 27).getType().toString();
                    if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                    {
                        inv.setItem(ClickedSlot + 36, WardrobeGUI.CreateEmptyButton(ClickedSlot, inv, Title));
                    }
                    return;
                }
            }
        }
        else if (ClickedSlot >= 9 && ClickedSlot <= 17)
        {
            if (ClickedItemType.contains("STAINED_GLASS_PANE") && !(ClickedItemType.contains("STAINED_GLASS_PANE(15)")) && !(ClickedItemType.contains("BLACK_STAINED_GLASS_PANE")))
            {
                if (ItemOnCursor != null)
                {
                    if (CheckChestplate(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                    {
                        inv.setItem(ClickedSlot, ItemOnCursor);
                        p.setItemOnCursor(null);
                        return;
                    }
                }
            }
            else
            {
                ItemStack PresentButton = inv.getItem(ClickedSlot + 27);
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
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
                if (CheckChestplate(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                {
                    inv.setItem(ClickedSlot, ItemOnCursor);
                    p.setItemOnCursor(ClickedItem);
                    return;
                }
                else
                {
                    p.setItemOnCursor(ClickedItem);
                    inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
                    String CheckSlot1 = inv.getItem(ClickedSlot - 9).getType().toString();
                    String CheckSlot2 = inv.getItem(ClickedSlot).getType().toString();
                    String CheckSlot3 = inv.getItem(ClickedSlot + 9).getType().toString();
                    String CheckSlot4 = inv.getItem(ClickedSlot + 18).getType().toString();
                    if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                    {
                        inv.setItem(ClickedSlot + 27, WardrobeGUI.CreateEmptyButton(ClickedSlot - 9, inv, Title));
                    }
                    return;
                }
            }
        }
        else if (ClickedSlot >= 18 && ClickedSlot <= 26)
        {
            if (ClickedItemType.contains("STAINED_GLASS_PANE") && !(ClickedItemType.contains("STAINED_GLASS_PANE(15)")) && !(ClickedItemType.contains("BLACK_STAINED_GLASS_PANE")))
            {
                if (ItemOnCursor != null)
                {
                    if (CheckLeggings(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                    {
                        inv.setItem(ClickedSlot, ItemOnCursor);
                        p.setItemOnCursor(null);
                        return;
                    }
                }
            }
            else
            {
                ItemStack PresentButton = inv.getItem(ClickedSlot + 18);
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
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
                if (CheckLeggings(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                {
                    inv.setItem(ClickedSlot, ItemOnCursor);
                    p.setItemOnCursor(ClickedItem);
                    return;
                }
                else
                {
                    p.setItemOnCursor(ClickedItem);
                    inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
                    String CheckSlot1 = inv.getItem(ClickedSlot - 18).getType().toString();
                    String CheckSlot2 = inv.getItem(ClickedSlot - 9).getType().toString();
                    String CheckSlot3 = inv.getItem(ClickedSlot).getType().toString();
                    String CheckSlot4 = inv.getItem(ClickedSlot + 9).getType().toString();
                    if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                    {
                        inv.setItem(ClickedSlot + 18, WardrobeGUI.CreateEmptyButton(ClickedSlot - 18, inv, Title));
                    }
                    return;
                }
            }
        }
        else if (ClickedSlot >= 27 && ClickedSlot <= 35)
        {
            if (ClickedItemType.contains("STAINED_GLASS_PANE") && !(ClickedItemType.contains("STAINED_GLASS_PANE(15)")) && !(ClickedItemType.contains("BLACK_STAINED_GLASS_PANE")))
            {
                if (ItemOnCursor != null)
                {
                    if (CheckBoots(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                    {
                        inv.setItem(ClickedSlot, ItemOnCursor);
                        p.setItemOnCursor(null);
                        return;
                    }
                }
            }
            else
            {
                ItemStack PresentButton = inv.getItem(ClickedSlot + 9);
                String ButtonCheck = "";
                if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                {
                    ButtonCheck = PresentButton.getData().toString();
                }
                if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                {
                    ButtonCheck = PresentButton.getType().toString();
                }
                if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
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
                if (CheckBoots(p, inv, ClickedSlot, ClickedItem, ItemOnCursor, ItemOnCursorType, ItemOnCursorLore, Title))
                {
                    inv.setItem(ClickedSlot, ItemOnCursor);
                    p.setItemOnCursor(ClickedItem);
                    return;
                }
                else
                {
                    p.setItemOnCursor(ClickedItem);
                    inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
                    String CheckSlot1 = inv.getItem(ClickedSlot - 27).getType().toString();
                    String CheckSlot2 = inv.getItem(ClickedSlot - 18).getType().toString();
                    String CheckSlot3 = inv.getItem(ClickedSlot - 9).getType().toString();
                    String CheckSlot4 = inv.getItem(ClickedSlot).getType().toString();
                    if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                    {
                        inv.setItem(ClickedSlot + 9, WardrobeGUI.CreateEmptyButton(ClickedSlot - 27, inv, Title));
                    }
                    return;
                }
            }
        }
        else if (ClickedSlot >= 36 && ClickedSlot <= 44)
        {
            String ButtonCheck = "";
            if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
            {
                ButtonCheck = ClickedItem.getData().toString();
            }
            if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
            {
                ButtonCheck = ClickedItem.getType().toString();
            }
            if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE"))
            {
                if (Title.contains(WardrobeGUI.Page1Name))
                {
                    for (int i = 36; i <= 44; i++)
                    {
						if (i == ClickedSlot)
						{
							continue;
						}
                        ItemStack CheckButton = inv.getItem(i);
                        String ButtonCheck2 = "";
                        if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                        {
                            ButtonCheck2 = CheckButton.getData().toString();
                        }
                        if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                        {
                            ButtonCheck2 = CheckButton.getType().toString();
                        }
                        if (ButtonCheck2.contains("LIME_DYE") || ButtonCheck2.contains("LIME DYE"))
                        {
                            ClearPlayerArmor(p);
                            EquipArmorForPlayer(p, inv, ClickedSlot);
                            String CheckSlot1 = inv.getItem(i - 36).getType().toString();
                            String CheckSlot2 = inv.getItem(i - 27).getType().toString();
                            String CheckSlot3 = inv.getItem(i - 18).getType().toString();
                            String CheckSlot4 = inv.getItem(i - 9).getType().toString();
                            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                            {
                                inv.setItem(i, WardrobeGUI.CreateEmptyButton(i - 36, inv, Title));
                            }
                            else
                            {
                                inv.setItem(i, WardrobeGUI.CreateReadyButton(i - 36, inv, Title));
                            }
                            inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                            return;
                        }
                    }
                    if (Wardrobe.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()) != null)
                    {
                        for (String Path : Wardrobe.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()).getKeys(false))
                        {
							if (Path.contains("name"))
							{
								continue;
							}
                            if (Wardrobe.Page_2.getConfig().getString(p.getUniqueId().toString() + "." + Path + ".Button").contains("Equipped"))
                            {
                                ClearPlayerArmor(p);
                                EquipArmorForPlayer(p, inv, ClickedSlot);
                                inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                                Wardrobe.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Button", "Ready");
                                Wardrobe.Page_2.saveConfig();
                                Wardrobe.Page_2.ReloadConfig();
                                return;
                            }
                        }
                    }
                    if (GivePlayerEquippedArmor(p))
                    {
                        EquipArmorForPlayer(p, inv, ClickedSlot);
                        inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                        return;
                    }
                }
                else if (Title.contains(WardrobeGUI.Page2Name))
                {
                    for (int i = 36; i <= 44; i++)
                    {
						if (i == ClickedSlot)
						{
							continue;
						}
                        ItemStack CheckButton = inv.getItem(i);
                        String ButtonCheck2 = "";
                        if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12"))
                        {
                            ButtonCheck2 = CheckButton.getData().toString();
                        }
                        if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17"))
                        {
                            ButtonCheck2 = CheckButton.getType().toString();
                        }
                        if (ButtonCheck2.contains("LIME_DYE") || ButtonCheck2.contains("LIME DYE"))
                        {
                            ClearPlayerArmor(p);
                            EquipArmorForPlayer(p, inv, ClickedSlot);
                            String CheckSlot1 = inv.getItem(i - 36).getType().toString();
                            String CheckSlot2 = inv.getItem(i - 27).getType().toString();
                            String CheckSlot3 = inv.getItem(i - 18).getType().toString();
                            String CheckSlot4 = inv.getItem(i - 9).getType().toString();
                            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                            {
                                inv.setItem(i, WardrobeGUI.CreateEmptyButton(i - 36, inv, Title));
                            }
                            else
                            {
                                inv.setItem(i, WardrobeGUI.CreateReadyButton(i - 36, inv, Title));
                            }
                            inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                            return;
                        }
                    }
                    if (Wardrobe.Page_1.getConfig().getConfigurationSection(p.getUniqueId().toString()) != null)
                    {
                        for (String Path : Wardrobe.Page_1.getConfig().getConfigurationSection(p.getUniqueId().toString()).getKeys(false))
                        {
							if (Path.contains("name"))
							{
								continue;
							}
                            if (Wardrobe.Page_1.getConfig().getString(p.getUniqueId().toString() + "." + Path + ".Button").contains("Equipped"))
                            {
                                ClearPlayerArmor(p);
                                EquipArmorForPlayer(p, inv, ClickedSlot);
                                inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                                Wardrobe.Page_1.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Button", "Ready");
                                Wardrobe.Page_1.saveConfig();
                                Wardrobe.Page_1.ReloadConfig();
                                return;
                            }
                        }
                    }
                    if (GivePlayerEquippedArmor(p))
                    {
                        EquipArmorForPlayer(p, inv, ClickedSlot);
                        inv.setItem(ClickedSlot, WardrobeGUI.CreateEquippedButton(ClickedSlot - 36, inv, Title));
                        return;
                    }
                }
            }
            else if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE"))
            {
                ClearPlayerArmor(p);
                String CheckSlot1 = inv.getItem(ClickedSlot - 36).getType().toString();
                String CheckSlot2 = inv.getItem(ClickedSlot - 27).getType().toString();
                String CheckSlot3 = inv.getItem(ClickedSlot - 18).getType().toString();
                String CheckSlot4 = inv.getItem(ClickedSlot - 9).getType().toString();
                if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
                {
                    inv.setItem(ClickedSlot, WardrobeGUI.CreateEmptyButton(ClickedSlot - 36, inv, Title));
                    return;
                }
                inv.setItem(ClickedSlot, WardrobeGUI.CreateReadyButton(ClickedSlot - 36, inv, Title));
                return;
            }
        }
    }

    public static void ClearPlayerArmor(Player p)
    {
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
    }

    public static void EquipArmorForPlayer(Player p, Inventory inv, int ClickedSlot)
    {
        ItemStack Helmet = null;
        ItemStack Chestplate = null;
        ItemStack Leggings = null;
        ItemStack Boots = null;
        if (!(inv.getItem(ClickedSlot - 36).getType().toString().contains("STAINED_GLASS_PANE")))
        {
            Helmet = inv.getItem(ClickedSlot - 36).clone();
        }
        if (!(inv.getItem(ClickedSlot - 27).getType().toString().contains("STAINED_GLASS_PANE")))
        {
            Chestplate = inv.getItem(ClickedSlot - 27).clone();
        }
        if (!(inv.getItem(ClickedSlot - 18).getType().toString().contains("STAINED_GLASS_PANE")))
        {
            Leggings = inv.getItem(ClickedSlot - 18).clone();
        }
        if (!(inv.getItem(ClickedSlot - 9).getType().toString().contains("STAINED_GLASS_PANE")))
        {
            Boots = inv.getItem(ClickedSlot - 9).clone();
        }
        p.getInventory().setHelmet(Helmet);
        p.getInventory().setChestplate(Chestplate);
        p.getInventory().setLeggings(Leggings);
        p.getInventory().setBoots(Boots);
    }

    public static boolean GivePlayerEquippedArmor(Player p)
    {
        int ArmorCount = 0;
        int FreeSpace = 0;
        int NoSpace = 0;
        // Set the items in player armor slot
        ItemStack HelmetSlot = p.getInventory().getHelmet();
        ItemStack ChestplateSlot = p.getInventory().getChestplate();
        ItemStack LeggingsSlot = p.getInventory().getLeggings();
        ItemStack BootsSlot = p.getInventory().getBoots();
        // Check armor amount
        if (HelmetSlot != null)
        {
            ArmorCount++;
        }
        if (ChestplateSlot != null)
        {
            ArmorCount++;
        }
        if (LeggingsSlot != null)
        {
            ArmorCount++;
        }
        if (BootsSlot != null)
        {
            ArmorCount++;
        }
		if (ArmorCount == 1)
		{
			NoSpace = 4;
		}
		if (ArmorCount == 2)
		{
			NoSpace = 3;
		}
		if (ArmorCount == 3)
		{
			NoSpace = 2;
		}
		if (ArmorCount == 4)
		{
			NoSpace = 1;
		}
        for (ItemStack i : p.getInventory())
        {
            if (i == null)
            {
                FreeSpace++;
            }
            if (FreeSpace - NoSpace >= ArmorCount)
            {
                // Give player that armor
				if (HelmetSlot != null)
				{
					p.getInventory().addItem(HelmetSlot);
				}
				if (ChestplateSlot != null)
				{
					p.getInventory().addItem(ChestplateSlot);
				}
				if (LeggingsSlot != null)
				{
					p.getInventory().addItem(LeggingsSlot);
				}
				if (BootsSlot != null)
				{
					p.getInventory().addItem(BootsSlot);
				}
                // Clear player armor slot
                ItemStack Clear = new ItemStack(Material.AIR);
                p.getInventory().setHelmet(Clear);
                p.getInventory().setChestplate(Clear);
                p.getInventory().setLeggings(Clear);
                p.getInventory().setBoots(Clear);
                return true;
            }
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Wardrobe_Message.No_Space")));
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
        return false;
    }

    public static void ShiftClickInv(Player p, Inventory inv, int ClickedSlot, String Title)
    {
        ItemStack ClickedItem = inv.getItem(ClickedSlot);
		if (ClickedItem.getType().toString().contains("STAINED_GLASS_PANE"))
		{
			return;
		}
        if (ClickedSlot >= 0 && ClickedSlot <= 8)
        {
            p.getInventory().addItem(ClickedItem);
            inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
            String CheckSlot1 = inv.getItem(ClickedSlot).getType().toString();
            String CheckSlot2 = inv.getItem(ClickedSlot + 9).getType().toString();
            String CheckSlot3 = inv.getItem(ClickedSlot + 18).getType().toString();
            String CheckSlot4 = inv.getItem(ClickedSlot + 27).getType().toString();
            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
            {
                inv.setItem(ClickedSlot + 36, WardrobeGUI.CreateEmptyButton(ClickedSlot, inv, Title));
            }
            return;
        }
        else if (ClickedSlot >= 9 && ClickedSlot <= 17)
        {
            p.getInventory().addItem(ClickedItem);
            inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
            String CheckSlot1 = inv.getItem(ClickedSlot - 9).getType().toString();
            String CheckSlot2 = inv.getItem(ClickedSlot).getType().toString();
            String CheckSlot3 = inv.getItem(ClickedSlot + 9).getType().toString();
            String CheckSlot4 = inv.getItem(ClickedSlot + 18).getType().toString();
            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
            {
                inv.setItem(ClickedSlot + 27, WardrobeGUI.CreateEmptyButton(ClickedSlot - 9, inv, Title));
            }
            return;
        }
        else if (ClickedSlot >= 18 && ClickedSlot <= 26)
        {
            p.getInventory().addItem(ClickedItem);
            inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
            String CheckSlot1 = inv.getItem(ClickedSlot - 18).getType().toString();
            String CheckSlot2 = inv.getItem(ClickedSlot - 9).getType().toString();
            String CheckSlot3 = inv.getItem(ClickedSlot).getType().toString();
            String CheckSlot4 = inv.getItem(ClickedSlot + 9).getType().toString();
            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
            {
                inv.setItem(ClickedSlot + 18, WardrobeGUI.CreateEmptyButton(ClickedSlot - 18, inv, Title));
            }
            return;
        }
        else if (ClickedSlot >= 27 && ClickedSlot <= 35)
        {
            p.getInventory().addItem(ClickedItem);
            inv.setItem(ClickedSlot, WardrobeGUI.Background(ClickedSlot, inv, Title));
            String CheckSlot1 = inv.getItem(ClickedSlot - 27).getType().toString();
            String CheckSlot2 = inv.getItem(ClickedSlot - 18).getType().toString();
            String CheckSlot3 = inv.getItem(ClickedSlot - 9).getType().toString();
            String CheckSlot4 = inv.getItem(ClickedSlot).getType().toString();
            if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE"))
            {
                inv.setItem(ClickedSlot + 9, WardrobeGUI.CreateEmptyButton(ClickedSlot - 27, inv, Title));
            }
            return;
        }
    }

    public static boolean CheckHelmet(Player p, Inventory inv, int ClickedSlot, ItemStack ClickedItem, ItemStack ItemOnCursor, String ItemOnCursorType, List<String> ItemOnCursorLore, String Title)
    {
		if (ItemOnCursor == null || ItemOnCursorType.contains("AIR"))
		{
			return false;
		}
        if (ItemOnCursorType.contains("_HELMET"))
        {
            inv.setItem(ClickedSlot, ItemOnCursor);
            p.setItemOnCursor(null);
            inv.setItem(ClickedSlot + 36, WardrobeGUI.CreateReadyButton(ClickedSlot, inv, Title));
            return true;
        }
        else
        {
            if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
            {
                if (ItemOnCursorLore != null)
                {
                    for (int i = 0; i < ItemOnCursorLore.size(); i++)
                    {
                        if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Specific-Check-Lore")))
                        {
                            inv.setItem(ClickedSlot, ItemOnCursor);
                            p.setItemOnCursor(null);
                            inv.setItem(ClickedSlot + 36, WardrobeGUI.CreateReadyButton(ClickedSlot, inv, Title));
                            return true;
                        }
                    }
                }
            }
            if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore").equalsIgnoreCase("none"))
            {
                return false;
            }
            int CheckAmount = 0;
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name").equalsIgnoreCase("none")))
			{
				if (ItemOnCursor.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Name"))))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore").equalsIgnoreCase("none")))
			{
				if (ItemOnCursorLore != null)
				{
					for (int i = 0; i < ItemOnCursorLore.size(); i++)
					{
						if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Lore")))
						{
							CheckAmount++;
						}
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").equalsIgnoreCase("none")))
			{
				if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Helmet-Slot.Type").contains(ItemOnCursorType)))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (CheckAmount == 3)
			{
				inv.setItem(ClickedSlot, ItemOnCursor);
				p.setItemOnCursor(null);
				inv.setItem(ClickedSlot + 36, WardrobeGUI.CreateReadyButton(ClickedSlot, inv, Title));
				return true;
			}
			else
			{
				return false;
			}
        }
    }

    public static boolean CheckChestplate(Player p, Inventory inv, int ClickedSlot, ItemStack ClickedItem, ItemStack ItemOnCursor, String ItemOnCursorType, List<String> ItemOnCursorLore, String Title)
    {
        if (ItemOnCursorType.contains("_CHESTPLATE"))
        {
            inv.setItem(ClickedSlot, ItemOnCursor);
            p.setItemOnCursor(null);
            inv.setItem(ClickedSlot + 27, WardrobeGUI.CreateReadyButton(ClickedSlot - 9, inv, Title));
            return true;
        }
        else
        {
            if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
            {
                if (ItemOnCursorLore != null)
                {
                    for (int i = 0; i < ItemOnCursorLore.size(); i++)
                    {
                        if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Specific-Check-Lore")))
                        {
                            inv.setItem(ClickedSlot, ItemOnCursor);
                            p.setItemOnCursor(null);
                            inv.setItem(ClickedSlot + 27, WardrobeGUI.CreateReadyButton(ClickedSlot - 9, inv, Title));
                            return true;
                        }
                    }
                }
            }
            if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore").equalsIgnoreCase("none"))
            {
                return false;
            }
            int CheckAmount = 0;
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name").equalsIgnoreCase("none")))
			{
				if (ItemOnCursor.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Name"))))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore").equalsIgnoreCase("none")))
			{
				if (ItemOnCursorLore != null)
				{
					for (int i = 0; i < ItemOnCursorLore.size(); i++)
					{
						if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Lore")))
						{
							CheckAmount++;
						}
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").equalsIgnoreCase("none")))
			{
				if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Chestplate-Slot.Type").contains(ItemOnCursorType)))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (CheckAmount == 3)
			{
				inv.setItem(ClickedSlot, ItemOnCursor);
				p.setItemOnCursor(null);
				inv.setItem(ClickedSlot + 27, WardrobeGUI.CreateReadyButton(ClickedSlot - 9, inv, Title));
				return true;
			}
			else
			{
				return false;
			}
        }
    }

    public static boolean CheckLeggings(Player p, Inventory inv, int ClickedSlot, ItemStack ClickedItem, ItemStack ItemOnCursor, String ItemOnCursorType, List<String> ItemOnCursorLore, String Title)
    {
        if (ItemOnCursorType.contains("_LEGGINGS"))
        {
            inv.setItem(ClickedSlot, ItemOnCursor);
            p.setItemOnCursor(null);
            inv.setItem(ClickedSlot + 18, WardrobeGUI.CreateReadyButton(ClickedSlot - 18, inv, Title));
            return true;
        }
        else
        {
            if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
            {
                if (ItemOnCursorLore != null)
                {
                    for (int i = 0; i < ItemOnCursorLore.size(); i++)
                    {
                        if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Specific-Check-Lore")))
                        {
                            inv.setItem(ClickedSlot, ItemOnCursor);
                            p.setItemOnCursor(null);
                            inv.setItem(ClickedSlot + 18, WardrobeGUI.CreateReadyButton(ClickedSlot - 18, inv, Title));
                            return true;
                        }
                    }
                }
            }
            if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore").equalsIgnoreCase("none"))
            {
                return false;
            }
            int CheckAmount = 0;
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name").equalsIgnoreCase("none")))
			{
				if (ItemOnCursor.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Name"))))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore").equalsIgnoreCase("none")))
			{
				if (ItemOnCursorLore != null)
				{
					for (int i = 0; i < ItemOnCursorLore.size(); i++)
					{
						if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Lore")))
						{
							CheckAmount++;
						}
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").equalsIgnoreCase("none")))
			{
				if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Leggings-Slot.Type").contains(ItemOnCursorType)))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (CheckAmount == 3)
			{
				inv.setItem(ClickedSlot, ItemOnCursor);
				p.setItemOnCursor(null);
				inv.setItem(ClickedSlot + 18, WardrobeGUI.CreateReadyButton(ClickedSlot - 18, inv, Title));
				return true;
			}
			else
			{
				return false;
			}
        }
    }

    public static boolean CheckBoots(Player p, Inventory inv, int ClickedSlot, ItemStack ClickedItem, ItemStack ItemOnCursor, String ItemOnCursorType, List<String> ItemOnCursorLore, String Title)
    {
        if (ItemOnCursorType.contains("_BOOTS"))
        {
            inv.setItem(ClickedSlot, ItemOnCursor);
            p.setItemOnCursor(null);
            inv.setItem(ClickedSlot + 9, WardrobeGUI.CreateReadyButton(ClickedSlot - 27, inv, Title));
            return true;
        }
        else
        {
            if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Specific-Check-Lore").equalsIgnoreCase("none")))
            {
                if (ItemOnCursorLore != null)
                {
                    for (int i = 0; i < ItemOnCursorLore.size(); i++)
                    {
                        if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Specific-Check-Lore")))
                        {
                            inv.setItem(ClickedSlot, ItemOnCursor);
                            p.setItemOnCursor(null);
                            inv.setItem(ClickedSlot + 9, WardrobeGUI.CreateReadyButton(ClickedSlot - 27, inv, Title));
                            return true;
                        }
                    }
                }
            }
            if (Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").equalsIgnoreCase("none") &&
                    Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore").equalsIgnoreCase("none"))
            {
                return false;
            }
            int CheckAmount = 0;
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name").equalsIgnoreCase("none")))
			{
				if (ItemOnCursor.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Name"))))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore").equalsIgnoreCase("none")))
			{
				if (ItemOnCursorLore != null)
				{
					for (int i = 0; i < ItemOnCursorLore.size(); i++)
					{
						if (ItemOnCursorLore.get(i).contains(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Lore")))
						{
							CheckAmount++;
						}
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (!(Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").equalsIgnoreCase("none")))
			{
				if ((Wardrobe.ConfigData.getConfig().getString("Allow-Item.Boots-Slot.Type").contains(ItemOnCursorType)))
				{
					CheckAmount++;
				}
				else
				{
					return false;
				}
			}
			else
			{
				CheckAmount++;
			}
			if (CheckAmount == 3)
			{
				inv.setItem(ClickedSlot, ItemOnCursor);
				p.setItemOnCursor(null);
				inv.setItem(ClickedSlot + 9, WardrobeGUI.CreateReadyButton(ClickedSlot - 27, inv, Title));
				return true;
			}
			else
			{
				return false;
			}
        }
    }

    public static void CheckArmor(Player p, Inventory inv, int ButtonSlot, String Title)
    {
        if (p.getInventory().getHelmet() == null)
        {
            inv.setItem(ButtonSlot - 36, WardrobeGUI.Background(ButtonSlot - 36, inv, Title));
        }
        else
        {
            inv.setItem(ButtonSlot - 36, p.getInventory().getHelmet().clone());
        }
        if (p.getInventory().getChestplate() == null)
        {
            inv.setItem(ButtonSlot - 27, WardrobeGUI.Background(ButtonSlot - 27, inv, Title));
        }
        else
        {
            inv.setItem(ButtonSlot - 27, p.getInventory().getChestplate().clone());
        }
        if (p.getInventory().getLeggings() == null)
        {
            inv.setItem(ButtonSlot - 18, WardrobeGUI.Background(ButtonSlot - 18, inv, Title));
        }
        else
        {
            inv.setItem(ButtonSlot - 18, p.getInventory().getLeggings().clone());
        }
        if (p.getInventory().getBoots() == null)
        {
            inv.setItem(ButtonSlot - 9, WardrobeGUI.Background(ButtonSlot - 9, inv, Title));
        }
        else
        {
            inv.setItem(ButtonSlot - 9, p.getInventory().getBoots().clone());
        }
    }
}
