package kr.co.teamA.Haru.Controller.board;

//import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

//1.typeAlias를 지정한 패키지 위치
//@Alias("bvo")
@Getter
@Setter
public class BoardVO {
    private int idx;
    private String author;
    private String bdate;
    private String contents;
    private String title;
}
/*
create table board(
idx number primary key,
author varchar2(100),
bdate date,
contents varchar2(400),
title varchar2(100));

create sequence board_seq
increment by 1
start with 1;

*/