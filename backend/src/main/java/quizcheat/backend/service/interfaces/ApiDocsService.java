package quizcheat.backend.service.interfaces;

import java.util.List;

import quizcheat.backend.entity.ApiDocs;

public interface ApiDocsService {
    List<ApiDocs> findAll();

    ApiDocs save(ApiDocs apiDocs);

    boolean exitsByEndPoint(String api);

}
