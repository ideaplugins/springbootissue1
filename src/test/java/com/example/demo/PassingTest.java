package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemoController.class)
public class PassingTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getIndex() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/demo").param("page", "2").param("size", "10"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@TestConfiguration
	static class TestConfig implements WebMvcConfigurer {

		@Override
		public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
			argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
		}
	}
}
