package net.nocst.rpg_stuff.block.custom;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.ServerLifecycleHooks;

import static net.nocst.rpg_stuff.worldgen.dimension.ModDimensions.TESTDIM_LEVEL_KEY;

public class TeleportHandler {

    /**
     * Телепортує гравця до данж-світу на координати (0.5, 100, 0.5).
     */
    public static void teleportPlayerToDungeon(ServerLevel currentLevel, ServerPlayer player) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        ServerLevel dungeonLevel = server.getLevel(TESTDIM_LEVEL_KEY);

        if (dungeonLevel != null) {
            player.teleportTo(dungeonLevel, 0.5, 100.0, 0.5, player.getYRot(), player.getXRot());
            System.out.println("✅ Гравець телепортований у світ данжу.");
        } else {
            System.out.println("❌ Dungeon world not found! Is datapack loaded?");
        }
    }
}
