//package net.nocst.rpg_stuff.block.custom.entity;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.Container;
//import net.minecraft.world.Containers;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//import net.nocst.rpg_stuff.items.ModItems;
//import net.nocst.rpg_stuff.screen.GemPolishingStationMenu;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//public class GemPolishingStationBlockEntity extends BlockEntity implements MenuProvider {
//    private final ItemStackHandler itemHandler = new ItemStackHandler(2);
//
//    private static final int INPUT_SLOT = 0;
//    private static final int OUTPUT_SLOT = 1;
//
//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
//
//    protected final ContainerData data;
//    private int progress = 0;
//    private int max_progress = 78;
//
//    public GemPolishingStationBlockEntity( BlockPos pPos, BlockState pBlockState) {
//        super(ModBlocksEntities.GEM_POLISHING_BE.get(), pPos, pBlockState);
//        this.data = new ContainerData() {
//            @Override
//            public int get(int pIndex) {
//                return switch (pIndex){
//                    case 0 -> GemPolishingStationBlockEntity.this.progress;
//                    case 1 -> GemPolishingStationBlockEntity.this.max_progress;
//                    default -> 0;
//                };
//            }
//
//            @Override
//            public void set(int pIndex, int pValue) {
//                switch (pIndex){
//                    case 0 -> GemPolishingStationBlockEntity.this.progress = pValue;
//                    case 1 -> GemPolishingStationBlockEntity.this.max_progress = pValue;
//                }
//
//            }
//
//            @Override
//            public int getCount() {
//                return 2;
//            }
//        };
//    }
//
//
//    public void drops(){
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//        for (int i = 0; i < itemHandler.getSlots(); i++){
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//        Containers.dropContents(this.level, this.worldPosition, inventory);
//
//    }
//
//    @Override
//    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        if(cap == ForgeCapabilities.ITEM_HANDLER){
//            lazyItemHandler.cast();
//        }
//        return super.getCapability(cap, side);
//    }
//
//    @Override
//    public void onLoad() {
//        super.onLoad();
//        lazyItemHandler = LazyOptional.of(() -> itemHandler); // ERORR
//    }
//
//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//        lazyItemHandler.invalidate();
//    }
//
//    @Override
//    public Component getDisplayName() {
//        return Component.translatable("block.rpg_stuff:gem_polishing_station");
//    }
//
//    @Override
//    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
//        return new GemPolishingStationMenu(pContainerId, pPlayerInventory, this, this.data);
//    }
//
//    @Override
//    protected void saveAdditional(CompoundTag pTag) {
//        pTag.put("inventory", itemHandler.serializeNBT());
//        pTag.putInt("gem_polishing_station.progress", progress);
//        super.saveAdditional(pTag);
//    }
//
//    @Override
//    public void load(CompoundTag pTag) {
//        super.load(pTag);
//        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
//        progress = pTag.getInt("gem_polishing_station.progress");
//    }
//
//    public void tick(Level pLevel1, BlockPos pPos, BlockState pState1) {
//        if(hasRecipe()){
//            increaseCraftingProgress();
//            setChanged(pLevel1, pPos ,pState1 );
//            if (hasProgressFinished()){
//                craftItem();
//                resetProgress();
//            } else {
//                resetProgress();
//            }
//        }
//    }
//
//    private void resetProgress() {
//        progress = 0;
//    }
//
//    private boolean hasRecipe() {
//        boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.COMMON_MATERIAL.get();
//        ItemStack result = new ItemStack(ModItems.BBEGINER_SWORD.get());
//
//        return hasCraftingItem && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
//    }
//
//    private boolean canInsertAmountIntoOutputSlot(int count) {
//        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
//    }
//
//    private boolean canInsertItemIntoOutputSlot(Item item) {
//        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
//
//    }
//
//    private void craftItem() {
//        ItemStack result = new ItemStack(ModItems.COMMON_MATERIAL.get(), 1);
//        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
//
//        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
//                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
//    }
//
//    private boolean hasProgressFinished() {
//        return progress >= max_progress;
//    }
//
//    private void increaseCraftingProgress() {
//        progress++;
//    }
//}
