package com.threesides.lang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ArrayUtilTest
 *
 * @author Di Wu
 * @since 2023-03-29
 */
public class ArrayUtilTest {

	@Test
	public void isArray() {
	}

	@Test
	public void isEmpty() {
	}

	@Test
	public void isNullElements() {
		String[] array = new String[3];
		array[0] = "0";
		array[1] = "0";
		array[2]= "";
		boolean nullElements = ArrayUtil.isNullElements(array);
		System.out.println("nullElements = " + nullElements);
	}
}