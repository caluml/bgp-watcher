package bgpwatcher;

import java.net.URI;

public class Main {

	public static void main(String[] args) throws Exception {
		URI serverURI = new URI("wss://ris-live.ripe.net/v1/ws/?client=bgp-watcher");

		RisClient risClient = new RisClient(serverURI); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
		risClient.setPrefix("2a0e:1d40::/29");
		risClient.connect();

		while (true) {
			Thread.sleep(1000);
			risClient.send("{\"type\":\"ping\"}");
		}
	}

}
