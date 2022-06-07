package me.desertfox.gl.item;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.profile.PlayerProfile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Made for 1.18+
 * @author DesertFox
 * TODO:
 * - AxolotlBucketMeta
 * - BannerMeta
 * - BookMeta
 * - CompassMeta
 * - CrossbowMeta
 * - FireworkEffectMeta
 * - MapMeta
 * - PotionMeta
 * - SpawnEggMeta
 * - SuspuciousStewMeta
 * - TropicalFishBucketMeta
 * TODO: Remove enchants, attributes
 */
public class ItemBuilder {
    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(ItemStack item) {
        this.item = item.clone();
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material, 1);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level){
        addEnchantment(enchantment, level, false);
        return this;
    }

    public ItemBuilder addEnchantment(Map<Enchantment, Integer> enchantments){
        addEnchantment(enchantments, false);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level, boolean isUnsafe){
        if(isUnsafe) item.addUnsafeEnchantment(enchantment, level);
        else item.addEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder addEnchantment(Map<Enchantment, Integer> enchantments, boolean isUnsafe){
        if(isUnsafe) item.addUnsafeEnchantments(enchantments);
        else item.addEnchantments(enchantments);
        return this;
    }

    public ItemBuilder setName(String name){
        name = ChatColor.translateAlternateColorCodes('&', name);
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... itemFlags){
        meta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder addAttributeModifier(Attribute attribute, AttributeModifier modifier){
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }

    public ItemBuilder setCustomModel(int model){
        meta.setCustomModelData(model);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean isUnbreakable){
        meta.setUnbreakable(isUnbreakable);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLore(List<String> lore){
        meta.setLore(lore);
        return this;
    }

    public ItemBuilder setDamage(int damage){
        ((Damageable)meta).setDamage(damage);
        return this;
    }

    public ItemBuilder setSkullOwner(OfflinePlayer owner){
        ((SkullMeta)meta).setOwningPlayer(owner);
        return this;
    }

    public ItemBuilder setSkullSkin(PlayerProfile skin){
        ((SkullMeta)meta).setOwnerProfile(skin);
        return this;
    }

    public ItemBuilder setBlockData(BlockData data){
        ((BlockDataMeta)meta).setBlockData(data);
        return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color){
        ((LeatherArmorMeta)meta).setColor(color);
        return this;
    }

    public ItemBuilder setBlockState(BlockState state){
        ((BlockStateMeta)meta).setBlockState(state);
        return this;
    }

    public ItemBuilder setRepairCost(int repairCost){
        ((Repairable)meta).setRepairCost(repairCost);
        return this;
    }

    public ItemStack build(){
        item.setItemMeta(meta);
        return item;
    }
}
