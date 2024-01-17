package kr.co.teamA.Haru.Controller.qnaController;


import java.security.Principal;


import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Service.qna.QnAService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QnAController {

    private final QnAService qnaService;
    private final UserDetailsService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<QnA> paging = this.qnaService.getList(page, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        return "qna_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) throws Exception {
        QnA question = this.qnaService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }



    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String qnaCreate(BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }

        return "redirect:/question/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(@PathVariable("id") Integer id, Principal principal) throws Exception {
        QnA qna = this.qnaService.getQuestion(id);
        if (!qna.getUserId().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(BindingResult bindingResult, Principal principal,
                                 @PathVariable("id") Integer id) throws Exception {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        QnA qna = this.qnaService.getQuestion(id);
        if (!qna.getUserId().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        return String.format("redirect:/question/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) throws Exception {
        QnA question = this.qnaService.getQuestion(id);
        if (!question.getUserId().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.qnaService.delete(question);
        return "redirect:/";
    }

}