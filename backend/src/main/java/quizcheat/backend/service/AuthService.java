package quizcheat.backend.service;

public interface AuthService {
    String Login(String email, String password);

    String findRoleByEmail(String email);

    String registerEmail(String email, String password, String checkpassword, String name);

    boolean isValidEmail(String email);
}
