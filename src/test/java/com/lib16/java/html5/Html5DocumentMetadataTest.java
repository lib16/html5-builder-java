package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lib16.java.utils.enums.IconType;
import com.lib16.java.xml.shared.MediaAttribute.Media;
import com.lib16.java.xml.shared.TargetAttribute.Target;

public class Html5DocumentMetadataTest
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			{
				Html5.createSub().head(),
				"<head>\n\t<meta charset=\"UTF-8\">\n</head>"
			},
			{
				Html5.createSub().title("content"),
				"<title>content</title>"
			},
			{
				Html5.createSub().base(null, Target.PARENT),
				"<base target=\"_parent\">"
			},
			{
				Html5.createSub().base("../"),
				"<base href=\"../\">"
			},
			{
				Html5.createSub().stylesheet("style.css"),
				"<link rel=\"stylesheet\" href=\"style.css\">"
			},
			{
				Html5.createSub().stylesheet("screen.css", Media.SCREEN),
				"<link rel=\"stylesheet\" href=\"screen.css\" media=\"screen\">"
			},
			{
				Html5.createSub().stylesheet("contrast.css", null, "High Contrast"),
				"<link"
						+ " rel=\"alternate stylesheet\" href=\"contrast.css\""
						+ " title=\"High Contrast\">"
			},
			{
				Html5.createSub().stylesheet("contrast.css", Media.SCREEN, "High Contrast"),
				"<link"
						+ " rel=\"alternate stylesheet\" href=\"contrast.css\""
						+ " media=\"screen\" title=\"High Contrast\">"
			},
			{
				Html5.createSub().atom("feed.xml"),
				"<link"
						+ " rel=\"alternate\" href=\"feed.xml\""
						+ " type=\"application/atom+xml\">"
			},
			{
				Html5.createSub().atom("feed.xml", "Atom Feed"),
				"<link"
						+ " rel=\"alternate\" href=\"feed.xml\""
						+ " type=\"application/atom+xml\" title=\"Atom Feed\">"
			},
			{
				Html5.createSub().rss("feed.xml"),
				"<link"
						+ " rel=\"alternate\" href=\"feed.xml\""
						+ " type=\"application/rss+xml\">"
			},
			{
				Html5.createSub().rss("feed.xml", "RSS Feed"),
				"<link"
						+ " rel=\"alternate\" href=\"feed.xml\""
						+ " type=\"application/rss+xml\" title=\"RSS Feed\">"
			},
			{
				Html5.createSub().icon("favicon.ico", IconType.ICO),
				"<link"
						+ " rel=\"icon\" href=\"favicon.ico\""
						+ " type=\"image/vnd.microsoft.icon\">"
			},
			{
				Html5.createSub().icon("favicon.ico", IconType.ICO, "16x16 32x32"),
				"<link"
						+ " rel=\"icon\" href=\"favicon.ico\""
						+ " type=\"image/vnd.microsoft.icon\" sizes=\"16x16 32x32\">"
			},
			{
				Html5.createSub().meta("my-name", "my content"),
				"<meta name=\"my-name\" content=\"my content\">"
			},
			{
				Html5.createSub().applicationName("MyApp"),
				"<meta name=\"application-name\" content=\"MyApp\">"
			},
			{
				Html5.createSub().description("Lorem Ipsum Dolor"),
				"<meta name=\"description\" content=\"Lorem Ipsum Dolor\">"
			},
			{
				Html5.createSub().author("M. E. Lee"),
				"<meta name=\"author\" content=\"M. E. Lee\">"
			},
			{
				Html5.createSub().generator("Lib16 HTML5 Builder"),
				"<meta name=\"generator\" content=\"Lib16 HTML5 Builder\">"
			},
			{
				Html5.createSub().keywords("lorem, ipsum, dolor"),
				"<meta name=\"keywords\" content=\"lorem, ipsum, dolor\">"
			},
			{
				Html5.createSub().pragma("refresh", "10"),
				"<meta http-equiv=\"refresh\" content=\"10\">"
			},
			{
				Html5.createSub().refresh(0, "index.php"),
				"<meta http-equiv=\"refresh\" content=\"0; URL=index.php\">"
			},
			{
				Html5.createSub().refresh(10),
				"<meta http-equiv=\"refresh\" content=\"10\">"
			},
			{
				Html5.createSub().charset(),
				"<meta charset=\"UTF-8\">"
			},
			{
				Html5.createSub().body().style("h1 {\n\tfont-size: 20px;\n}"),
				"<body>\n\t<style>\n\t\th1 {\n\t\t\tfont-size: 20px;\n\t\t}"
						+ "\n\t</style>\n</body>"
			},
			{
				Html5.createSub().body().script("/*\n *\n */"),
				"<body>\n\t<script>\n\t\t/*\n\t\t *\n\t\t */"
						+ "\n\t</script>\n</body>"
			},

		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
