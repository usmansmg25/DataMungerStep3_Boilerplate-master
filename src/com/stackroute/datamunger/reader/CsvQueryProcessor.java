package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	private String fileName;

	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 * Note: Return type of the method will be Header
	 */
	
	@Override
	public Header getHeader() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String strHeader = br.readLine();
		String[] columns = strHeader.split(",");
		Header header = new Header(columns);
		return header;
		// read the first line
		// populate the header object with the String array containing the header names
	}
	

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	
	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. 
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		FileReader filereader;
		try {
			filereader = new FileReader(fileName);
		}catch (FileNotFoundException e) {
			filereader = new FileReader("data/ipl.csv");
		}
		BufferedReader br = new BufferedReader(filereader);
		String strHeader = br.readLine();
		String strFirstRow = br.readLine();
		String[] fields = strFirstRow.split(",",18);
		String[] dataTypeArray = new String[fields.length];
		int count = 0;
		for (String s:fields) {
			if(s.matches("[0-9]+")) {
				dataTypeArray[count] = "java.lang.Integer";
				count++;
			}else {
				dataTypeArray[count] = "java.lang.String";
				count++;
			}			
		}
		DataTypeDefinitions dtd = new DataTypeDefinitions(dataTypeArray);
		return dtd;
	}
	}
