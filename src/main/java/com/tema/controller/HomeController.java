package com.tema.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tema.model.Player;
import com.tema.model.Rule;
import com.tema.parser.ReadXMLFile;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(ModelMap model, HttpServletRequest request) throws ParserConfigurationException, SAXException, IOException {
		ReadXMLFile read = new ReadXMLFile();
		
		Document d = read.parseXML("fotbal.xml");
		
		NodeList nList = d.getElementsByTagName("player");
		
		ArrayList<Player> players = new ArrayList<>();
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Player p = new Player();
				Element eElement = (Element) nNode;
				
				
				p.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				p.setAge(Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent()));
				p.setGender(eElement.getElementsByTagName("gender").item(0).getTextContent());
				p.setTeam(eElement.getElementsByTagName("team").item(0).getTextContent());
				p.setGoldenBall(eElement.getElementsByTagName("golden_ball").item(0).getTextContent());
				players.add(p);
				

			}
		}
		
		NodeList nList2 = d.getElementsByTagName("rule");
		
		ArrayList<Rule> rules = new ArrayList<>();
		
		for (int temp = 0; temp < nList2.getLength(); temp++) {
			
			
			
			Node nNode = nList2.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Rule r = new Rule();
				Element eElement = (Element) nNode;
				
				r.setHow1(eElement.getElementsByTagName("how").item(0).getTextContent());
				r.setHow2(eElement.getElementsByTagName("how").item(1).getTextContent());
				r.setIs(eElement.getElementsByTagName("is").item(0).getTextContent());
				r.setOp(eElement.getElementsByTagName("op").item(0).getTextContent());
				r.setRule_nr(Integer.parseInt(eElement.getElementsByTagName("rule_nr").item(0).getTextContent()));
				r.setThan1(eElement.getElementsByTagName("than").item(0).getTextContent());
				r.setThan2(eElement.getElementsByTagName("than").item(1).getTextContent());
				r.setWhat1(eElement.getElementsByTagName("what").item(0).getTextContent());
				r.setWhat2(eElement.getElementsByTagName("what").item(1).getTextContent());
				
				rules.add(r);
				
				
			}
		}
		
		
		model.addAttribute("players",players);
		model.addAttribute("rules", rules);
		
		
		//Rule 1
		if(request.getParameter("rule1") != null){
			Rule r = null;
			for(Rule r1:rules){
				if(r1.getRule_nr() == 1){
					
					r = r1;
					
				}
			}
			
			Player p = null;
			for(Player p1 : players){
				if(p1.getName().equals(request.getParameter("rule1"))){
					p=p1;
				}
			}
			
			boolean test1 = false;
			boolean test2 = false;
			
			if(r.getWhat1().equals("golden_ball")){
				if(r.getHow1().equals("greater")){
					if(Integer.parseInt(p.getGoldenBall()) > Integer.parseInt(r.getThan1())){
						test1 = true;
					}
					
				}
			}
			if(r.getWhat2().equals("gender")){
				if(r.getHow2().equals("equals")){
					if(p.getGender().equals(r.getThan2()))
						test2 = true;
				}
			}
			
			if(test1 && test2)
				model.addAttribute("rule1", p.getName()+" is one of the "+r.getIs()+"!");
		}
		
		
		return "index";
	}
	
	

}
