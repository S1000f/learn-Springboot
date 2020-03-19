package my.portfolio.mySpringboot.web;

import lombok.RequiredArgsConstructor;
import my.portfolio.mySpringboot.service.posts.PostsService;
import my.portfolio.mySpringboot.web.Dto.PostsResponseDto;
import my.portfolio.mySpringboot.web.Dto.PostsSaveRequestDto;
import my.portfolio.mySpringboot.web.Dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
