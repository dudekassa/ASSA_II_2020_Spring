package pl.wroc.assa.ASSA_II_2020_spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByLoginAndPassword(String login, String password);

}
