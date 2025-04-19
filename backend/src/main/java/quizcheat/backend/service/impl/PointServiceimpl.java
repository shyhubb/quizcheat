package quizcheat.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizcheat.backend.entity.Point;
import quizcheat.backend.entity.User;
import quizcheat.backend.repository.PointRepository;
import quizcheat.backend.repository.UserRepository;
import quizcheat.backend.service.interfaces.PointSerivce;

@Service
public class PointServiceimpl implements PointSerivce {

    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean typePoint(String email, Point point) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            User tmp = user.get();
            point.setUser(tmp);
            point.genFinalAvgPonit(); // Nếu muốn tự tính điểm trung bình
            pointRepository.save(point);
            return true;
        }
        return false;
    }

    @Override
    public List<Point> findallPoints() {
        return (List<Point>) pointRepository.findAll();
    }

}
