package net.nocst.rpg_stuff.tier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nocst.rpg_stuff.items.ModItems;

import static net.minecraft.network.chat.ChatType.bind;

public final class ModTag {
    public static final TagKey<Item> COMMON_MATERIAL = bind("common_material");


    private ModTag() {
    }

    private static TagKey<Item> bind(String pName) {
        return TagKey.create(ModItems.ITEMS.getRegistryKey(), new ResourceLocation(pName));
    }

    public static TagKey<Item> create(final ResourceLocation name) {
        return TagKey.create(ModItems.ITEMS.getRegistryKey(), name);
    }
}
