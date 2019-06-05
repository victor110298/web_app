package webapp.dto;

import webapp.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import webapp.entity.UserEntity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User extends UserEntity {
    private Long id;
    private UUID uuid;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private RoleEntity role;
}
