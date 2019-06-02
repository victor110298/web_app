package web_app.mapper;

import web_app.dto.Role;
import web_app.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    public Role mapRoleEntityToRole(RoleEntity entity){
        return new Role()
                .setId(entity.getId())
                .setName(entity.getName());
    }

    public List<Role> mapRoleEntitiesToRoles(List<RoleEntity> entities){
        return entities.stream()
                .map(this::mapRoleEntityToRole)
                .collect(Collectors.toList());
    }

    public RoleEntity mapRoleToRoleEntity(Role role){
        RoleEntity entity = new RoleEntity()
                .setName(role.getName());
        entity.setId(role.getId());
        return entity;
    }
}
