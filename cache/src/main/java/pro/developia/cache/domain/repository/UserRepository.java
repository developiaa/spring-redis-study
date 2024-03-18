package pro.developia.cache.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.cache.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
