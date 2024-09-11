package bgpwatcher.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"timestamp",
	"peer",
	"peer_asn",
	"id",
	"host",
	"type",
	"path",
	"community",
	"origin",
	"announcements",
	"withdrawals"
})
// @Generated("jsonschema2pojo")
public class Data {

	@JsonProperty("timestamp")
	private Double timestamp;
	@JsonProperty("peer")
	private String peer;
	@JsonProperty("peer_asn")
	private String peerAsn;
	@JsonProperty("id")
	private String id;
	@JsonProperty("host")
	private String host;
	@JsonProperty("type")
	private String type;
	@JsonProperty("path")
	private List<Integer> path;
	@JsonProperty("community")
	private List<List<Integer>> community;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("announcements")
	private List<Announcement> announcements;
	@JsonProperty("withdrawals")
	private List<String> withdrawals;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("timestamp")
	public Double getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Double timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("peer")
	public String getPeer() {
		return peer;
	}

	@JsonProperty("peer")
	public void setPeer(String peer) {
		this.peer = peer;
	}

	@JsonProperty("peer_asn")
	public String getPeerAsn() {
		return peerAsn;
	}

	@JsonProperty("peer_asn")
	public void setPeerAsn(String peerAsn) {
		this.peerAsn = peerAsn;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("host")
	public String getHost() {
		return host;
	}

	@JsonProperty("host")
	public void setHost(String host) {
		this.host = host;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("path")
	public List<Integer> getPath() {
		return path;
	}

	@JsonProperty("path")
	public void setPath(List<Integer> path) {
		this.path = path;
	}

	@JsonProperty("community")
	public List<List<Integer>> getCommunity() {
		return community;
	}

	@JsonProperty("community")
	public void setCommunity(List<List<Integer>> community) {
		this.community = community;
	}

	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@JsonProperty("announcements")
	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	@JsonProperty("announcements")
	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	@JsonProperty("withdrawals")
	public List<String> getWithdrawals() {
		return withdrawals;
	}

	@JsonProperty("withdrawals")
	public void setWithdrawals(List<String> withdrawals) {
		this.withdrawals = withdrawals;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name,
																		Object value) {
		this.additionalProperties.put(name, value);
	}

}