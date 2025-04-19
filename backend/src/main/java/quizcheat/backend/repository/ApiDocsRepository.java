package quizcheat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizcheat.backend.entity.ApiDocs;

@Repository
public interface ApiDocsRepository extends JpaRepository<ApiDocs, Long> {

    boolean existsByEndpoint(String endpoint); // Corrected method name
}