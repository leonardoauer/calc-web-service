package com.lauer.app.api;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lauer.app.uimodel.CalculatorResult;
import com.lauer.test.util.CalculatorTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorCacheTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CacheManager cacheManager;
	private ConcurrentHashMap<String, CalculatorResult> cache;
	
	@Before
	@SuppressWarnings("unchecked")
	public void setUp() {
		cache = (ConcurrentHashMap<String, CalculatorResult>) cacheManager.getCache("results").getNativeCache();
	}

	/**
	 * Test that calculator operations are cached
	 */
	@Test
	public void testCache() throws Exception {

		assertEquals(0, cache.values().size());
		
		// Call all end points three times
		performAllCalculations();
		performAllCalculations();
		performAllCalculations();
		
		assertEquals(4, cache.values().size());
	}

	@Test
	public void testClearCache() throws Exception {

		// Call all end points three times
		performAllCalculations();
		performAllCalculations();
		performAllCalculations();
		
		assertEquals(4, cache.values().size());
		
		this.mockMvc.perform(post(CalculatorTestUtils.RESET_CACHE_PATH)).andExpect(status().isOk());

		assertEquals(0, cache.values().size());
		
		// Call all end points three times
		performAllCalculations();
		performAllCalculations();
		performAllCalculations();
		
		assertEquals(4, cache.values().size());

		this.mockMvc.perform(post(CalculatorTestUtils.RESET_CACHE_PATH)).andExpect(status().isOk());
	}

	private void performAllCalculations() throws Exception {
		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.ADD_PATH, CalculatorTestUtils.NUM1,
				CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3))).andExpect(status().isOk());

		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.SUBTRACT_PATH, CalculatorTestUtils.NUM1,
				CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3))).andExpect(status().isOk());

		this.mockMvc.perform(get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.MULTIPLY_PATH, CalculatorTestUtils.NUM1,
				CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3))).andExpect(status().isOk());

		this.mockMvc.perform(
				get(CalculatorTestUtils.addPathParams(CalculatorTestUtils.DIVIDE_PATH, CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2)))
				.andExpect(status().isOk());
	}
}
