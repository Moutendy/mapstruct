package okta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import okta.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long>{

	UserModel  findByTel(String tel);
}
