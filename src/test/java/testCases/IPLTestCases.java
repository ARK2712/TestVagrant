package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class IPLTestCases {
	JSONParser jsonparser;
	FileReader fr;
	JSONObject jsObj;
	JSONArray jsArrayplayers;
	
	
	@Test
	public void TC_001_Only4ForenPl() throws IOException, ParseException
	{
		jsonparser=new JSONParser();
		fr=new FileReader(".\\jsonFiles\\iplResp.json");
		jsObj=(JSONObject)jsonparser.parse(fr);
	    jsArrayplayers=(JSONArray)jsObj.get("player");
		int forenPlayersCount=0;
		for(int i=0;i<jsArrayplayers.size();i++)
		{
			JSONObject player=(JSONObject)jsArrayplayers.get(i);
			String country=(String)player.get("country");
			if(!(country.equalsIgnoreCase("India")))
					{
						forenPlayersCount++;
					}
			
		}
		Assert.assertEquals("Test case failed:Since there are less than expected "
				+ "foreign players in the team,number of foreign players is: "+forenPlayersCount, "4",String.valueOf(forenPlayersCount) );
	}
	
}




