package com.starl0stgaming.pyxisapi.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class PyxisUtil {
    public static final Codec<AABB> AABB_CODEC = Codec.DOUBLE.listOf().comapFlatMap(
            values -> {
                if(values.size() != 6) {
                    return DataResult.error(() ->
                            "AABB must have exactly 6 numbers [x1,y1,z1,x2,y2,z2], got " + values.size());
                }
                double x1 = values.get(0);
                double y1 = values.get(1);
                double z1 = values.get(2);
                double x2 = values.get(3);
                double y2 = values.get(4);
                double z2 = values.get(5);

                if(x2 <= 0 || y2 <= 0 || z2 <= 0 || x2 > 1 || y2 > 1 || z2 > 1) {
                    return DataResult.error(() ->
                            "Invalid AABB: must be withing [0,1] block space"
                    );
                }
                return DataResult.success(new AABB(x1, y1, z1, x2, y2, z2));
            },
            box -> List.of(
                    box.minX, box.minY, box.minZ,
                    box.maxX, box.maxY, box.maxZ
            )
    );
}
