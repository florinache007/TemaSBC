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

import com.tema.model.Manager;
import com.tema.model.Player;
import com.tema.model.Rule;
import com.tema.parser.ReadXMLFile;
import com.tema.rules.RulesFcn;

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
				r.setWho(eElement.getElementsByTagName("who").item(0).getTextContent());
				
				
				
				rules.add(r);
				
				
			}
		}
		

		NodeList nList3 = d.getElementsByTagName("manager");
		
		ArrayList<Manager> managers = new ArrayList<>();
		
		for (int temp = 0; temp < nList3.getLength(); temp++) {
			
			
			
			Node nNode = nList3.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Manager m = new Manager();
				Element eElement = (Element) nNode;
				
				m.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				m.setTeam(eElement.getElementsByTagName("team").item(0).getTextContent());
				m.setFootball_gender(eElement.getElementsByTagName("football_gender").item(0).getTextContent());
				
				managers.add(m);
				
			}
		}
		
		
		model.addAttribute("players",players);
		model.addAttribute("managers", managers);

		
		RulesFcn theRules = new RulesFcn();
		
		//Rule 1
		if(request.getParameter("rule1") != null){
			model.addAttribute("rule1",theRules.rule1(request.getParameter("rule1"),rules,players));
		}
		
		
		//Rule 2
		if(request.getParameter("rule2") != null){
			model.addAttribute("rule2",theRules.rule2(request.getParameter("rule2"),rules,players));
		}
		
		//Rule 3
		if(request.getParameter("rule3") != null){
			model.addAttribute("rule3",theRules.rule3(request.getParameter("rule3"),rules,players));
		}
		
		//Rule 4
		if(request.getParameter("rule4") != null){
			model.addAttribute("rule4",theRules.rule4(request.getParameter("rule4"),rules,players));
		}
		
		//Rule 5
		if(request.getParameter("rule5") != null){
			model.addAttribute("rule5",theRules.rule5(request.getParameter("rule5"),rules,players,managers));
		}
		
		
		//Rule 6
		if(request.getParameter("rule6") != null){
			System.out.println(theRules.rule6(request.getParameter("rule6"),rules,players,managers));
			model.addAttribute("rule6",theRules.rule6(request.getParameter("rule6"),rules,players,managers));
		}
				
		return "index";
	}
	
	

}
