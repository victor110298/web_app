package webapp.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import webapp.listener.UuidListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode
@EntityListeners(value = UuidListener.class)
public class UuidEntity extends BaseEntity {
    private UUID uuid;
}
