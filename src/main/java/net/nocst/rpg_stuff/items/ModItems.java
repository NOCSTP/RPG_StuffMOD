package net.nocst.rpg_stuff.items;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.items.weapon.DryadSword;
import net.nocst.rpg_stuff.tier.ModTiers;

public class ModItems {

    public static final DeferredRegister<Item>ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RPGSTUFF.MODID);


    //keys
    public static final RegistryObject<Item> KEY = registerItem("key", new Item.Properties());

    //material
    public static final RegistryObject<Item> COMMON_MATERIAL = registerItem("begin_material", new Item.Properties());
    public static final RegistryObject<Item> RARE_MATERIAL = registerItem("rare_material", new Item.Properties());
    public static final RegistryObject<Item> EPIC_MATERIAL = registerItem("epic_material", new Item.Properties());
    public static final RegistryObject<Item> LEGENDARY_MATERIAL = registerItem("legendary_material", new Item.Properties());

    //swords
    public static final RegistryObject<Item> BBEGINER_SWORD = registerSword("beginer_sword", ModTiers.COMMON_TIER, 3, -1.5F, new Item.Properties());
    public static final RegistryObject<Item> OLD_SWORD = registerSword("old_sword", ModTiers.COMMON_TIER, 3, -1.5F, new Item.Properties());
    public static final RegistryObject<Item> MOSSY_SWORD = registerSword("mossy_sword", ModTiers.COMMON_TIER, 3, -1.5F, new Item.Properties());
    public static final RegistryObject<Item> MASTER_SWORD = registerSword("master_sword", ModTiers.RARE_TIER, 3, -1.5F, new Item.Properties());
    public static final RegistryObject<Item> D_ANCIENT_SWORD = registerSword("ancient_sword_distnetik", ModTiers.RARE_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> GOLDEN_SWORD = registerSword("golden_sword", ModTiers.RARE_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> IRON_SWORD = registerSword("iron_sword", ModTiers.RARE_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> HEAVY_IRON_SWORD = registerSword("heavy_iron_sword", ModTiers.RARE_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> STALIN_SWORD = registerSword("stalin_sword", ModTiers.RARE_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> STEEL_SWORD = registerSword("steel_sword", ModTiers.EPIC_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> VAMPIRE_BLADES = registerSword("vampire_blade", ModTiers.EPIC_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> KATANA = registerSword("katana", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> ANCIENT_SWORD = registerSword("ancient_sword", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> GUARDIAN_SWORD = registerSword("guardian_sword", ModTiers.EPIC_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> DRYAD_SWORD = ITEMS.register("dryad_sword", ()-> new DryadSword());
    public static final RegistryObject<Item> DIAMOND_SWORD = registerSword("diamond_sword", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> HOLY_SWORD = registerSword("holy_sword", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> BERSERK_SWORD = registerSword("top4ik_sword", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());
    public static final RegistryObject<Item> LEGENDARY_SWORD = registerSword("legendary_sword", ModTiers.LEGENDARY_TIER, 3, -2.5F, new Item.Properties());

    //register methodes

    private static RegistryObject<Item> registerSword(String name, Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties ){
        return ITEMS.register(name, ()-> new SwordItem(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties));
    }
    private static RegistryObject<Item> registerItem(String name, Item.Properties properties){
        return ITEMS.register(name, ()-> new Item(properties));
    }
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
