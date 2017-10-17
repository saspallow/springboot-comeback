package com.saspallow.demo;

import com.google.gson.Gson;
import com.saspallow.demo.controller.UserController;
import com.saspallow.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

/**
 * Created by dt213142 on 10/17/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserController userController;

    @Test
    public void testGetUserShouldSuccess() throws Exception {
        //given
        User user = new User("Surasak", 18, "Bangkok, Thailand");
        user.setId(1L);

        // when
        given(userController.getUser(1L)).willReturn(new Gson().toJson(user));

        // then
        mvc.perform(
                    get("/user/1")
                            .contentType(APPLICATION_JSON_UTF8_VALUE)
                )
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(user.getUsername())));
        verify(userController, times(1)).getUser(1L);
        verifyNoMoreInteractions(userController);

    }


}
