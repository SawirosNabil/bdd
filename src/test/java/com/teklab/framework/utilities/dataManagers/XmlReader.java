package com.teklab.framework.utilities.dataManagers;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlReader {


	public static Document getData(String filePath) {
		File inputFile = new File(System.getProperty("user.dir") + filePath);
		SAXReader saxReader = new SAXReader();
		Document document = null;

		try {
			document = saxReader.read(inputFile); // read the locators.xml
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
}


































