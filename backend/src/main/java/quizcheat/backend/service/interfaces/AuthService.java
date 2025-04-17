package quizcheat.backend.service.interfaces;

public interface AuthService {
    String Login(String email, String password);

    String findRoleByEmail(String email);

    String register(String email, String password, String checkpassword, String name);

    boolean isValidEmail(String email);
}
