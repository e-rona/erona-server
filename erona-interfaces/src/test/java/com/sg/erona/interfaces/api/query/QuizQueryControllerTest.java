package com.sg.erona.interfaces.api.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.erona.domain.service.query.QuizQueryService;
import com.sg.erona.interfaces.api.query.dto.QuizQueryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Controller Test
// 컨트롤러의 로직이 많지 않은 경우 서비스를 Mock 해서 컨트롤러 레이어만을 단위 테스트하는 것은 효용이 크지 않을 수 있으므로,
// 컨트롤러 테스트는 보통 Mock 대신 실제 서비스 및 도메인 계층을 대상으로 통합 테스트로 작성하는 편이 낫다.


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = QuizQueryController.class)
class QuizQueryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private QuizQueryService quizQueryService;

    private JacksonTester<QuizQueryDTO> jsonMemberDto;

    @BeforeEach
    public void beforeEach() {
        JacksonTester.initFields(this, objectMapper);
    }


    @DisplayName("정상 게임 목록 테스트")
    @Test
    public void create_normal_member() throws Exception {
        QuizQueryDTO quizQueryDTO = new QuizQueryDTO("12345");
        mvc.perform(
                        post("/api/query/game-list")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(quizQueryDTO))
                )
                .andExpect(status().isOk());
    }
}