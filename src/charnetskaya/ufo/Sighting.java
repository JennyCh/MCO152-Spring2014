package charnetskaya.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private final String description;
	private final String location;

	@SerializedName("reported_at")
	private final String reportedAt;
	private final String duration;

	@SerializedName("sighted_at")
	private final String sightedAt;

	public Sighting(String description, String location, String reportedAt,
			String duration, String sightedAt) {

		this.description = description;
		this.location = location;
		this.reportedAt = reportedAt;
		this.duration = duration;
		this.sightedAt = sightedAt;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	@Override
	public String toString() {
		return "\nSighting\n [description=" + description + "\n, location="
				+ location + "\n, reportedAt=" + reportedAt + "\n, duration="
				+ duration + "\n, sightedAt=" + sightedAt + "]\n";
	}

}
