package net.nocst.rpg_stuff.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nocst.rpg_stuff.items.ModItems;
import net.nocst.rpg_stuff.worldgen.structure.StructureSpawner;

public class InteractiveBlock  extends Block
{
    public InteractiveBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        // Виконуємо лише на сервері
        if (!level.isClientSide) {

            // Перевірка, чи гравець тримає спеціальний ключ
            if (heldItem.is(ModItems.KEY.get())) {
                ServerLevel serverLevel = (ServerLevel) level;

                // Телепортація гравця в данж
                TeleportHandler.teleportPlayerToDungeon(serverLevel, (ServerPlayer) player);
                System.out.println("NOCST[TECH]: teleportation success!");

                // Спавн структури
                StructureSpawner.spawnWithFallback(serverLevel, "example1");
                System.out.println("NOCST[TECH]: block summoned!");

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
