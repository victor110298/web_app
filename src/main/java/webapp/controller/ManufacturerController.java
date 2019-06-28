package webapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.dto.Manufacturer;
import webapp.entity.ManufacturerEntity;
import webapp.service.ManufacturerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/producers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Manufacturer> createProducer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.createOne(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Manufacturer> updateProducer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.updateOne(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<ManufacturerEntity> findAll() {
        return manufacturerService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ManufacturerEntity> deleteProducer(@PathVariable(value = "id") Long id, ManufacturerEntity entity) {
        if (manufacturerService.findOneById(id) != null) {
            manufacturerService.deleteOneById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Manufacturer> getProducer(@PathVariable("id") Long id) {
        Manufacturer manufacturer = (Manufacturer) manufacturerService.findOneById(id);
        if (manufacturer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(manufacturer, HttpStatus.OK);
        }
    }
}
