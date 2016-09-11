package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lib16.java.html5.Html5.Type;

public class Html5GroupingContentTest
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			{Html5.createSub().p("content 1", "content 2"), "<p>content 1</p>\n<p>content 2</p>"},
			{Html5.createSub().p(), "<p></p>"},
			{Html5.createSub().hr(), "<hr>"},
			{
				Html5.createSub().div().div().pre("no indentation\n\ttab\n  spaces"),
				"<div>\n\t<div>\n\t\t<pre>no indentation\n\ttab\n  spaces</pre>\n\t</div>\n</div>"
			},
			{Html5.createSub().blockquote("content"), "<blockquote>content</blockquote>"},
			{Html5.createSub().blockquote(null, "http://..."), "<blockquote cite=\"http://...\">"},
			{Html5.createSub().blockquote(), "<blockquote></blockquote>"},
			{Html5.createSub().ol(), "<ol>"},
			{Html5.createSub().ol(Type.DECIMAL, 5, true), "<ol type=\"1\" start=\"5\" reversed>"},
			{Html5.createSub().ul(), "<ul>"},
			{Html5.createSub().li("content", 5), "<li value=\"5\">content</li>"},
			{Html5.createSub().li("content"), "<li>content</li>"},
			{Html5.createSub().li(), "<li></li>"},
			{Html5.createSub().dl(), "<dl>"},
			{Html5.createSub().dt("content"), "<dt>content</dt>"},
			{Html5.createSub().dt(), "<dt></dt>"},
			{Html5.createSub().dd("content"), "<dd>content</dd>"},
			{Html5.createSub().dd(), "<dd></dd>"},
			{Html5.createSub().figure(), "<figure>"},
			{Html5.createSub().figcaption("content"), "<figcaption>content</figcaption>"},
			{Html5.createSub().figcaption(), "<figcaption></figcaption>"},
			{Html5.createSub().main(), "<main>"},
			{Html5.createSub().div(), "<div></div>"}
		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
