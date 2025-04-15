package quizcheat.backend.dto.request;

public class RegisterRequest {
    private String email;
    private String password;
    private String checkpassword;
    private String name;

    public RegisterRequest() {
    }

    public RegisterRequest(String email, String password, String checkpassword, String name) {
        this.email = email;
        this.password = password;
        this.checkpassword = checkpassword;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckpassword() {
        return checkpassword;
    }

    public void setCheckpassword(String checkpassword) {
        this.checkpassword = checkpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
