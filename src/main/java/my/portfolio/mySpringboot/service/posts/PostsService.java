package my.portfolio.mySpringboot.service.posts;

import lombok.RequiredArgsConstructor;
import my.portfolio.mySpringboot.domain.posts.Posts;
import my.portfolio.mySpringboot.domain.posts.PostsRepository;
import my.portfolio.mySpringboot.web.Dto.PostsListResponseDto;
import my.portfolio.mySpringboot.web.Dto.PostsResponseDto;
import my.portfolio.mySpringboot.web.Dto.PostsSaveRequestDto;
import my.portfolio.mySpringboot.web.Dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                                      .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                              .stream()
                              .map(PostsListResponseDto::new)
                              .collect(Collectors.toList());
    }
}
