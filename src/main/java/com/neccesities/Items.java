package com.neccesities;

import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import krelox.spartantoolkit.SpartanMaterial;
import krelox.spartantoolkit.WeaponMap;
import krelox.spartantoolkit.WeaponType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import com.teamabnormals.blueprint.core.api.BlueprintArmorMaterial;


import static com.neccesities.Neccesities.MODID;
import static krelox.spartantoolkit.SpartanAddon.*;


import java.util.ArrayList;
import java.util.function.Function;

public class Items extends Neccesities {
    public static final WeaponMap WEAPONS = new WeaponMap();
    public static final DeferredRegister<Item> ITEMS = itemRegister(MODID);
    public static final DeferredRegister<WeaponTrait> TRAITS = traitRegister(MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = tabRegister(MODID);

    //tutaj dodajemy nowe itemy !!!!
    public static final RegistryObject<Item> NECROMIUM_GREATSWORD = ITEMS.register("necromium_greatsword", () -> new Item(new Item.Properties()));

    //tutaj dodajemy nowe traity
    //no worke/nie potrzebne póki co/zawiłe

    //tutaj dodajemy materiały!!
    // UWAGA "SpartanMaterial" to CZĘŚĆ SPARTAN WEAPONRY ADDONS API, NIE PLAGIAT

    public static final ArrayList<SpartanMaterial> MATERIALS = new ArrayList<>();

    public static final SpartanMaterial NECROMIUM = ModList.get().isLoaded("Neccesities") ? CavesChasmsModule.NECROMIUM_MATERIAL():null;

    //@SuppressWarnings("unused")  wszystko jest used więc tylko zwalnia
    public static final RegistryObject<CreativeModeTab> Neccesities = registerTab(TABS, MODID,
            () -> WEAPONS.get(NECROMIUM, WeaponType.BATTLE_HAMMER).get(),  //tutaj jest opisany jako battle hammer ale no nie jest battle hammer (??)
            (parameters, output) -> ITEMS.getEntries().forEach(item -> output.accept(item.get())));

    @Override
    protected void addTranslations(LanguageProvider provider, Function<RegistryObject<?>, String> formatName) {
        provider.add(NECROMIUM_GREATSWORD.get(), "Necromium Greatsword");
    }

    public Items() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        registerSpartanWeapons(ITEMS);
        ITEMS.register(bus);
        TRAITS.register(bus);
        TABS.register(bus);
    }

    private void registerSpartanWeapons(DeferredRegister<Item> items) {
    }

    static SpartanMaterial material(Enum<?> tier, TagKey<Item> repairTag, RegistryObject<WeaponTrait>... traits) {
        final SpartanMaterial material = new SpartanMaterial(
                new ResourceLocation(MODID, tier.name().toLowerCase()), 37, new int[]{3, 6, 8, 3}, 15, () -> CavesChasmsModule.ARMOR_EQUIP_NECROMIUM.get(),2.0F, 0.0F, () -> Ingredient.of(CCItemTags.););
        return (SpartanMaterial) material;
    }

}
// coś tu jest naszpącone


 //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, NECROMIUM_GREATSWORD.get())
        //.define('|', AetherTags.Items.SKYROOT_STICKS)
                //.define('#', Tags.Items.STRING)
                //.pattern("| ")
                //.pattern("|#")
                //.pattern("| ")
                //.group(SKYROOT_POLE.getId().toString())
        //.unlockedBy("has_skyroot_sticks", has(AetherTags.Items.SKYROOT_STICKS))
        //.save(consumer, SKYROOT_POLE.getId() + "_from_string");
