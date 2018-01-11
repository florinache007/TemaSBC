package com.tema;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(ModelMap model) throws ParserConfigurationException, SAXException, IOException {
		ReadXMLFile read = new ReadXMLFile();
		
		Document d = read.parseXML("C:\\Users\\Florin\\Desktop\\tema_2@sbc\\TemaSBC\\fotbal.xml");
		
		NodeList nList = d.getElementsByTagName("player");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Staff id : " + eElement.getAttribute("player"));
				System.out.println("First Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("gender").item(0).getTextContent());

			}
		}
		
		model.addAttribute("ceva","ceva");
		return "index";
	}

}
