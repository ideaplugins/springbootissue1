package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemoController.class)
public class FailingTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getIndex() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/demo").param("page", "2").param("size", "10"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
