package com.ht.management.ration.distribution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InventoryId implements Serializable {
    @Column(name = "ration_shop_id")
    private Long rationShopId;

    @Column(name = "item_type")
    private String itemType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryId that = (InventoryId) o;
        return Objects.equals(rationShopId, that.rationShopId) &&
                Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rationShopId, itemType);
    }
}
