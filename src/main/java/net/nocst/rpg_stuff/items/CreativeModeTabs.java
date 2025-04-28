package net.nocst.rpg_stuff.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;

public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPGSTUFF.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("rpg_main_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.COMMON_MATERIAL.get()))
                    .title(Component.translatable("creativetab.rpg_stuff"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COMMON_MATERIAL.get());
                        pOutput.accept(ModItems.EPIC_MATERIAL.get());
                        pOutput.accept(ModItems.GOLDEN_SKELETON_DAMAGED_EGGS.get());
                        pOutput.accept(ModItems.GOLDEN_SKELETON_SPAWN_EGGS.get());
                        pOutput.accept(ModItems.GOLDEN_WARRIOR_SPAWN_EGGS.get());
                    })
                    .build());
    public static void registries(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
