package com.lauer.app.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lauer.app.enums.CalculatorResponseStatus;
import com.lauer.app.enums.Operation;
import com.lauer.test.util.CalculatorTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorApiTest {

	@Autowired
	private MockMvc mockMvc;

	// -------------------------------------------------------------------------------------------
	// Test add requests
	// -------------------------------------------------------------------------------------------
	@Test
	public void testAddNumbers() throws Exception {
		this.mockMvc
				.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.ADD_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result").isNotEmpty())
				.andExpect(jsonPath("$.operation").value(Operation.ADDITION.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testAddNumbers_missingParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.ADD_PATH, CalculatorTestUtils.NUM1)))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testAddNumbers_wrongParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.ADD_PATH, "10,5", "-15,7", "30,0")))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testAddNumbers_wrongRequestMethod() throws Exception {
		this.mockMvc
				.perform(post(CalculatorTestUtils.addPathParams(CalculatorTestUtils.ADD_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	// -------------------------------------------------------------------------------------------
	// Test subtract requests
	// -------------------------------------------------------------------------------------------
	@Test
	public void testSubtractNumbers() throws Exception {
		this.mockMvc
				.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.SUBTRACT_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result").isNotEmpty())
				.andExpect(jsonPath("$.operation").value(Operation.SUBTRACTION.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testSubtractNumbers_missingParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.SUBTRACT_PATH, CalculatorTestUtils.NUM1)))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testSubtractNumbers_wrongParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.SUBTRACT_PATH, "10,5", "-15,7", "30,0")))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testSubtractNumbers_wrongRequestMethod() throws Exception {
		this.mockMvc
				.perform(post(CalculatorTestUtils.addPathParams(CalculatorTestUtils.SUBTRACT_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	// -------------------------------------------------------------------------------------------
	// Test multiply requests
	// -------------------------------------------------------------------------------------------
	@Test
	public void testMultiplyNumbers() throws Exception {
		this.mockMvc
				.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.MULTIPLY_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result").isNotEmpty())
				.andExpect(jsonPath("$.operation").value(Operation.MULTIPLICATION.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testMultiplyNumbers_missingParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.MULTIPLY_PATH, CalculatorTestUtils.NUM1)))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testMultiplyNumbers_wrongParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.MULTIPLY_PATH, "10,5", "-15,7", "30,0")))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testMultiplyNumbers_wrongRequestMethod() throws Exception {
		this.mockMvc
				.perform(post(CalculatorTestUtils.addPathParams(CalculatorTestUtils.MULTIPLY_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3)))
				.andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	// -------------------------------------------------------------------------------------------
	// Test divide requests
	// -------------------------------------------------------------------------------------------
	@Test
	public void testDivideNumbers() throws Exception {
		this.mockMvc
				.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.DIVIDE_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result").isNotEmpty())
				.andExpect(jsonPath("$.operation").value(Operation.DIVISION.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testDivideNumbers_missingParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.DIVIDE_PATH, CalculatorTestUtils.NUM1)))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testDivideNumbers_wrongParameters() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.DIVIDE_PATH, "10,5", "-15,7")))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void testDivideNumbers_wrongRequestMethod() throws Exception {
		this.mockMvc
				.perform(post(CalculatorTestUtils.addPathParams(CalculatorTestUtils.DIVIDE_PATH, CalculatorTestUtils.NUM1,
						CalculatorTestUtils.NUM2)))
				.andExpect(status().is(HttpStatus.METHOD_NOT_ALLOWED.value()))
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.ERROR.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	// -------------------------------------------------------------------------------------------
	// Test clear Cache
	// -------------------------------------------------------------------------------------------
	@Test
	public void testClearCache() throws Exception {
		this.mockMvc.perform(post(CalculatorTestUtils.RESET_CACHE_PATH)).andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value(CalculatorResponseStatus.SUCCESS.name()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
}
