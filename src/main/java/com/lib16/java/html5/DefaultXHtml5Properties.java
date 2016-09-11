package com.lib16.java.html5;

public class DefaultXHtml5Properties extends DefaultHtml5Properties
{
	@Override
	public String getMimeType()
	{
		return "application/xhtml+xml";
	}

	@Override
	public boolean xmlDeclarationEnabled()
	{
		return true;
	}

	@Override
	public boolean htmlModeEnabled()
	{
		return false;
	}

	@Override
	public String getXmlNamespace()
	{
		return "http://www.w3.org/1999/xhtml";
	}
}
