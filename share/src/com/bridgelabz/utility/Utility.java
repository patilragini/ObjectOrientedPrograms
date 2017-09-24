package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utility {
/**
 * @param filePath String
 * @return string[]
 * <p>reads file 
 */
	public static String[] readFile(String filePath) {
		String words[] = {};
		ArrayList<String> lines = new ArrayList<String>();
		String line, temp[] = {};
		BufferedReader bufferedReader;
		FileReader file;
		try {
			file = new FileReader(filePath);
			bufferedReader = new BufferedReader(file);
			while ((line = bufferedReader.readLine()) != null) {
				temp = line.split(",|\\s");
				for (int i = 0; i < temp.length; i++) {
					lines.add(temp[i]);

				}
			}
			words = lines.toArray(new String[lines.size()]);
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;
	}

	public static void writeFile(String word[], String filePath) {

		try {
			FileWriter writer = new FileWriter(filePath, false);
			PrintWriter out = new PrintWriter(writer);
			for (int i = 0; i < word.length; i++) {
				out.write(word[i] + " ");
			}
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void searchDoctor(String doctorFile) {
		Scanner scanner = new Scanner(System.in);
		String searchBy[] = { "Name", "Id", "Specilization", "Availability" };
		System.out.println("Search doctor by:\n1.Name\n2.Id\n3.Specilization\n4.Availability");
		int choice = scanner.nextInt();
		System.out.println("Enter " + searchBy[choice - 1] + " you want");
		String valueToSearch = scanner.next();
		JSONArray doctorList = readJSONArray(doctorFile);
		int presentAtIndex = isPresent(doctorList, searchBy[choice - 1], valueToSearch);
		if ((presentAtIndex) >= 0) {
			JSONObject doctor = (JSONObject) doctorList.get(presentAtIndex);
			displayJson(doctor);
		} else {
			System.out.println("Doctor with " + searchBy[choice - 1] + "=" + valueToSearch + " is not present");
		}
	}

	public static JSONArray readJSONArray(String file) {
		JSONParser jsonParser = new JSONParser();
		FileReader reader;
		JSONArray jsonObject = new JSONArray();
		try {
			reader = new FileReader(file);
			jsonObject = (JSONArray) jsonParser.parse(reader);
			reader.close();
		} catch (IOException e) {
			((Throwable) e).printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	public static int isPresent(JSONArray doctorList, String key, String valueToSearch) {
		int presentAt = -1;
		for (int index = 0; index < doctorList.size(); index++) {
			JSONObject doctor = (JSONObject) doctorList.get(index);
			if (doctor.get(key).equals(valueToSearch)) {
				presentAt = index;
				break;
			}
		}
		return presentAt;
	}

	public static void displayJson(JSONObject object) {
		Set keyList = object.keySet();
		String[] keys = (String[]) keyList.toArray(new String[keyList.size()]);
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] + "=" + object.get(keys[i]));
		}
		System.out.println("================");
	}
	
}
