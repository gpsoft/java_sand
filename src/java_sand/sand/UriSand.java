package java_sand.sand;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

import java_sand.Utils;

public class UriSand implements Sand {

	@Override
	public void run() {
		URI url = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port(8000)
				.queryParam("name", "Smith & Wesson")
				.queryParam("dept_id", 125)
				.build()
				.encode()
				.toUri();
		Utils.prn(url.toString());
	}
}
