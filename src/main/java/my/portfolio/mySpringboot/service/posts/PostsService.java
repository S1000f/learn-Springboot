package my.portfolio.mySpringboot.service.posts;

import lombok.RequiredArgsConstructor;
import my.portfolio.mySpringboot.domain.posts.PostsRepository;
import my.portfolio.mySpringboot.web.Dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
