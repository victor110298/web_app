package webapp.listener;

import webapp.entity.UuidEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class UuidListener {
    @PrePersist
    public void setRandomUuid(UuidEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
