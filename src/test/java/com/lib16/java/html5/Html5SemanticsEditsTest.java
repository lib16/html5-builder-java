package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lib16.java.html5.Html5.Dir;
import com.lib16.java.xml.shared.TargetAttribute.Target;

public class Html5SemanticsEditsTest
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			{
				Html5.createSub().a("http://...").em("content"),
				"<a href=\"http://...\">\n\t<em>content</em>\n</a>"
			},
			{
				Html5.createSub().a("content", "http://..."),
				"<a href=\"http://...\">content</a>"
			},
			{
				Html5.createSub().a("content", "http://...", Target.BLANK),
				"<a href=\"http://...\" target=\"_blank\">content</a>"
			},
			{Html5.createSub().em("content"), "<em>content</em>"},
			{Html5.createSub().em(), "<em></em>"},
			{Html5.createSub().strong("content"), "<strong>content</strong>"},
			{Html5.createSub().strong(), "<strong></strong>"},
			{Html5.createSub().small("content"), "<small>content</small>"},
			{Html5.createSub().small(), "<small></small>"},
			{Html5.createSub().s("content"), "<s>content</s>"},
			{Html5.createSub().s(), "<s></s>"},
			{Html5.createSub().cite("content"), "<cite>content</cite>"},
			{Html5.createSub().cite(), "<cite></cite>"},
			{Html5.createSub().q("content", "http://..."), "<q cite=\"http://...\">content</q>"},
			{Html5.createSub().q("content"), "<q>content</q>"},
			{Html5.createSub().q(), "<q></q>"},
			{Html5.createSub().dfn("content", "Title"), "<dfn title=\"Title\">content</dfn>"},
			{Html5.createSub().dfn("content"), "<dfn>content</dfn>"},
			{Html5.createSub().dfn(), "<dfn></dfn>"},
			{
				Html5.createSub().abbr("CPU", "Central Processing Unit"),
				"<abbr title=\"Central Processing Unit\">CPU</abbr>"
			},
			{Html5.createSub().abbr("CPU"), "<abbr>CPU</abbr>"},
			{Html5.createSub().abbr(), "<abbr></abbr>"},
			{Html5.createSub().data("ten", "10"), "<data value=\"10\">ten</data>"},
			{Html5.createSub().data("10"), "<data value=\"10\"></data>"},
			{
				Html5.createSub().time("1.6.2014", "2014-06-01"),
				"<time datetime=\"2014-06-01\">1.6.2014</time>"
			},
			{Html5.createSub().time("2014-06-01", "2014-06-01"), "<time>2014-06-01</time>"},
			{Html5.createSub().time("2014-06-01"), "<time>2014-06-01</time>"},
			{Html5.createSub().code("append()"), "<code>append()</code>"},
			{Html5.createSub().code(), "<code></code>"},
			{
				Html5.createSub()
						.codeblock("<div>\n\t<p>content</p>\n</div>", "  ")
						.getXml().getRoot(),
				"<pre><code>"
				+ "&lt;div&gt;\n  &lt;p&gt;content&lt;/p&gt;\n&lt;/div&gt;"
				+ "</code></pre>"
			},
			{
				Html5.createSub()
						.codeblock("<div>\n\t<p>content</p>\n</div>", null)
						.getXml().getRoot(),
				"<pre><code>"
				+ "&lt;div&gt;\n\t&lt;p&gt;content&lt;/p&gt;\n&lt;/div&gt;"
				+ "</code></pre>"
			},
			{
				Html5.createSub()
						.codeblock("<div>\n\t<p>content</p>\n</div>")
						.setClass("html")
						.getXml().getRoot(),
				"<pre><code class=\"html\">"
				+ "&lt;div&gt;\n    &lt;p&gt;content&lt;/p&gt;\n&lt;/div&gt;"
				+ "</code></pre>"
			},
			{Html5.createSub().var("n"), "<var>n</var>"},
			{Html5.createSub().var(), "<var></var>"},
			{Html5.createSub().samp("content"), "<samp>content</samp>"},
			{Html5.createSub().samp(), "<samp></samp>"},
			{Html5.createSub().kbd("F5"), "<kbd>F5</kbd>"},
			{Html5.createSub().kbd(), "<kbd></kbd>"},
			{Html5.createSub().sub("2"), "<sub>2</sub>"},
			{Html5.createSub().sub(), "<sub></sub>"},
			{Html5.createSub().sup("2"), "<sup>2</sup>"},
			{Html5.createSub().sup(), "<sup></sup>"},
			{Html5.createSub().i("content"), "<i>content</i>"},
			{Html5.createSub().i(), "<i></i>"},
			{Html5.createSub().b("content"), "<b>content</b>"},
			{Html5.createSub().b(), "<b></b>"},
			{Html5.createSub().u("content"), "<u>content</u>"},
			{Html5.createSub().u(), "<u></u>"},
			{Html5.createSub().mark("content"), "<mark>content</mark>"},
			{Html5.createSub().mark(), "<mark></mark>"},
			{Html5.createSub().ruby("☘"), "<ruby>☘</ruby>"},
			{Html5.createSub().ruby(), "<ruby></ruby>"},
			{Html5.createSub().rt("Shamrock"), "<rt>Shamrock</rt>"},
			{Html5.createSub().rt(), "<rt></rt>"},
			{Html5.createSub().rp(":"), "<rp>:</rp>"},
			{Html5.createSub().rp(), "<rp></rp>"},
			{Html5.createSub().bdi("ottO", Dir.RTL), "<bdi dir=\"rtl\">ottO</bdi>"},
			{Html5.createSub().bdi("ottO"), "<bdi>ottO</bdi>"},
			{Html5.createSub().bdi(), "<bdi></bdi>"},
			{Html5.createSub().bdo("ottO", Dir.RTL), "<bdo dir=\"rtl\">ottO</bdo>"},
			{Html5.createSub().bdo("ottO"), "<bdo>ottO</bdo>"},
			{Html5.createSub().bdo(), "<bdo></bdo>"},
			{Html5.createSub().span("content"), "<span>content</span>"},
			{Html5.createSub().span(), "<span></span>"},
			{Html5.createSub().br(), "<br>"},
			{Html5.createSub().wbr(), "<wbr>"},
			{
				Html5.createSub().ins("content", "2014-06-01", "/edits/r123"),
				"<ins cite=\"/edits/r123\" datetime=\"2014-06-01\">content</ins>"
			},
			{
				Html5.createSub().del("content", "2014-06-01", "/edits/r123"),
				"<del cite=\"/edits/r123\" datetime=\"2014-06-01\">content</del>"
			}
		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
