package com.tema.rules;

import java.util.ArrayList;

import com.tema.model.Manager;
import com.tema.model.Player;
import com.tema.model.Rule;

public class RulesFcn {
	
	
	public String rule1(String player,ArrayList<Rule> rules, ArrayList<Player> players) {
		Rule r = null;
		for(Rule r1:rules){
			if(r1.getRule_nr() == 1){
				
				r = r1;
				
			}
		}
		
		Player p = null;
		for(Player p1 : players){
			if(p1.getName().equals(player)){
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
			return p.getName()+" is one of the "+r.getIs()+"!";
		return null;
	}
	
	public String rule2(String player,ArrayList<Rule> rules, ArrayList<Player> players) {
		Rule r = null;
		for(Rule r2:rules){
			if(r2.getRule_nr() == 2){
				
				r = r2;
				
			}
		}
		
		Player p = null;
		for(Player p1 : players){
			if(p1.getName().equals(player)){
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
			return p.getName()+" is one of the "+r.getIs()+"!";
		return null;
	}
	
	
	public String rule3(String player,ArrayList<Rule> rules, ArrayList<Player> players) {
		Rule r = null;
		for(Rule r3:rules){
			if(r3.getRule_nr() == 3){
				
				r = r3;
				
			}
		}
		
		Player p = null;
		for(Player p1 : players){
			if(p1.getName().equals(player)){
				p=p1;
			}
		}
		
		boolean test1 = false;
		boolean test2 = false;
		
		if(r.getWhat1().equals("golden_ball")){
			if(r.getHow1().equals("greater_eq")){
			
				if(Integer.parseInt(p.getGoldenBall()) >= Integer.parseInt(r.getThan1())){
					test1 = true;
				}
				
			}
		}
		if(r.getWhat2().equals("team")){
			if(r.getHow2().equals("equals")){
				
				if(p.getTeam().equals(r.getThan2())) {
					test2 = true;
				}
			}
		}
		
		if(test1 && test2)
			return p.getName()+" is a "+r.getIs()+"!";
		return null;
	}
	
	
	public String rule4(String player,ArrayList<Rule> rules, ArrayList<Player> players) {
		Rule r = null;
		for(Rule r4:rules){
			if(r4.getRule_nr() == 4){
				
				r = r4;
				
			}
		}
		
		Player p = null;
		for(Player p1 : players){
			if(p1.getName().equals(player)){
				p=p1;
			}
		}
		
		boolean test1 = false;
		boolean test2 = false;
		
		if(r.getWhat1().equals("golden_ball")){
			if(r.getHow1().equals("greater_eq")){
				
				if(Integer.parseInt(p.getGoldenBall()) >= Integer.parseInt(r.getThan1())){
					test1 = true;
				}
				
			}
		}
		if(r.getWhat2().equals("team")){
			
			if(r.getHow2().equals("differs")){
				
				if(!p.getTeam().equals(r.getThan2())) {
					test2 = true;
				}
			}
		}
		
		if(test1 && test2) {
			
			return p.getName()+" "+r.getIs()+" "+p.getTeam()+"!";
		}
		return null;
	}
	
	public String rule5(String player,ArrayList<Rule> rules, ArrayList<Player> players,ArrayList<Manager> managers) {
		Rule r = null;
		for(Rule r5:rules){
			if(r5.getRule_nr() == 5){
				
				r = r5;
				
			}
		}
		
		
			
		
		
		Manager m = null;
		for(Manager m1 : managers){
			if(m1.getName().equals(player)){
				m=m1;
			}
		}
		
		boolean test1 = false;
		boolean test2 = false;
		
		
	for(Player p : players){
		if(r.getWho().equals("team")) {
			
			if(r.getWhat1().equals("manager") && r.getThan1().equals("player"))
				if(m.getTeam().equals(p.getTeam())) {
					test1 = true;
					
				}
			if(r.getWhat2().equals("football_gender") && r.getThan2().equals("gender"))
				if(m.getFootball_gender().equals(p.getGender())) {
					test2 = true;
					
				}
			
		}
		
		if(test1 && test2) {
			return m.getName()+" is the coach of "+p.getName()+" at "+m.getTeam()+"!";
		}
		}
		return null;
	}
	
	
	public String rule6(String player,ArrayList<Rule> rules, ArrayList<Player> players,ArrayList<Manager> managers) {
		Rule r = null;
		for(Rule r6:rules){
			if(r6.getRule_nr() == 6){
				
				r = r6;
				
			}
		}
		
		
			
		
		
		Manager m = null;
		for(Manager m1 : managers){
			if(m1.getName().equals(player)){
				m=m1;
			}
		}
		
		boolean test1 = false;
		boolean test2 = false;
		
		
	for(Player p : players){
		if(r.getWho().equals("name")) {
			
			if(r.getWhat1().equals("manager") && r.getThan1().equals("player"))
				if(m.getName().equals(p.getName())) {
					System.out.println("ceva");
					test1 = true;
					
				}
			if(r.getWhat2().equals("golden_ball"))
				if(Integer.parseInt(p.getGoldenBall()) >= 1) {
					test2 = true;
					
				}
			
		}
		
		if(test1 && test2) {
			return m.getName()+" is "+r.getIs()+"!";
		}
		}
		return null;
	}

}
