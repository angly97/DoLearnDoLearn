package com.example.dolearn.controller;

import com.example.dolearn.config.SecurityConfig;
import com.example.dolearn.dto.MessageDto;
import com.example.dolearn.jwt.JwtTokenProvider;
import com.example.dolearn.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MessageController.class)
@Import(SecurityConfig.class)
public class MessageControllerTest {

    @MockBean
    private MessageService messageService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    JwtTokenProvider jwtTokenProvider;

    @DisplayName("메세지 생성 테스트")
    @Test
    public void messageCreateTest() throws Exception {

        MessageDto messageDto = MessageDto.builder()
                                .id(1L)
                                .rid(1L)
                                .content("test")
                                .isChecked(1).build();

        when(messageService.createMessage(messageDto)).thenReturn(true);

        mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(messageDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("SUCCESS")));
    }

    @DisplayName("메세지 확인상태 업데이트 테스트")
    @Test
    public void messageUpdateTest() throws Exception {
        MessageDto messageDto = MessageDto.builder()
                .id(1L)
                .rid(1L)
                .content("test")
                .isChecked(1).build();

        mockMvc.perform(put("/message")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(messageDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SUCCESS")));
    }

    @DisplayName("메세지 목록 가져오기 테스트")
    @Test
    public void messageListTest() throws Exception {

        String userId= "ssafy";

        List<MessageDto> messageDtoList = new ArrayList<>();

        MessageDto messageDto1 = new MessageDto().builder()
                                                .id(1L)
                                                .content("hello").build();

        MessageDto messageDto2 = new MessageDto().builder()
                .id(2L)
                .content("hello").build();

        MessageDto messageDto3 = new MessageDto().builder()
                .id(3L)
                .content("hello").build();

        messageDtoList.add(messageDto1);
        messageDtoList.add(messageDto2);
        messageDtoList.add(messageDto3);

        when(messageService.getMessageList(anyString())).thenReturn(messageDtoList);

        mockMvc.perform(get("/message/{user_id}",userId))
                .andExpect(status().isOk());
    }
}
