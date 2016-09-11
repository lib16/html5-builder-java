package com.lib16.java.html5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lib16.java.html5.Html5.Dir;
import com.lib16.java.html5.Html5.Rel;
import com.lib16.java.html5.Html5.Type;
import com.lib16.java.xml.shared.MediaAttribute.Media;
import com.lib16.java.xml.shared.TargetAttribute.Target;

public class Html5AttributesTest
{
	@DataProvider(name = "provider")
	public static Object[][] provider()
	{
		return new Object[][]
		{
			// setDir()
			{Html5.createSub().br().setDir(Dir.AUTO), "<br dir=\"auto\">"},
			{Html5.createSub().br().setDir(Dir.LTR), "<br dir=\"ltr\">"},
			{Html5.createSub().br().setDir(Dir.RTL), "<br dir=\"rtl\">"},
			// setDownload()
			{Html5.createSub().br().setDownload(), "<br download>"},
			{Html5.createSub().br().setDownload(true), "<br download>"},
			{Html5.createSub().br().setDownload(false), "<br>"},
			{Html5.createSub().br().setDownload("image.jpg"), "<br download=\"image.jpg\">"},
			// setMedia()
			{
				Html5.createSub().br()
					.setMedia(Media.SCREEN, Media.PRINT)
					.setMedia(Media.TV)
					.setMedia(Media.PRINT),
				"<br media=\"screen,print,tv\">"
			},
			// setPing()
			{
				Html5.createSub().br().setPing("http://example.com/bar", "http://example.com/foo"),
				"<br ping=\"http://example.com/bar http://example.com/foo\">"
			},
			// setRel()
			{
				Html5.createSub().br().setRel(Rel.AUTHOR, Rel.NOFOLLOW, Rel.AUTHOR),
				"<br rel=\"author nofollow\">"
			},
			// setReversed()
			{Html5.createSub().br().setReversed(), "<br reversed>"},
			{Html5.createSub().br().setReversed(true), "<br reversed>"},
			{Html5.createSub().br().setReversed(false), "<br>"},
			// setStart()
			{Html5.createSub().br().setStart(3), "<br start=\"3\">"},
			// setTarget()
			{
				Html5.createSub().br().setTarget(Target.BLANK),
				"<br target=\"_blank\">"
			},
			{
				Html5.createSub().br().setTarget("http://lib16.com"),
				"<br target=\"http://lib16.com\">"
			},
			{
				Html5.createSub().br().setTarget((Target) null),
				"<br>"
			},
			// setType()
			{Html5.createSub().br().setType(Type.DECIMAL), "<br type=\"1\">"},
			{Html5.createSub().br().setType(Type.LOWER_ALPHA), "<br type=\"a\">"},
			{Html5.createSub().br().setType(Type.UPPER_ALPHA), "<br type=\"A\">"},
			{Html5.createSub().br().setType(Type.LOWER_ROMAN), "<br type=\"i\">"},
			{Html5.createSub().br().setType(Type.UPPER_ROMAN), "<br type=\"I\">"},
			{Html5.createSub().br().setType("javascript/text"), "<br type=\"javascript/text\">"},
			{Html5.createSub().br().setType((Type) null), "<br>"},
			// setValue()
			{Html5.createSub().br().setValue(0), "<br value=\"0\">"},
			{Html5.createSub().br().setValue(1), "<br value=\"1\">"},
			{Html5.createSub().br().setValue("foo"), "<br value=\"foo\">"},
		};
	}

	@Test(dataProvider = "provider")
	public void test(Object	actual, String expected)
	{
		Assert.assertEquals(actual.toString(), expected);
	}
}
