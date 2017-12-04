package us.xvicario.openmetal;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import us.xvicario.openmetal.items.ItemOMIngot;

import java.util.HashSet;
import java.util.Set;

import static us.xvicario.openmetal.InjectionUtils.Null;

/**
 * Created by XVicarious on 12/3/2017.
 */
@GameRegistry.ObjectHolder(ModOpenMetal.MODID)
public class ItemHandler {
    public static final ItemOMIngot itemOMIngot = Null();
    @Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            final Item[] items = {
                new ItemOMIngot()
            };
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (final Item item : items) {
                registry.register(item);
                ITEMS.add(item);
            }
        }
    }
}
