package LastTry.example.myProject.ModelRegistration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String Name;
    public String Email;
    public String Enrolment_key;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEnrolment_key(String enrolment_key) {
        Enrolment_key = enrolment_key;
    }

    public String getEnrolment_key() {
        return Enrolment_key;
    }

}

