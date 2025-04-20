//package net.nocst.rpg_stuff.block.custom;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//import net.minecraft.world.phys.BlockHitResult;
//import net.nocst.rpg_stuff.block.ModBlocks;
//import net.nocst.rpg_stuff.items.ModItems;
//
//public class ModClickedBlock extends Block {
//
//    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");
//    public ModClickedBlock(Properties pProperties) {
//        super(pProperties);
//        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
//    }
//
//    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult){
//        if(!level.isClientSide){
//            if (player.getItemInHand(hand).is(ModItems.KEY.get())){
//                level.setBlock(blockPos, ModBlocks.MOD_PORTAL.get().defaultBlockState(), 3);
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(CLICKED);
//    }
//}
