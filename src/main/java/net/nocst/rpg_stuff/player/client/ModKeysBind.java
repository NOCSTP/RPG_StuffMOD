package net.nocst.rpg_stuff.player.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.model.PlayerModel;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nocst.rpg_stuff.RPGSTUFF;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = RPGSTUFF.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeysBind {
    public static KeyMapping dodgeKey;

    @SubscribeEvent
    public static void registerKeyMapping(RegisterKeyMappingsEvent event){
        dodgeKey = new KeyMapping(
                "key.rpg_stuff.dodge_key",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "key.categories.rpg_stuff"
        );
        event.register(dodgeKey);
    }
}

