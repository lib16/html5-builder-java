package com.lib16.java.html5;

import org.apache.commons.lang3.StringEscapeUtils;

import com.lib16.java.utils.NumberFormatter;
import com.lib16.java.xml.Attributes;
import com.lib16.java.xml.Language;
import com.lib16.java.xml.Xml;
import com.lib16.java.xml.shared.ClassAttribute;
import com.lib16.java.xml.shared.MediaAttribute;
import com.lib16.java.xml.shared.MediaAttribute.Media;
import com.lib16.java.xml.shared.TargetAttribute;
import com.lib16.java.xml.shared.TargetAttribute.Target;

public final class Html5 implements Language
{
	Xml xml;

	private Html5(Xml xml)
	{
		this.xml = xml;
	}

	public static Html5 create(Xml xml)
	{
		return new Html5(xml);
	}

	public Html5 parent()
	{
		return new Html5(xml.getParent());
	}

	@Override
	public String toString()
	{
		return xml.getRoot().getMarkup();
	}

	//////// Document metadata ////////

	public Html5 head()
	{
		return new Html5(xml.append("head", "")).charset().parent(); // TODO parent()!!!
	}

	public Html5 title(String title)
	{
		return new Html5(xml.append("title", title));
	}

	public Html5 base(String href)
	{
		return base(href, null);
	}

	public Html5 base(String href, Target target)
	{
		return new Html5(xml.append("base")).setHref(href).setTarget(target);
	}

	public Html5 meta(String name, String content)
	{
		return new Html5(xml.append("meta").setAttributes(new Attributes()
				.set("name", name)
				.set("content", content)));
	}

	public Html5 applicationName(String applicationName)
	{
		return meta("application-name", applicationName);
	}

	public Html5 author(String author)
	{
		return meta("author", author);
	}

	public Html5 description(String description)
	{
		return meta("description", description);
	}

	public Html5 generator(String generator)
	{
		return meta("generator", generator);
	}

	public Html5 keywords(String... keywords)
	{
		Html5 element = new Html5(xml.append("meta"));
		element.xml.getAttributes()
				.set("name", "keywords")
				.setComplex("content", ",", true, keywords);
		return element;
	}

	public Html5 pragma(String httpEquiv, String content)
	{
		Html5 element = new Html5(xml.append("meta"));
		element.xml.getAttributes()
				.set("http-equiv", httpEquiv)
				.set("content", content);
		return element;
	}

	public Html5 refresh(int seconds, String url)
	{
		String refresh = Integer.toString(seconds);
		if (url != null && !url.isEmpty()) {
			refresh += "; URL=" + url;
		}
		return pragma("refresh", refresh);
	}

	public Html5 refresh(int seconds)
	{
		return refresh(seconds, null);
	}

	public Html5 charset()
	{
		if (!xml.getLanguageProperties().htmlModeEnabled()) return this;
		Html5 element = new Html5(xml.append("meta"));
		element.xml.getAttributes()
				.set("charset", xml.getLanguageProperties().getCharacterEncoding());
		return element;
	}

	//////// Sections ////////

	public Html5 body()
	{
		return new Html5(xml.append("body"));
	}

	public Html5 article()
	{
		return new Html5(xml.append("article"));
	}

	public Html5 section()
	{
		return new Html5(xml.append("section"));
	}

	public Html5 nav()
	{
		return new Html5(xml.append("nav"));
	}

	public Html5 aside()
	{
		return new Html5(xml.append("aside"));
	}

	public Html5 h1(String content)
	{
		return new Html5(xml.append("h1", content));
	}

	public Html5 h1()
	{
		return h1("");
	}


	public Html5 h2(String content)
	{
		return new Html5(xml.append("h2", content));
	}

	public Html5 h2()
	{
		return h2("");
	}

	public Html5 h3(String content)
	{
		return new Html5(xml.append("h3", content));
	}

	public Html5 h3()
	{
		return h3("");
	}

	public Html5 h4(String content)
	{
		return new Html5(xml.append("h4", content));
	}

	public Html5 h4()
	{
		return h4("");
	}


	public Html5 h5(String content)
	{
		return new Html5(xml.append("h5", content));
	}

	public Html5 h5()
	{
		return h5("");
	}


	public Html5 h6(String content)
	{
		return new Html5(xml.append("h6", content));
	}

	public Html5 h6()
	{
		return h6("");
	}

	public Html5 hgroup()
	{
		return new Html5(xml.append("hgroup"));
	}

