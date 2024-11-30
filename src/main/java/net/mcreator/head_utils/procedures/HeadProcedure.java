package net.mcreator.capecore.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import com.google.common.base.Optional;

public class HeadProcedure {
    public static ItemStack getHeadFromName(String playerName) {
        ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD);

        if (playerName != null && !playerName.isEmpty()) {
            CompoundTag tag = playerHead.getOrCreateTag();
            tag.putString("SkullOwner", playerName);
            playerHead.setTag(tag);
        }

        return playerHead;
    }
    
    public static String getNameFromHead(@NotNull ItemStack playerHead) {
        if (playerHead.getItem() == Items.PLAYER_HEAD) {
            CompoundTag tag = playerHead.getTag();
            if (tag != null) {
                if (tag.contains("SkullOwner", 8)) {
                    return tag.getString("SkullOwner");
                }
                if (tag.contains("SkullOwner", 10)) {
                    CompoundTag skullOwner = tag.getCompound("SkullOwner");
                    if (skullOwner.contains("Name", 8)) {
                        return skullOwner.getString("Name");
                    }
                }
            }
        }
        return "Steve";
    }
}
