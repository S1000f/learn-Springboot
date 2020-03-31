package my.portfolio.mySpringboot.web;

import lombok.RequiredArgsConstructor;
import my.portfolio.mySpringboot.config.auth.LoginUser;
import my.portfolio.mySpringboot.config.auth.dto.SessionUser;
import my.portfolio.mySpringboot.service.posts.PostsService;
import my.portfolio.mySpringboot.web.Dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }
}
