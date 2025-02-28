package com.neccesities;

import com.teamabnormals.blueprint.core.api.BlueprintArmorMaterial;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import com.teamabnormals.caverns_and_chasms.core.CavernsAndChasms;
import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import krelox.spartantoolkit.SpartanMaterial;
import net.minecraft.sounds.SoundEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;

import static com.teamabnormals.caverns_and_chasms.core.registry.CCSoundEvents.HELPER;

public class CavesChasmsModule extends Items {
    public static final RegistryObject<SoundEvent> ARMOR_EQUIP_NECROMIUM = HELPER.createSoundEvent("item.armor.equip_necromium");

    static SpartanMaterial NECROMIUM_MATERIAL() {
        final ArmorMaterial material = new BlueprintArmorMaterial(new ResourceLocation(CavernsAndChasms.MOD_ID, "necromium"), 37, new int[]{3, 6, 8, 3}, 15, () -> CavesChasmsModule.ARMOR_EQUIP_NECROMIUM.get(), 2.0F, 0.0F, () -> Ingredient.of(CCItemTags.INGOTS_NECROMIUM));
        return (SpartanMaterial) material;
    }
    public static final Tier NECROMIUM = new BlueprintItemTier(4, 2031, 9.0F, 3.0F, 15, () -> Ingredient.of(CCItemTags.INGOTS_NECROMIUM));
}



//CavesChasmsModule.ARMOR_EQUIP_NECROMIUM.get() ta część mnie troche przeraża ale to integralna część defincji w caves & chasms, jeżeli byśmy chcieli to usunąć to trzeba strukture zmienić
// wygląda na to że materiał jest całkowicie dodany