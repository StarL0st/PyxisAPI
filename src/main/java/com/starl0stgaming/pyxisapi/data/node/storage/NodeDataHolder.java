package com.starl0stgaming.pyxisapi.data.node.storage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.resources.Identifier;

import java.util.Map;
import java.util.UUID;

public class NodeDataHolder {

    /*
    public record NodeDataHandle(
        UUID instanceId,
        Identifier registryId,
        Map<String, Object> nodeStates
    ) {
       public static final Codec<NodeDataHandle> CODEC = RecordCodecBuilder.create(instance ->
               instance.group(
                       UUIDUtil.CODEC.fieldOf("instanceId").forGetter(NodeDataHandle::instanceId),
                       Identifier.CODEC.fieldOf("registryId").forGetter(NodeDataHandle::registryId),
                       Codec.unboundedMap(Codec.STRING)
               )
       )
    }
     **/
}
