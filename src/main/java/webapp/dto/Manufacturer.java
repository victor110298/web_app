package webapp.dto;

import webapp.entity.ManufacturerEntity;
import webapp.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Manufacturer extends ManufacturerEntity {
    private Long id;

    private UUID uuid;

    private String name;

    private Set<ProductEntity> products;
}
