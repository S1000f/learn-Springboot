package my.portfolio.mySpringboot.web.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import my.portfolio.mySpringboot.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
