package transactional_SpringBoot.Project.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import transactional_SpringBoot.Project.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {


}
