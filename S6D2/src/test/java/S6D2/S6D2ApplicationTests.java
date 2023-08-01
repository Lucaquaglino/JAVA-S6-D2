package S6D2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import S6D2.controllers.Es1Controller;

@SpringBootTest
@AutoConfigureMockMvc
class S6D2ApplicationTests {
	@Autowired
	private Es1Controller es1Controller;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(es1Controller).build();
	}

	@Test
	public void testGetMessageWithItalianLang() throws Exception {
		mockMvc.perform(get("/lang/IT")).andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string("Ciao, mondo!"));
	}

	@Test
	public void testGetMessageWithEnglishLang() throws Exception {
		mockMvc.perform(get("/lang/EN")).andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string("Hello World"));
	}

	@Test
	public void testGetMessageWithInvalidLang() throws Exception {
		mockMvc.perform(get("/lang/ES")).andExpect(status().isOk()).andExpect(
				(ResultMatcher) content().string("ERROR, please choose between EN or IT/ERRORE, scegli tra EN o IT"));
	}
}
