package bgpwatcher;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.time.Instant;
import java.util.Optional;

/**
 * Client that listens for BGP changes<br>
 * See <a href="https://ris-live.ripe.net/">RIS Live</a> for more details
 */
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class RisClient extends WebSocketClient {

	private Optional<String> prefix = Optional.empty();
	private Optional<String> host = Optional.empty();

	public RisClient(URI serverURI) {
		super(serverURI);
	}

	@Override
	public void onOpen(ServerHandshake serverHandshake) {
		send("{\"type\":\"ris_subscribe\",\"data\":{" +
				 prefix.map(s -> "\"prefix\":\"" + s + "\",").orElse("") +
				 "\"moreSpecific\":true," +
				 "\"lessSpecific\":false," +
				 host.map(s -> "\"host\":\"rrc05.ripe.net\",").orElse("") +
				 "\"socketOptions\":{\"includeRaw\":false,\"acknowledge\":true}}}");
	}

	@Override
	public void onMessage(String message) {
		if (!message.equals("{\"type\":\"pong\",\"data\":null}")) {
			System.out.println(Instant.now() + ": " + message + "\n");
		}
	}

	@Override
	public void onClose(int code,
											String reason,
											boolean remote) {
		// The close codes are documented in class org.java_websocket.framing.CloseFrame
		System.err.println(
			"Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
			+ reason);
	}

	@Override
	public void onError(Exception e) {
		e.printStackTrace(System.err);
		// if the error is fatal then onClose will be called additionally
	}

	public void setPrefix(String prefix) {
		this.prefix = Optional.of(prefix);
	}

	public void setHost(Optional<String> host) {
		this.host = host;
	}
}