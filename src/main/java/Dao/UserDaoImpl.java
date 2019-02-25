package Dao;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Dao.User;

public class UserDaoImpl implements IUserDao{

	//list is working as a database
	   List<User> users;
	
	//constructor:
	public UserDaoImpl() {
		users = new ArrayList<User>();
	}

	@Override
	public List<User> findAllUsers() {
		
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("./././users.json"));
			JSONObject jsonObjectUser  = (JSONObject) obj;
         
         JSONArray usersList = (JSONArray) jsonObjectUser.get("users");
         Iterator<String> iterator = usersList.iterator();
         
         while(iterator.hasNext()) {
         	Object o = iterator.next();
         	System.out.println(o);
         }
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			
		}catch (ParseException e) {
         e.printStackTrace();
     }
		
		return null;
	}

	@Override
	public User findUserById(int idToFind) {
		//System.out.println("good morning this is id: "+idToFind);
		
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
				
		try {
			Object obj = parser.parse(new FileReader("./././users.json"));
			JSONObject jsonObjectUser  = (JSONObject) obj;
         
         JSONArray usersList = (JSONArray) jsonObjectUser.get("users");
         
         Iterator<String> iterator = usersList.iterator();
         
         while(iterator.hasNext()) {
         	Object o = iterator.next();
         	//System.out.println(o);
         	JSONObject test = (JSONObject) o;
         	String tmp = String.valueOf(test.get("id"));
         	int id = Integer.parseInt(tmp);
         	//System.out.println(id);
         	
         	if(idToFind == id) {
         		System.out.print("L'utilisateur à été trouver voici ces information: "+o);
         		return null;
         	}
         }
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			
		}catch (ParseException e) {
         e.printStackTrace();
     }
		
		return null;
	}
	
	@Override
	public int generateIdNewUser() {
		return 0;
	}
	
	@Override
	public User findUserByName(String nameResearched) {
		
		System.out.println("Wanted: "+nameResearched);

		JSONParser parser = new JSONParser();
		
		try {
			
			Object obj = parser.parse(new FileReader("./././users.json"));
			JSONObject jsonObjectUser  = (JSONObject) obj;
			
			JSONArray usersList = (JSONArray) jsonObjectUser.get("users");
			
			Iterator<String> iterator = usersList.iterator();
			List<String> usersFound = new ArrayList<String>();
					
			while(iterator.hasNext()) 
			{
				Object o = iterator.next();
				
         	//System.out.println(o);
         	JSONObject test = (JSONObject) o;
         	String name = (String) test.get("name");
         	
         	//On vérifie si le nom rentrée correspond à celuil en base on force au même format pour eviter la casse
				if(name.toUpperCase().contains(nameResearched.toUpperCase())) 
				{
					usersFound.add(name);
				}
			}
			
			System.out.println("Voici le(s) résultat(s) correspondant:");
			System.out.println(usersFound);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User createUser(User newUser) {
		
		return newUser;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
