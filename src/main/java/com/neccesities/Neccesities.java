package com.neccesities;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.function.Function;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Neccesities.MODID)
public abstract class Neccesities {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "neccesities";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    protected abstract void addTranslations(LanguageProvider provider, Function<RegistryObject<?>, String> formatName);
    // Create a Deferred Register to hold Blocks which will all be registered under the "neccesities" namespace

    // Create a Deferred Register to hold Items which will all be registered under the "neccesities" namespace

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace


    // Creates a new Block with the id "neccesities:example_block", combining the namespace and path

    // Creates a new BlockItem with the id "neccesities:example_block", combining the namespace and path


    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2


    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public class NecromiumTier implements Tier {
        @Override
        public int getUses() {
            return 2500; // Trwałość broni
        }
        @Override
        public float getSpeed() {
            return 9.0F; // Prędkość kopania (nieistotne dla miecza)
        }
        @Override
        public float getAttackDamageBonus() {
            return 7.0F; // Bonus do obrażeń
        }
        @Override
        public int getLevel() {
            return 4; // Poziom narzędzia (np. 3 = diament, 4 = netherite)
        }
        @Override
        public int getEnchantmentValue() {
            return 20; // Łatwość zaklinania (np. żelazo: 14, diament: 10, złoto: 22)
        }
        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT)); // Materiał do naprawy
        }
    }

    public class NecromiumGreatsword extends SwordItem {
        public NecromiumGreatsword() {
            super(new NecromiumTier(), 7, -2.8F, new Properties());
        }
    }





    public Neccesities() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        /*
         Register the Deferred Register to the mod event bus so blocks get registered
         Register the Deferred Register to the mod event bus so items get registered
         Register the Deferred Register to the mod event bus so tabs get registered
         Register ourselves for server and other game events we are interested in
        */

        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    // Add the example block item to the building blocks tab


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
