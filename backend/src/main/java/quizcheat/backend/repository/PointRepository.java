package quizcheat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizcheat.backend.entity.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    // Có thể thêm custom method nếu cần
}
