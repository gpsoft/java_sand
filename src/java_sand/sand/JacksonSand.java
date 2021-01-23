package java_sand.sand;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import java_sand.Utils;

public class JacksonSand implements Sand {
	@Override
	public void run() {
		ObjectMapper mapper = new ObjectMapper();

		URL url;
		try {
			url = new URL(
					"http://geoapi.heartrails.com/api/json?method=searchByPostal&postal=8100001");
			Api api = mapper.readValue(url, Api.class);

			for (Location loc : api.response.location) {
				Utils.prn(loc.postal + ":" + loc.city + loc.town);
			}
		} catch (IOException e) {
		}
	}
}

class Api {
	public Response response;
}

class Response {
	public List<Location> location;
}

class Location {
	public String city;
	public String city_kana;
	public String town;
	public String town_kana;
	public float x;
	public float y;
	public String prefecture;
	public String postal;
}
