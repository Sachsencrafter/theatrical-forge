package dev.theatricalmod.theatrical.data;

import dev.theatricalmod.theatrical.TheatricalMod;
import net.minecraft.data.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = TheatricalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheatricalDataGen {

    @SubscribeEvent
    public static void dataGenEvent(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        if(event.includeServer()){
            gen.addProvider(new TheatricalRecipes(gen));
            gen.addProvider(new TheatricalLootTables(gen));
            BlockTagProvider blockTagProvider = new BlockTagProvider(event.getGenerator());
            gen.addProvider(new TheatricalItemTagProvider(event.getGenerator(), blockTagProvider, event.getExistingFileHelper()));
        }
    }

    public static class BlockTagProvider extends BlockTagsProvider {

        public BlockTagProvider(DataGenerator generatorIn) {
            super(generatorIn);
        }

        @Override
        protected void registerTags() {

        }
    }

}
