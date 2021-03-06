package my.portfolio.mySpringboot.web;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest3 {

    @Autowired
    private MockMvc mvc2;

    @Ignore
    @Test
    public void hello_return2() throws Exception {
        String hello = "hello";

        mvc2.perform(get("/hello2"))
           .andExpect(status().isOk())
           .andExpect(content().string(hello));
    }

    @Ignore
    @Test
    public void helloDto_return2() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc2.perform(get("/hello/dto2").param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
