package pro.developia.cache.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pro.developia.cache.domain.entity.RedisHashUser;

public interface RedisHashUserRepository extends CrudRepository<RedisHashUser, Long> {
}
