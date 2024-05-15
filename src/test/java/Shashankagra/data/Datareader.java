package Shashankagra.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	
	public List<HashMap<String, String>> getjsonDataToMap(String FilePath) throws IOException
	{
		// read json to string
		String JsonContent= 	FileUtils.readFileToString(new File(FilePath),
				StandardCharsets.UTF_8);
	// String to Hashmap
		
		ObjectMapper newobj = new ObjectMapper();
		List<HashMap<String,String>> data = newobj.readValue(JsonContent, new TypeReference <List<HashMap<String,String>>>(){});
		
		return data;
		
	
	}

}
