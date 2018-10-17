package analysisJson;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AnalysisJson {
	private String data = null;
	
	private void setData(String data) {
		this.data = data;		
	}
	private String getData() {
		return this.data;
	}
	
	// Analysis data of json
	public void analysisData(String data) {
		//new object of json
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(data);
		JSONArray persons = jsonObject.getJSONArray("persons");
		
		JSONObject personObject = new JSONObject();
		Person person=new Person();
		for(int i=0; i<persons.size();i++) {
			/*
			// First method, convert entity of class
			JSONObject jsonObjectPerson = JSONObject.fromObject(persons.getString(i));
			person = (Person) JSONObject.toBean(jsonObjectPerson, Person.class);
			System.out.println(person.age);
			*/
						
			// Second method, direct call method
			personObject = persons.getJSONObject(i);
			System.out.println(personObject.getString("name"));
			System.out.println(personObject.getInt("age"));
 
		}		
	}
	
	// Convert the entity of data
	public void convertEntity() {

		String json = "{\"person\":{\"name\":\"zhaoliu\",\"age\":\"30\",\"sex\":\"man\"}}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		//First, you must convert the json to string
		String stringPerson = jsonObject.getString("person");
		//Then, convert the string to JSONObject 
		JSONObject jsonObjectPerson = JSONObject.fromObject(stringPerson);
		Person person = (Person) JSONObject.toBean(jsonObjectPerson, Person.class);
		System.out.println(person.age);
		
	}
	
	// Generate the data of json
	public void generateJson() {
		// Set the list
		ArrayList<Person> persons = new ArrayList<Person>();
		
		Person person = new Person();
		person.setName("sunlin");
		person.setAge(10);
		person.setSex("man");
		persons.add(person);
		
		person.setName("zhaowu");
		person.setAge(20);
		person.setSex("woman");
		persons.add(person);
		
		// Generate the list of json
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("persons", persons);
		
		System.out.println(jsonObject.toString());
		
	}
		
	public static void main(String[] args) {
				
		AnalysisJson aj = new AnalysisJson(); 
		
		//Json data
		String data = "{\"persons\":[{\"name\":\"zhangsan\",\"age\":\"10\",\"sex\":\"man\"},"
				+ "{\"name\":\"lisi\",\"age\":\"20\",\"sex\":\"woman\"},"
				+ "{\"name\":\"wangwu\",\"age\":\"30\",\"sex\":\"man\"}]}";
		
		// Print the data of json 
		System.out.println(data);
		
		// Analysis the data of json
		aj.setData(data);
		aj.analysisData(aj.getData());
		
		/*
		// Convert the entity
		aj.convertEntity();
		*/
		
		// Generate the data of json 
		aj.generateJson();
				
	}

}
