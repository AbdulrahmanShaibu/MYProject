
  function validateForm() {
      var courseId = document.getElementById("courseId");
      var username = document.getElementById("username");
      var email = document.getElementById("email");
      //var password = document.getElementById("password");
      var passwordInput = document.getElementById("password");
      var passwordValue = passwordInput.value.trim();
      var passwordRegex = /^ST\d{2}$/;

      if (courseId.selectedIndex === 0) {
          alert("Please select a course ID");
          return false;
      }

      if (username.value.trim() === "") {
          alert("Please enter a username");
          return false;
      }

      if (email.value.trim() === "") {
          alert("Please enter an email");
          return false;
      }

      if (password.value.trim() === "") {
          alert("Please enter an enrollment key");
          return false;
      }

      if (!passwordRegex.test(passwordValue)) {
        alert("Dear Student,you are un able to enroll yourself. Please contact the course administrator.");
       // alert("Dear"+" "+username+","+" "+"you are un able to enroll yourself.Please contact course admistrator");//Password should start with 'ST' followed by any two-digit numbers.
        return false; // Prevent form submission
      }
      return true; // Allow form submission
  }