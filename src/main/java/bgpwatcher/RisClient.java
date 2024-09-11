package bgpwatcher;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Optional;

/**
 * Client that listens for BGP changes<br>
 * See <a href="https://ris-live.ripe.net/">RIS Live</a> for more details
 */
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class RisClient extends WebSocketClient {

	private final Logger updateLogger = LoggerFactory.getLogger("updates");
	private final Logger logger = LoggerFactory.getLogger(getClass());

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
			logger.info("{}\n", message);
			updateLogger.info(message);
		}
	}

	@Override
	public void onClose(int code,
											String reason,
											boolean remote) {
		// The close codes are documented in class org.java_websocket.framing.CloseFrame
		logger.error("Connection closed by {} Code: {} Reason: {}", remote ? "remote peer" : "us", code, reason);
	}

	@Override
	public void onError(Exception e) {
		logger.error("Error", e);
		// if the error is fatal then onClose will be called additionally
	}

	public void setPrefix(String prefix) {
		this.prefix = Optional.of(prefix);
	}

	public void setHost(String host) {
		this.host = Optional.of(host);
	}
}