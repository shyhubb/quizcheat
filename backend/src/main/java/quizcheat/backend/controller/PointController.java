package quizcheat.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quizcheat.backend.config.JwtTokenProvider;
import quizcheat.backend.dto.request.PointRequest;
import quizcheat.backend.dto.response.PointDetailResponse;
import quizcheat.backend.dto.response.PointReponse;
import quizcheat.backend.dto.response.StatusResponse;
import quizcheat.backend.entity.Point;
import quizcheat.backend.service.impl.PointServiceimpl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/points")
public class PointController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PointServiceimpl pointServiceimpl;

    @PostMapping("/add")
    public ResponseEntity<StatusResponse<PointReponse>> typePoints(@RequestBody PointRequest pointRequest,
            @RequestHeader("Authorization") String token) {

        // Kiểm tra tính hợp lệ của token
        if (token == null || !jwtTokenProvider.validateToken(token)) {
            return new ResponseEntity<>(new StatusResponse<PointReponse>("Error!",
                    new PointReponse("Invalid or expired token!")), HttpStatus.UNAUTHORIZED);
        }

        String email = jwtTokenProvider.getEmailByToken(token);
        if (email != null) {
            Point point = new Point();
            point.setCredit(pointRequest.getCredit());
            point.setDiligence(pointRequest.getDiligence());
            point.setTest(pointRequest.getTest());
            point.setExam1(pointRequest.getExam1());
            point.setExam2(pointRequest.getExam2());
            point.setExam3(pointRequest.getExam3());
            point.setFinalexam(pointRequest.getFinalexam());

            pointServiceimpl.typePoint(email, point);

            return new ResponseEntity<>(
                    new StatusResponse<PointReponse>("Success!", new PointReponse("Create new subject success!")),
                    HttpStatus.CREATED);
        }

        return new ResponseEntity<>(
                new StatusResponse<PointReponse>("Error!", new PointReponse("Error creating new subject!")),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/showall")
    public ResponseEntity<StatusResponse> showAllPoints() {
        List<Point> points = pointServiceimpl.findallPoints();

        if (points.isEmpty()) {
            return new ResponseEntity<>(
                    new StatusResponse<>("Don't have point in the system!", null),
                    HttpStatus.OK);
        }

        // Chuyển đổi từ List<Point> sang List<PointDetailResponse>
        List<PointDetailResponse> responseList = points.stream().map(point -> new PointDetailResponse(
                point.getName(),
                point.getCredit(),
                point.getDiligence(),
                point.getTest(),
                point.getExam1(),
                point.getExam2(),
                point.getExam3(),
                point.getFinalexam(),
                point.getAvgpoint())).collect(Collectors.toList());

        return new ResponseEntity<>(
                new StatusResponse<>("List of all points", responseList),
                HttpStatus.OK);
    }

}
