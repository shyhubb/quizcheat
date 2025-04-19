package quizcheat.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizcheat.backend.entity.ApiDocs;
import quizcheat.backend.repository.ApiDocsRepository;
import quizcheat.backend.service.interfaces.ApiDocsService;

@Service
public class ApiDocsServiceimpl implements ApiDocsService {
    @Autowired
    private ApiDocsRepository apiDocsRepository;

    @Override
    public List<ApiDocs> findAll() {
        return (List<ApiDocs>) apiDocsRepository.findAll();
    }

    @Override
    public ApiDocs save(ApiDocs apiDocs) {
        return apiDocsRepository.save(apiDocs);
    }

    @Override
    public boolean exitsByEndPoint(String api) {
        return apiDocsRepository.existsByEndpoint(api);
    }

}
