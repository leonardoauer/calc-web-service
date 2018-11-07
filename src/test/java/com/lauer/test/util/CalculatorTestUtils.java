package com.lauer.test.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class to create an URL
 * 
 * @author lauer
 *
 */
public class CalculatorTestUtils {
	
	public static final double NUM1 = 10.5;
	public static final double NUM2 = -15.7;
	public static final double NUM3 = 30.0;
	
	public static final String ADD_PATH = "/calculator/add/";
	public static final String SUBTRACT_PATH = "/calculator/subtract/";
	public static final String MULTIPLY_PATH = "/calculator/multiply/";
	public static final String DIVIDE_PATH = "/calculator/divide/";
	public static final String RESET_CACHE_PATH = "/calculator/reset"; 

	/**
	 * Add path parameters to an URL (path)
	 * 
	 * @param path
	 * @param values
	 * @return
	 */
	@SafeVarargs
	public static <T> String addPathParams(String path, T... values) {

		if (StringUtils.isBlank(path)) {
			throw new IllegalArgumentException("Path cannot be blank or null");
		}

		if (ArrayUtils.isEmpty(values)) {
			throw new IllegalArgumentException("Array list cannot be null or have no values");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(path);

		List<T> valuesList = Arrays.asList(values);
		Iterator<T> it = valuesList.iterator();

		do {

			T value = it.next();
			if (value == null) {
				throw new IllegalArgumentException("The array list cannot have null values");
			}

			if (value instanceof Double) {
				sb.append(((Double) value).doubleValue());
			} else {
				sb.append(value);
			}

			if (it.hasNext()) {
				sb.append("/");
			}

		} while (it.hasNext());

		return sb.toString();
	}
}
