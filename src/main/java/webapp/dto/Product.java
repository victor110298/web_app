package webapp.dto;

import lombok.EqualsAndHashCode;
import webapp.entity.ManufacturerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import webapp.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product extends ProductEntity {
    private Long id;
    private UUID uuid;

    private String name;

    private BigDecimal price;

    private ManufacturerEntity manufacturer;
}