	public Html5 header()
	{
		return new Html5(xml.append("header"));
	}

	public Html5 footer()
	{
		return new Html5(xml.append("footer"));
	}

	public Html5 address()
	{
		return new Html5(xml.append("address"));
	}

	//////// Grouping Content ////////

	public Html5 p(String... content)
	{
		return new Html5(xml.append("p", content));
	}

	public Html5 p()
	{
		return p("");
	}

	public Html5 hr()
	{
		return new Html5(xml.append("hr"));
	}

	public Html5 pre(String content)
	{
		return new Html5(xml.append("pre", content).disableTextIndentation());
	}

	public Html5 blockquote(String content, String cite)
	{
		return new Html5(xml.append("blockquote", content)).setCite(cite);
	}

	public Html5 blockquote(String content)
	{
		return blockquote(content, null);
	}

	public Html5 blockquote()
	{
		return blockquote("");
	}

	public Html5 ol(Type type, Integer start, boolean reversed)
	{
		return new Html5(xml.append("ol"))
				.setType(type)
				.setStart(start)
				.setReversed(reversed);
	}

	public Html5 ol(Type type, Integer start)
	{
		return ol(type, start, false);
	}

	public Html5 ol(Type type)
	{
		return ol(type, null);
	}

	public Html5 ol()
	{
		return ol(null);
	}

	public Html5 ul()
	{
		return new Html5(xml.append("ul"));
	}

	public Html5 li(String content, Integer value)
	{
		return new Html5(xml.append("li", content)).setValue(value);
	}

	public Html5 li(String content)
	{
		return li(content, null);
	}

	public Html5 li()
	{
		return li("");
	}


	public Html5 dl()
	{
		return new Html5(xml.append("dl"));
	}

	public Html5 dt(String content)
	{
		return new Html5(xml.append("dt", content));
	}

	public Html5 dt()
	{
		return dt("");
	}

	public Html5 dd(String content)
	{
		return new Html5(xml.append("dd", content));
	}

	public Html5 dd()
	{
		return dd("");
	}


	public Html5 figure()
	{
		return new Html5(xml.append("figure"));
	}

	public Html5 figcaption(String content)
	{
		return new Html5(xml.append("figcaption", content));
	}

	public Html5 figcaption()
	{
		return figcaption("");
	}

	public Html5 main()
	{
		return new Html5(xml.append("main"));
	}

	public Html5 div(String content)
	{
		return new Html5(xml.append("div", content));
	}

	public Html5 div()
	{
		return div("");
	}

	//////// Text-level semantics ////////

	public Html5 a(String content, String href, Target target)
	{
		Html5 element = new Html5(xml.append("a", content)).setHref(href);
		element.getXml().getAttributes().setNull("rel", "type", "hreflang", "download");
		element.setTarget(target);
		element.getXml().getAttributes().setNull("ping");
		return element;
	}

	public Html5 a(String content, String href)
	{
		return a(content, href, null);
	}

	public Html5 a(String href)
	{
		return a(null, href);
	}

	public Html5 em(String content)
	{
		return new Html5(xml.append("em", content));
	}

	public Html5 em()
	{
		return em("");
	}

	public Html5 strong(String content)
	{
		return new Html5(xml.append("strong", content));
	}

	public Html5 strong()
	{
		return strong("");
	}

	public Html5 small(String content)
	{
		return new Html5(xml.append("small", content));
	}

	public Html5 small()
	{
		return small("");
	}

	public Html5 s(String content)
	{
		return new Html5(xml.append("s", content));
	}

	public Html5 s()
	{
		return s("");
	}

	public Html5 cite(String content)
	{
		return new Html5(xml.append("cite", content));
	}

	public Html5 cite()
	{
		return cite("");
	}

	public Html5 q(String content, String cite)
	{
		return new Html5(xml.append("q", content)).setCite(cite);
	}

	public Html5 q(String content)
	{
		return q(content, null);
	}

	public Html5 q()
	{
		return q("");
	}

	public Html5 dfn(String content, String title)
	{
		return new Html5(xml.append("dfn", content)).setTitle(title);
	}

	public Html5 dfn(String content)
	{
		return dfn(content, null);
	}

	public Html5 dfn()
	{
		return dfn("");
	}

	public Html5 abbr(String content, String title)
	{
		return new Html5(xml.append("abbr", content)).setTitle(title);
	}

	public Html5 abbr(String content)
	{
		return abbr(content, null);
	}

