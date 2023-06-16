package LastTry.example.myProject.Services;

import LastTry.example.myProject.ModelRegistration.UserRegistration;
import LastTry.example.myProject.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class StudentService {

//    Use the repository in your service or controller to fetch data:
//    findAll() method from the JpaRepository interface is used to fetch all entities from the table
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    public List<UserRegistration>getAllUserRegistration(){
        return studentRepo.findAll();
    }

    //save students details
    public void save(UserRegistration userRegistration) {
        studentRepo.save(userRegistration);
    }

    //delete student
    public void delete(Integer id) throws UserPrincipalNotFoundException {
        Long count = studentRepo.countById(id);
        if((count == null) || (count == 0)){
            throw new UserPrincipalNotFoundException("Could not find id"+id);
        }else {
            studentRepo.deleteById(id);
        }

    }

}
