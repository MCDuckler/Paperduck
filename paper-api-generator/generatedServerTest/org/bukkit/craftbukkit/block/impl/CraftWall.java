package org.bukkit.craftbukkit.block.impl;

import com.google.common.base.Preconditions;
import io.papermc.paper.generated.GeneratedFrom;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Wall;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.20.4")
@SuppressWarnings("unused")
public class CraftWall extends CraftBlockData implements Wall {
    private static final BooleanProperty UP = WallBlock.UP;

    private static final BooleanProperty WATERLOGGED = WallBlock.WATERLOGGED;

    private static final Map<BlockFace, EnumProperty<WallSide>> PROPERTY_BY_FACE = Map.of(
        BlockFace.EAST, WallBlock.EAST_WALL,
        BlockFace.NORTH, WallBlock.NORTH_WALL,
        BlockFace.SOUTH, WallBlock.SOUTH_WALL,
        BlockFace.WEST, WallBlock.WEST_WALL
    );

    public CraftWall(BlockState state) {
        super(state);
    }

    @Override
    public boolean isUp() {
        return this.get(UP);
    }

    @Override
    public void setUp(final boolean up) {
        this.set(UP, up);
    }

    @Override
    public boolean isWaterlogged() {
        return this.get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(final boolean waterlogged) {
        this.set(WATERLOGGED, waterlogged);
    }

    @Override
    public Wall.Height getHeight(final BlockFace blockFace) {
        Preconditions.checkArgument(blockFace != null, "blockFace cannot be null!");
        EnumProperty<WallSide> property = PROPERTY_BY_FACE.get(blockFace);
        Preconditions.checkArgument(property != null, "Invalid blockFace, only %s are allowed!", PROPERTY_BY_FACE.keySet().stream().map(Enum::name).collect(Collectors.joining(", ")));
        return this.get(property, Wall.Height.class);
    }

    @Override
    public void setHeight(final BlockFace blockFace, final Wall.Height height) {
        Preconditions.checkArgument(blockFace != null, "blockFace cannot be null!");
        Preconditions.checkArgument(height != null, "height cannot be null!");
        EnumProperty<WallSide> property = PROPERTY_BY_FACE.get(blockFace);
        Preconditions.checkArgument(property != null, "Invalid blockFace, only %s are allowed!", PROPERTY_BY_FACE.keySet().stream().map(Enum::name).collect(Collectors.joining(", ")));
        this.set(property, height);
    }
}