	public Html5 abbr()
	{
		return abbr("");
	}

	public Html5 data(String content, String value)
	{
		return new Html5(xml.append("data", content)).setValue(value);
	}

	public Html5 data(String value)
	{
		return data("", value);
	}

	public Html5 time(String content, String datetime)
	{
		return new Html5(xml.append("time", content))
				.setDatetime(datetime == content ? null : datetime);
	}

	public Html5 time(String content)
	{
		return time(content, null);
	}

	public Html5 code(String content)
	{
		return new Html5(xml.append("code", content));
	}

	public Html5 code()
	{
		return code("");
	}

	/**
	 * Appends a {@code code} element nested in a {@code pre} element.
	 *
	 * Each tab is replaced with 4 spaces.
	 */
	public Html5 codeblock(String content)
	{
		return codeblock(content, "    ");
	}

	/**
	 * Appends a {@code code} element nested in a {@code pre} element.
	 *
	 * @param  tabReplacement Replacement for {@code \t}.
	 */
	public Html5 codeblock(String content, String tabReplacement)
	{
		String source = tabReplacement != null ? content.replace("\t", tabReplacement) : content;
		source = StringEscapeUtils.escapeXml10(source);
		return new Html5(xml.append("pre")
				.disableLineBreak()
				.disableTextIndentation()
				.append("code", source));
	}

	public Html5 var(String content)
	{
		return new Html5(xml.append("var", content));
	}

	public Html5 var()
	{
		return var("");
	}

	public Html5 samp(String content)
	{
		return new Html5(xml.append("samp", content));
	}

	public Html5 samp()
	{
		return samp("");
	}

	public Html5 kbd(String content)
	{
		return new Html5(xml.append("kbd", content));
	}

	public Html5 kbd()
	{
		return kbd("");
	}

	public Html5 sub(String content)
	{
		return new Html5(xml.append("sub", content));
	}

	public Html5 sub()
	{
		return sub("");
	}

	public Html5 sup(String content)
	{
		return new Html5(xml.append("sup", content));
	}

	public Html5 sup()
	{
		return sup("");
	}

	public Html5 i(String content)
	{
		return new Html5(xml.append("i", content));
	}

	public Html5 i()
	{
		return i("");
	}

	public Html5 b(String content)
	{
		return new Html5(xml.append("b", content));
	}

	public Html5 b()
	{
		return b("");
	}

	public Html5 u(String content)
	{
		return new Html5(xml.append("u", content));
	}

	public Html5 u()
	{
		return u("");
	}

	public Html5 mark(String content)
	{
		return new Html5(xml.append("mark", content));
	}

	public Html5 mark()
	{
		return mark("");
	}

	public Html5 ruby(String content)
	{
		return new Html5(xml.append("ruby", content));
	}

	public Html5 ruby()
	{
		return ruby("");
	}

	public Html5 rt(String content)
	{
		return new Html5(xml.append("rt", content));
	}

	public Html5 rt()
	{
		return rt("");
	}

	public Html5 rp(String content)
	{
		return new Html5(xml.append("rp", content));
	}

	public Html5 rp()
	{
		return rp("");
	}

	public Html5 bdi(String content, Dir dir)
	{
		return new Html5(xml.append("bdi", content)).setDir(dir);
	}

	public Html5 bdi(String content)
	{
		return bdi(content, null);
	}

	public Html5 bdi()
	{
		return bdi("");
	}

	public Html5 bdo(String content, Dir dir)
	{
		return new Html5(xml.append("bdo", content)).setDir(dir);
	}

	public Html5 bdo(String content)
	{
		return bdo(content, null);
	}

	public Html5 bdo()
	{
		return bdo("");
	}

	public Html5 span(String content)
	{
		return new Html5(xml.append("span", content));
	}

	public Html5 span()
	{
		return span("");
	}

	public Html5 br()
	{
		return new Html5(xml.append("br"));
	}

	public Html5 wbr()
	{
		return new Html5(xml.append("wbr"));
	}

	//////// Edits ////////

	public Html5 ins(String content, String datetime, String cite)
	{
		return new Html5(xml.append("ins", content))
				.setCite(cite)
				.setDatetime(datetime);
	}

	public Html5 del(String content, String datetime, String cite)
	{
		return new Html5(xml.append("del", content))
				.setCite(cite)
				.setDatetime(datetime);
	}

	//////// Attributes ////////

