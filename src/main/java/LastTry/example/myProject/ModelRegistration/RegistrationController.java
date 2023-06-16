package LastTry.example.myProject.ModelRegistration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final EnrollmentKeyValidator validator;

    public RegistrationController(EnrollmentKeyValidator validator) {
        this.validator = validator;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistration userRegistration) {
        String enrollmentKey = userRegistration.getEnrolment_key();

        if (validator.isValidEnrollmentKey(enrollmentKey)) {
            // Enrollment key is valid, proceed with registration logic
            return "User registered successfully.";
        } else {
            // Invalid enrollment key
            return "Invalid enrollment key.";
        }
    }
}
