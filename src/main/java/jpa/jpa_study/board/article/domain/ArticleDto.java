package jpa.jpa_study.board.article.domain;

import java.io.Serializable;

public record ArticleDto(String title, String content, String hashtag) implements Serializable {

}