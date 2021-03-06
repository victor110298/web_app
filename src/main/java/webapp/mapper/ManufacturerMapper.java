package webapp.mapper;

import webapp.dto.Manufacturer;
import webapp.entity.ManufacturerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManufacturerMapper {
    public Manufacturer mapManufacturerEntityToManufacturer(ManufacturerEntity entity) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer
                .setId(entity.getId())
                .setName(entity.getName())
                .setProducts(entity.getProducts());
        return manufacturer;
    }

    public List<Manufacturer> mapManufacturerEntitiesToManufacturers(List<ManufacturerEntity> entities) {
        return entities.stream()
                .map(this::mapManufacturerEntityToManufacturer)
                .collect(Collectors.toList());
    }

    public ManufacturerEntity mapManufacturerToManufacturerEntity(Manufacturer manufacturer) {
        ManufacturerEntity entity = new ManufacturerEntity()
                .setName(manufacturer.getName())
                .setProducts(manufacturer.getProducts());
        entity.setId(manufacturer.getId());
        return entity;
    }
}
