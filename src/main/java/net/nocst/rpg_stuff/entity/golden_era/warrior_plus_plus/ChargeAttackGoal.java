//package net.nocst.rpg_stuff.entity.golden_era.warrior_plus_plus;
//
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.ai.goal.Goal;
//
//import java.util.EnumSet;
//
///**
// * ChargeAttackGoal змушує ентіті виконати швидкий ривок до цілі,
// * якщо вона знаходиться на відстані 10-30 блоків.
// * Містить параметри, які легко кастомізуються:
// * - мінімальна/максимальна дистанція
// * - швидкість ривка
// * - час перезарядки
// */
//public class ChargeAttackGoal extends Me {
//    private final WarriorPlusPlusEntity mob;          // Референс до ентіті
//    private LivingEntity target;         // Поточна ціль (гравець)
//    private int cooldown;                // Лічильник перезарядки (в тіках)
//
//    // Кастомізовані параметри
//    private final double minDistanceSq = 10 * 10;  // квадрат мін. дистанції
//    private final double maxDistanceSq = 30 * 30;  // квадрат макс. дистанції
//    private final double chargeSpeed = 1.2D;       // швидкість ривка
//    private final int cooldownTicks = 100;         // час перезарядки в тіках
//
//    public ChargeAttackGoal(WarriorPlusPlusEntity mob) {
//        this.mob = mob;
//        // Goal.Control.MOVE для переміщень, .LOOK для спрямування погляду
//        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
//    }
//
//    /**
//     * Перевіряє, чи можна почати ривок:
//     * - є й Target
//     * - дистанція у межах [minDistance, maxDistance]
//     * - перезарядка завершена
//     */
//    @Override
//    public boolean canStart() {
//        this.target = mob.getTarget();
//        if (target == null) {
//            return false;
//        }
//        double distanceSq = mob.squaredDistanceTo(target);
//        if (distanceSq < minDistanceSq || distanceSq > maxDistanceSq) {
//            return false;
//        }
//        return cooldown <= 0;
//    }
//
//    /**
//     * Запускає ривок:
//     * - обчислює напрямок до цілі
//     * - зупиняє поточну навігацію
//     * - встановлює новий рух вперед на певну відстань зі швидкістю chargeSpeed
//     * - встановлює перезарядку
//     */
//    @Override
//    public void start() {
//        Vec3d direction = target.getPos().subtract(mob.getPos()).normalize();
//        mob.getNavigation().stop();
//        // Виконати ривок на відстань maxDistance (30 блоків)
//        mob.getMoveControl().moveTo(
//                mob.getX() + direction.x * 30,
//                mob.getY() + direction.y * 30,
//                mob.getZ() + direction.z * 30,
//                chargeSpeed
//        );
//        this.cooldown = cooldownTicks;
//    }
//
//    /**
//     * Кожен тік перевіряє, чи достатньо близько до удару:
//     * якщо <2 блоки, наносимо атаку й завершуємо ривок
//     */
//    @Override
//    public void tick() {
//        if (mob.squaredDistanceTo(target) < 2 * 2) {
//            mob.tryAttack(target);
//            this.stop();
//        }
//    }
//
//    /**
//     * Продовжує ривок, якщо ентіті ще рухається й немає перезарядки
//     */
//    @Override
//    public boolean shouldContinue() {
//        return mob.getNavigation().isFollowingPath() && cooldown <= 0;
//    }
//
//    /**
//     * Зупиняє ривок і встановлює перезарядку
//     */
//    @Override
//    public void stop() {
//        mob.getNavigation().stop();
//        this.cooldown = cooldownTicks;
//    }
//
//    /**
//     * Оновлює лічильник перезарядки щотиками
//     */
//    @Override
//    public void tickControls() {
//        if (this.cooldown > 0) {
//            this.cooldown--;
//        }
//    }
//}
