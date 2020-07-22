package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootTest
class UserControllerTest {
	private MockMvc mockmvc;

	@Autowired
	private WebApplicationContext context;

	XmlMapper xmlMapper = new XmlMapper();

	@BeforeEach
	private void setUp() {

		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	@Test
	void test_firstName_middleName_lastName() throws Exception {
		UserDTO order = new UserDTO("ajeet", "kumar", "yadav");

		String xml = xmlMapper.writeValueAsString(order);

		mockmvc.perform(
				post("/users").contentType(MediaType.APPLICATION_XML).content(xml).accept(MediaType.APPLICATION_XML))
				.andExpect(status().isCreated()).andDo(print());

	}

	@Test
	void test_firstName_lastName() throws Exception {
		UserDTO order = new UserDTO("ajeet", "", "yadav");

		String xml = xmlMapper.writeValueAsString(order);

		mockmvc.perform(
				post("/users").contentType(MediaType.APPLICATION_XML).content(xml).accept(MediaType.APPLICATION_XML))
				.andExpect(status().isCreated()).andDo(print());

	}

	@Test
	void test_lastName() throws Exception {
		UserDTO order = new UserDTO("", "", "yadav");

		String xml = xmlMapper.writeValueAsString(order);

		mockmvc.perform(
				post("/users").contentType(MediaType.APPLICATION_XML).content(xml).accept(MediaType.APPLICATION_XML))
				.andExpect(status().isBadRequest()).andDo(print());

	}

	@Test
	void test_firstName() throws Exception {
		UserDTO order = new UserDTO("Ajeet", "", "");

		String xml = xmlMapper.writeValueAsString(order);

		mockmvc.perform(
				post("/users").contentType(MediaType.APPLICATION_XML).content(xml).accept(MediaType.APPLICATION_XML))
				.andExpect(status().isBadRequest()).andDo(print());

	}

}
