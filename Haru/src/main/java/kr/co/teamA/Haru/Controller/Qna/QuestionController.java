package kr.co.teamA.Haru.Controller.Qna;


import kr.co.teamA.Haru.Repository.QuestionRepository;
import kr.co.teamA.Haru.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class QuestionController {

    private final QuestionService questionService ;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    // 질문 상세보기
    @GetMapping("/{id}/id")
    public int getQuestion(@PathVariable long id, Model model){

        return "/Qna/"
    }


    //게시글 작성처리

    @PostMapping("/")
    public ResponseEntity<?> createQuestion(/){

    }
}
