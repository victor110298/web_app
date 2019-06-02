package web_app.dto;

import web_app.entity.ManufacturerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {
    private UUID id;

    private String name;

    private BigDecimal price;

    private ManufacturerEntity manufacturer;
}
