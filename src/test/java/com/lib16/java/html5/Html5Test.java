package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Html5Test
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			{Html5.createHtml(), "<!DOCTYPE html>\n<html>"},
			{
				Html5.createHtml("en", "app.manifest"),
				"<!DOCTYPE html>\n<html lang=\"en\" manifest=\"app.manifest\">"
			},
			{
				Html5.createHtml(Html5.XHTML5_PROPERTIES),
				"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\"/>"
			},
			{
				Html5.createHtml(Html5.XHTML5_PROPERTIES, "en", "app.manifest"),
				"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\""
				+ " xml:lang=\"en\" manifest=\"app.manifest\"/>"
			},
			{
				Html5.createSub(Html5.HTML5_PROPERTIES).head(),
				"<head>\n\t<meta charset=\"UTF-8\">\n</head>"
			},
			{Html5.createSub(Html5.XHTML5_PROPERTIES).head(), "<head/>"}
		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
