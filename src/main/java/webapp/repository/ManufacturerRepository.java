package webapp.repository;

import webapp.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
}
