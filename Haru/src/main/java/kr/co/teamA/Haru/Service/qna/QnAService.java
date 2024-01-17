package kr.co.teamA.Haru.Service.qna;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Repository.qnaRepository.QnARepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QnAService {

    private final QnARepository qnARepository;

    @SuppressWarnings("unused")
    private Specification<QnA> search(String kw) {
        return new Specification<QnA>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<QnA> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true); // 중복을 제거
                Join<QnA, Member> u1 = q.join("userId", JoinType.LEFT); // QnA와 Member 조인
                Join<QnA, Answer> a = q.join("answerList", JoinType.LEFT); // QnA와 Answer 조인
                Join<Answer, Member> u2 = a.join("userId", JoinType.LEFT); // Answer와 Member 조인

                return cb.or(
                        cb.like(q.get("qnaTitle"), "%" + kw + "%"), // 제목
                        cb.like(q.get("qnaContent"), "%" + kw + "%"), // 내용
                        cb.like(u1.get("username"), "%" + kw + "%"), // 질문 작성자
                        cb.like(a.get("answerContent"), "%" + kw + "%"), // 답변 내용
                        cb.like(u2.get("username"), "%" + kw + "%")  // 답변 작성자
                );
            }
        };
    }


    public Page<QnA> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.qnARepository.findAllByKeyword(kw, pageable);
    }

    public QnA getQuestion(Integer id) throws Exception {
        Optional<QnA> question = this.qnARepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new Exception("question not found");
        }
    }

    public void create(String subject, String content, Member user) {
        QnA q = new QnA();
        q.setQnaTitle(subject);
        q.setQnaContent(content);
        Date date = new Date(System.currentTimeMillis());
        q.setQnaCdate(date);
        q.setUserId(user);
        this.qnARepository.save(q);
    }

    public void modify(QnA question, String subject, String content) {
        question.setQnaTitle(subject);
        question.setQnaContent(content);
        Date date = new Date(System.currentTimeMillis());
        question.setQnaCdate(date);
        this.qnARepository.save(question);
    }

    public void delete(QnA question) {
        this.qnARepository.delete(question);
    }


}