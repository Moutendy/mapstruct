package okta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import okta.models.RoleModel;


public interface RoleRepository extends JpaRepository<RoleModel,Long>{

}
