package com.lib16.java.html5;

import com.lib16.java.utils.NumberFormatter;
import com.lib16.java.xml.XmlProperties;

public class DefaultHtml5Properties extends XmlProperties implements Html5Properties
{
	@Override
	public String getMimeType()
	{
		return "text/html";
	}

	@Override
	public String getFilenameExtension()
	{
		return "html";
	}

	@Override
	public boolean xmlDeclarationEnabled()
	{
		return false;
	}

	@Override
	public String getDoctype()
	{
		return "<!DOCTYPE html>";
	}

	@Override
	public boolean htmlModeEnabled()
	{
		return true;
	}

	@Override
	public NumberFormatter getFormatter()
	{
		return NumberFormatter.DEFAULT_FORMATTER;
	}
}
