package forge.your.world.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

/**
 * class use for create basic pickaxe
 */
public class BasicPickaxe extends PickaxeItem {

    public BasicPickaxe(IItemTier tier, float attackSpeedIn, Properties builder) {
        super(tier, (int) (-(tier.getAttackDamage() * 0.15f)), attackSpeedIn, builder);
    }
}
