package LastTry.example.myProject.RegistrationController;

import LastTry.example.myProject.ModelRegistration.UserRegistration;
import LastTry.example.myProject.Repository.StudentRepo;
import LastTry.example.myProject.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Controller

//controller class to handle the request and pass data to the template:
public class UserController {

    private final StudentService studentService;
    @Autowired
    public UserController(StudentService studentService){
        this.studentService=studentService;
    }

    //STEP 1
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/ViewEnrolment/Student/Table")
    public String EnrolmentTable(Model model) {
        model.addAttribute("entities"
                ,studentService.getAllUserRegistration()); // getAllUserRegistration()->A method from service for fetching data
//  method EnrolmentTable() will fetch the data from the database using the service class
        return "Enrolled.html";
    }

@GetMapping("/Welcome/JoinCourse")
public String getHome() {
    return "Register";
}

@Controller
    public class HomeController {
    @GetMapping("/https:site/Course/Student/Start")
    public String homeCourse() {
        return "Courses";
    }

}

//    STEP 3
    @GetMapping("/https:site/Index/Sign/Form")
    public String FormIndex(Model model)
    {
        model.addAttribute("UserForm",new UserRegistration());//UserForm->is bound to index(Form)
        return "index";
    }

    //save students details
    @PostMapping("/ViewEnrolment/Student/Table")
    public String saveUser(UserRegistration userRegistration, RedirectAttributes ra){
        studentService.save(userRegistration);
        ra.addFlashAttribute("message","The Student has been saved successfully");
        return "redirect:/ViewEnrolment/Student/Table";
    }

//delete student
    @GetMapping("/user/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id,UserRegistration userRegistration,RedirectAttributes remove)  {
        try {
            studentService.delete(id);
            remove.addFlashAttribute("Deletemessage","STATUS: Deleted Success");
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/ViewEnrolment/Student/Table";
    }

    @GetMapping("/add/new/student")
    public String goBack(){
        return "redirect:/https:site/Index/Sign/Form";
    }

}