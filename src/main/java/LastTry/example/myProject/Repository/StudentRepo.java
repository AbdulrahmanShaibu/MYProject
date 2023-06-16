package LastTry.example.myProject.Repository;

import LastTry.example.myProject.ModelRegistration.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<UserRegistration,Integer> {
    public  long countById(Integer id);
}
