package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Html5SectionsTest
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			{Html5.createSub().body(), "<body>"},
			{Html5.createSub().article(), "<article>"},
			{Html5.createSub().section(), "<section>"},
			{Html5.createSub().nav(), "<nav>"},
			{Html5.createSub().aside(), "<aside>"},
			{Html5.createSub().h1("content"), "<h1>content</h1>"},
			{Html5.createSub().h1(), "<h1></h1>"},
			{Html5.createSub().h2("content"), "<h2>content</h2>"},
			{Html5.createSub().h2(), "<h2></h2>"},
			{Html5.createSub().h3("content"), "<h3>content</h3>"},
			{Html5.createSub().h3(), "<h3></h3>"},
			{Html5.createSub().h4("content"), "<h4>content</h4>"},
			{Html5.createSub().h4(), "<h4></h4>"},
			{Html5.createSub().h5("content"), "<h5>content</h5>"},
			{Html5.createSub().h5(), "<h5></h5>"},
			{Html5.createSub().h6("content"), "<h6>content</h6>"},
			{Html5.createSub().h6(), "<h6></h6>"},
			{Html5.createSub().hgroup(), "<hgroup>"},
			{Html5.createSub().header(), "<header>"},
			{Html5.createSub().footer(), "<footer>"},
			{Html5.createSub().address(), "<address>"},
		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
