package quizcheat.backend.service.impl;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import quizcheat.backend.entity.User;
import quizcheat.backend.repository.UserRepository;
import quizcheat.backend.service.AuthService;

@Service
public class AuthServiceimpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String Login(String email, String password) {
        Optional<User> temp = userRepository.findByEmail(email);
        if (!temp.isPresent()) {
            return "Email not exits!";
        }
        User user = temp.get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            // matches tu ma hoa la mat khau dang text tu inp -> hash va so sanh voi pass da
            // hash luu tren data base
            return "Login successful!";
        } else {
            return "Password incorect!";
        }
    }

    @Override
    public String findRoleByEmail(String email) {
        Optional<User> tmp = userRepository.findByEmail(email);
        if (!tmp.isPresent()) {
            return email + ": Dont have role!";
        }
        User user = tmp.get();
        return user.getRole();
    }

    @Override
    public String registerEmail(String email, String password, String checkpassword, String name) {
        email = email.replace(" ", ""); // Loại bỏ tất cả dấu cách trong email
        if (!isValidEmail(email)) {
            return "Invalid email format!";
        }
        Optional<User> tmp = userRepository.findByEmail(email);
        if (tmp.isPresent()) {
            return "Email is already taken, please chose another email!";
        }
        if (!password.equals(checkpassword)) {
            return "Comfirmation password does not match!";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Mã hóa mật khẩu trước khi lưu
        user.setName(name);
        if (userRepository.save(user) != null) {
            return "Register successful , Please login!";
        }
        return "Register error!";
    }

    public boolean isValidEmail(String email) {
        // Kiểm tra nếu email rỗng
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Biểu thức chính quy kiểm tra định dạng email hợp lệ
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Sử dụng Pattern để kiểm tra chuỗi email
        Pattern pattern = Pattern.compile(emailRegex);
        java.util.regex.Matcher matcher = pattern.matcher(email);

        // Kiểm tra nếu email khớp với định dạng hợp lệ
        return matcher.matches();
    }

}