package com.threesides.lang;




import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * StringUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class StringUtil {

	private static final int STRING_BUILDER_SIZE = 256;


	public static final String EMPTY = "";

	public static final String NULL = "null";

	//-----------------------------------------------------------------------

	public static boolean isBlank(final CharSequence cs) {
		final int strLen = length(cs);
		if (strLen == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}


	public static boolean isMixedCase(final CharSequence cs) {
		if (isEmpty(cs) || cs.length() == 1) {
			return false;
		}
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (containsUppercase && containsLowercase) {
				return true;
			} else if (Character.isUpperCase(cs.charAt(i))) {
				containsUppercase = true;
			} else if (Character.isLowerCase(cs.charAt(i))) {
				containsLowercase = true;
			}
		}
		return containsUppercase && containsLowercase;
	}


	public static boolean isNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}


	public static boolean isWhitespace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String join(final byte[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}


	public static String join(final byte[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final char[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final char[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final double[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final double[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final float[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final float[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final int[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final int[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final Iterable<?> iterable, final char separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}


	public static String join(final Iterable<?> iterable, final String separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	public static String join(final Iterator<?> iterator, final char separator) {

		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			return Objects.toString(first, EMPTY);
		}

		// two or more elements
		final StringBuilder buf = new StringBuilder(STRING_BUILDER_SIZE); // Java default is 16, probably too small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			buf.append(separator);
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}

		return buf.toString();
	}

	public static String join(final Iterator<?> iterator, final String separator) {

		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			return Objects.toString(first, "");
		}

		// two or more elements
		final StringBuilder buf = new StringBuilder(STRING_BUILDER_SIZE); // Java default is 16, probably too small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	public static String join(final List<?> list, final char separator, final int startIndex, final int endIndex) {
		if (list == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final List<?> subList = list.subList(startIndex, endIndex);
		return join(subList.iterator(), separator);
	}

	public static String join(final List<?> list, final String separator, final int startIndex, final int endIndex) {
		if (list == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final List<?> subList = list.subList(startIndex, endIndex);
		return join(subList.iterator(), separator);
	}


	public static String join(final long[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final long[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}


	public static String join(final Object[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final Object[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		if (array[startIndex] != null) {
			buf.append(array[startIndex]);
		}
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	public static String join(final Object[] array, final String separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final Object[] array, String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		if (separator == null) {
			separator = EMPTY;
		}

		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}

		final StringBuilder buf = newStringBuilder(noOfItems);

		if (array[startIndex] != null) {
			buf.append(array[startIndex]);
		}

		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);

			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	public static String join(final short[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(final short[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static int length(final CharSequence cs) {
		return cs == null ? 0 : cs.length();
	}

	private static StringBuilder newStringBuilder(final int noOfItems) {
		return new StringBuilder(noOfItems * 16);
	}

	public static boolean startWithIgnoreEquals(CharSequence str, CharSequence prefix) {
		return startWith(str, prefix, false, true);
	}

	/**
	 * 是否以指定字符串开头，忽略大小写
	 *
	 * @param str    被监测字符串
	 * @param prefix 开头字符串
	 * @return 是否以指定字符串开头
	 */
	public static boolean startWithIgnoreCase(CharSequence str, CharSequence prefix) {
		return startWith(str, prefix, true);
	}

	public static boolean startWith(CharSequence str, CharSequence prefix, boolean ignoreCase) {
		return startWith(str, prefix, ignoreCase, false);
	}

	/**
	 * 是否以指定字符串开头<br>
	 * 如果给定的字符串和开头字符串都为null则返回true，否则任意一个值为null返回false<br>
	 * <pre>
	 *     CharSequenceUtil.startWith("123", "123", false, true);   -- false
	 *     CharSequenceUtil.startWith("ABCDEF", "abc", true, true); -- true
	 *     CharSequenceUtil.startWith("abc", "abc", true, true);    -- false
	 * </pre>
	 *
	 * @param str          被监测字符串
	 * @param prefix       开头字符串
	 * @param ignoreCase   是否忽略大小写
	 * @param ignoreEquals 是否忽略字符串相等的情况
	 * @return 是否以指定字符串开头
	 * @since 5.4.3
	 */
	public static boolean startWith(CharSequence str, CharSequence prefix, boolean ignoreCase, boolean ignoreEquals) {
		if (null == str || null == prefix) {
			if (ignoreEquals) {
				return false;
			}
			return null == str && null == prefix;
		}

		boolean isStartWith = str.toString()
				.regionMatches(ignoreCase, 0, prefix.toString(), 0, prefix.length());

		if (isStartWith) {
			return (false == ignoreEquals) || (false == equals(str, prefix, ignoreCase));
		}
		return false;
	}
	public static boolean equals(CharSequence str1, CharSequence str2, boolean ignoreCase) {
		if (null == str1) {
			// 只有两个都为null才判断相等
			return str2 == null;
		}
		if (null == str2) {
			// 字符串2空，字符串1非空，直接false
			return false;
		}

		if (ignoreCase) {
			return str1.toString().equalsIgnoreCase(str2.toString());
		} else {
			return str1.toString().contentEquals(str2);
		}
	}

}
