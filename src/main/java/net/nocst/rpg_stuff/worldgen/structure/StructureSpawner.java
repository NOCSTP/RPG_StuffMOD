package net.nocst.rpg_stuff.worldgen.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;

public class StructureSpawner {

    private static final int STEP = 500;     // Відстань між структурами при кожній спробі
    private static final int MAX_TRIES = 20; // Максимальна кількість спроб пошуку вільної зони

    /**
     * Шукає вільну позицію у світі й спавнить структуру.
     * Якщо на місці вже щось є, зсуває координати на STEP і повторює.
     */
    public static void spawnWithFallback(ServerLevel level, String structureName) {
        StructureTemplateManager manager = level.getStructureManager();
        ResourceLocation structureRL = new ResourceLocation("st", structureName); // Заміни на свій modid

        Optional<StructureTemplate> optional = manager.get(structureRL);
        if (optional.isEmpty()) {
            System.out.println("❌ Структуру не знайдено: " + structureName);
            return;
        }

        StructureTemplate template = optional.get();

        int x = 0;
        int y = 100;
        int z = 0;

        for (int i = 0; i < MAX_TRIES; i++) {
            BlockPos origin = new BlockPos(x, y, z);

            if (isAreaEmpty(level, origin, template)) {
                placeStructure(template, level, origin);
                System.out.println("✅ Спавн структури на координатах: " + origin);
                return;
            }

            // Зсув координат для наступної спроби
            x += STEP;
            z += STEP;
        }

        System.out.println("⚠️ Не вдалося знайти вільне місце після " + MAX_TRIES + " спроб.");
    }

    /**
     * Перевіряє, чи заданий об'єм структури в світі порожній.
     */
    private static boolean isAreaEmpty(ServerLevel level, BlockPos pos, StructureTemplate template) {
        Vec3i size = template.getSize();

        for (int x = 0; x < size.getX(); x++) {
            for (int y = 0; y < size.getY(); y++) {
                for (int z = 0; z < size.getZ(); z++) {
                    BlockPos checkPos = pos.offset(x, y, z);
                    if (!level.isEmptyBlock(checkPos)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Розміщує структуру у світі за заданою позицією.
     */
    private static void placeStructure(StructureTemplate template, ServerLevel level, BlockPos pos) {
        // Прогружаємо чанк на випадок, якщо ще не завантажений
        level.getChunkAt(pos);

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotation(Rotation.NONE)
                .setMirror(Mirror.NONE)
                .setIgnoreEntities(false);

        boolean success = template.placeInWorld(level, pos, pos, settings, level.getRandom(), 2);
        System.out.println("Structure placed: " + success);
    }
}

