package quizcheat.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quizcheat.backend.dto.request.ApiDocsRequest;
import quizcheat.backend.dto.response.StatusResponse;
import quizcheat.backend.entity.ApiDocs;
import quizcheat.backend.service.impl.ApiDocsServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/docs/")
public class ApiDocsController {

    @Autowired
    private ApiDocsServiceimpl apiDocsServiceimpl;

    @GetMapping("/overview")
    public ResponseEntity<StatusResponse> showAllApis() {
        return new ResponseEntity<>(new StatusResponse<>("Success!", apiDocsServiceimpl.findAll()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StatusResponse> addEndPoint(@RequestBody ApiDocsRequest apiDocsRequest) {
        if (!apiDocsServiceimpl.exitsByEndPoint(apiDocsRequest.getEndpoint())) {
            ApiDocs apiDocs = new ApiDocs();
            apiDocs.setAuth(apiDocsRequest.getAuth());
            apiDocs.setComment(apiDocs.getComment());
            apiDocs.setEndpoint(apiDocsRequest.getEndpoint());
            apiDocs.setMethod(apiDocsRequest.getMethod());
            apiDocsServiceimpl.save(apiDocs);
            return new ResponseEntity<>(new StatusResponse<>("Success!", apiDocsRequest), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new StatusResponse<>("Error! this end point existed in api docs", apiDocsRequest),
                HttpStatus.BAD_REQUEST);
    }

}
