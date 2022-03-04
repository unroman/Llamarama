package io.github.llamarama.team.entity;

import io.github.llamarama.team.entity.bumbllama.BumbleLlamaEntity;
import io.github.llamarama.team.entity.caravantrader.CaravanTraderEntity;
import io.github.llamarama.team.entity.mossyllama.MossyLlamaEntity;
import io.github.llamarama.team.entity.woolyllama.WoollyLlamaEntity;
import io.github.llamarama.team.util.IdBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public final class ModEntityTypes {

    public static final EntityType<WoollyLlamaEntity> WOOLLY_LLAMA =
        register(WoollyLlamaEntity::new, SpawnGroup.CREATURE, 0.9f, 1.87f, false, 10,
            WoollyLlamaEntity::createLlamaAttributes, "woolly_llama");
    public static final EntityType<BumbleLlamaEntity> BUMBLE_LLAMA =
        register(BumbleLlamaEntity::new, SpawnGroup.CREATURE, 0.9f, 1.87f, false, 10,
            BumbleLlamaEntity::createLlamaAttributes, "bumble_llama");
    public static final EntityType<CaravanTraderEntity> CARAVAN_TRADER =
        register(CaravanTraderEntity::new, SpawnGroup.MISC, 0.6f, 1.95f, true, 10,
            CaravanTraderEntity::createAttributes, "caravan_trader");
    public static final EntityType<MossyLlamaEntity> MOSSY_LLAMA =
        register(MossyLlamaEntity::new, SpawnGroup.AXOLOTLS, 0.9f, 1.87f, false, 10,
            WoollyLlamaEntity::createLlamaAttributes, "mossy_llama");

    private ModEntityTypes() {

    }

    @SuppressWarnings("SameParameterValue")
    private static <T extends LivingEntity> EntityType<T> register(EntityType.EntityFactory<T> factory, SpawnGroup group, float width, float height, boolean fixed, int range, Supplier<DefaultAttributeContainer.Builder> attributes, String id) {
        EntityType<T> type =
            FabricEntityTypeBuilder.Living.createLiving()
                .spawnGroup(group)
                .entityFactory(factory)
                .dimensions(new EntityDimensions(width, height, fixed))
                .trackRangeBlocks(range)
                .defaultAttributes(attributes)
                .build();
        return Registry.register(Registry.ENTITY_TYPE, IdBuilder.of(id), type);
    }

    @SuppressWarnings("EmptyMethod")
    public static void init() {

    }

}