package LastTry.example.myProject.ModelRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EnrollmentKeyValidator {
    private final String pattern = "^ST\\d{2}$";

    public boolean isValidEnrollmentKey(String enrollmentKey) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(enrollmentKey);
        return matcher.matches();
    }
}




