package cn.itcast.video.tool;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class XmlTool {
	/**
	 * 返回只有一个元素的xml
	 * @param rootEmtName 元素名
	 * @param attrName 属性名
	 * @param attrValue 属性值
	 */
	public static String xml(String rootEmtName, String attrName, String attrValue)
	{
		Element root = new Element(rootEmtName);
		root.setAttribute(attrName, attrValue);
		Document doc = new Document(root);
		XMLOutputter output = new XMLOutputter();
		return output.outputString(doc);
	}
	
	/**
	 * 返回只有一个元素的xml
	 * @param rootEmtName 元素名
	 * @param text 元素内容
	 */
	public static String xml(String rootEmtName, String text)
	{
		Element root = new Element(rootEmtName);
		root.setText(text);
		Document doc = new Document(root);
		XMLOutputter output = new XMLOutputter();
		return output.outputString(doc);
	}
}
