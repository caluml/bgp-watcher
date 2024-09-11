package bgpwatcher.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"next_hop",
	"prefixes"
})
// @Generated("jsonschema2pojo")
public class Announcement {

	@JsonProperty("next_hop")
	private String nextHop;
	@JsonProperty("prefixes")
	private List<String> prefixes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("next_hop")
	public String getNextHop() {
		return nextHop;
	}

	@JsonProperty("next_hop")
	public void setNextHop(String nextHop) {
		this.nextHop = nextHop;
	}

	@JsonProperty("prefixes")
	public List<String> getPrefixes() {
		return prefixes;
	}

	@JsonProperty("prefixes")
	public void setPrefixes(List<String> prefixes) {
		this.prefixes = prefixes;
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