	public Html5 setCite(String cite)
	{
		xml.getAttributes().set("cite", cite);
		return this;
	}

	public Html5 setClass(String... classes)
	{
		ClassAttribute.setClass(xml, classes);
		return this;
	}

	public Html5 stripes(String... classes)
	{
		ClassAttribute.stripes(xml, classes);
		return this;
	}

	public Html5 stripes(int column, String... classes)
	{
		ClassAttribute.stripes(xml, column, classes);
		return this;
	}

	public Html5 setDatetime(String datetime)
	{
		xml.getAttributes().set("datetime", datetime);
		return this;
	}

	public enum Dir
	{
		LTR, RTL, AUTO;

		private String str;

		private Dir()
		{
			str = name().toLowerCase();
		}

		@Override
		public String toString()
		{
			return str;
		};
	}

	public Html5 setDir(Dir dir)
	{
		xml.getAttributes().setEnum("dir", dir);
		return this;
	}

	public Html5 setDownload()
	{
		return setDownload(true);
	}

	public Html5 setDownload(boolean download)
	{
		xml.getAttributes().setBoolean("download", download);
		return this;
	}

	public Html5 setDownload(String download)
	{
		xml.getAttributes().set("download", download);
		return this;
	}

	public Html5 setHref(String href)
	{
		xml.getAttributes().set("href", href);
		return this;
	}

	public Html5 setHreflang(String language)
	{
		xml.getAttributes().set("hreflang", language);
		return this;
	}

	public Html5 setMedia(Media... media)
	{
		MediaAttribute.setMedia(xml, media);
		return this;
	}

	public Html5 setPing(String... urls)
	{
		xml.getAttributes().setComplex("ping", " ", false, urls);
		return this;
	}

	public enum Rel
	{
		ALTERNATE, AUTHOR, BOOKMARK, EXTERNAL, HELP, ICON, LICENSE, NEXT,
		NOFOLLOW, NOREFERRER, NOOPENER, PINGBACK, PREFETCH, PREV, SEARCH,
		SIDEBAR, STYLESHEET, TAG;

		private String str;

		private Rel()
		{
			str = name().toLowerCase();
		}

		@Override
		public String toString()
		{
			return str;
		};
	}

	public Html5 setRel(Rel... rel)
	{
		for (Rel r: rel) {
			xml.getAttributes().setComplex("rel", " ", true, r.toString());
		}
		return this;
	}

	public Html5 setReversed()
	{
		return setReversed(true);
	}

	public Html5 setReversed(boolean reversed)
	{
		xml.getAttributes().setBoolean("reversed", reversed);
		return this;
	}

	public Html5 setSizes(String sizes)
	{
		xml.getAttributes().set("sizes", sizes);
		return this;
	}

	public Html5 setStart(Integer start)
	{
		xml.getAttributes().setNumber("start", start, getFormatter());
		return this;
	}

	public Html5 setTarget(Target target)
	{
		TargetAttribute.setTarget(xml, target);
		return this;
	}

	public Html5 setTarget(String target)
	{
		TargetAttribute.setTarget(xml, target);
		return this;
	}

	public Html5 setTitle(String title)
	{
		xml.getAttributes().set("title", title);
		return this;
	}

	public enum Type
	{
		DECIMAL("1"), LOWER_ALPHA("a"), UPPER_ALPHA("A"), LOWER_ROMAN("i"), UPPER_ROMAN("I");

		public String str;

		private Type(String str)
		{
			this.str = str;
		}

		@Override
		public String toString()
		{
			return str;
		}
	}

	public Html5 setType(String type)
	{
		xml.getAttributes().set("type", type);
		return this;
	}

	public Html5 setType(Type type)
	{
		xml.getAttributes().setEnum("type", type);
		return this;
	}

	public Html5 setValue(String value)
	{
		xml.getAttributes().set("value", value);
		return this;
	}

	public Html5 setValue(Integer value)
	{
		xml.getAttributes().setNumber("value", value, getFormatter());
		return this;
	}

	public static Html5 createHtml5()
	{
		Xml xml = Xml.createRoot("html", new DefaultHtml5Properties());
		Html5 html = new Html5(xml);
		return html;
	}

	public static Html5 createSub()
	{
		return new Html5(Xml.createSub(new DefaultHtml5Properties()));
	}

	@Override
	public Xml getXml()
	{
		return xml;
	}

	private NumberFormatter getFormatter()
	{
		return ((Html5Properties) xml.getLanguageProperties()).getFormatter();
	}
}

