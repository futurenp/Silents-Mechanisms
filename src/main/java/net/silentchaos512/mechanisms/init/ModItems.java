package net.silentchaos512.mechanisms.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.mechanisms.SilentMechanisms;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ModItems {
    public static Item ironDust;

    static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    private ModItems() {}

    public static void registerAll(RegistryEvent.Register<Item> event) {
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        // Then register your items here
        ironDust = register("iron_dust", new Item(new Item.Properties().group(SilentMechanisms.ITEM_GROUP)));
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = SilentMechanisms.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
