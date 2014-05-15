package charnetskaya.subwaymap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private final List<Trip> trips;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader in = new CSVReader(new FileReader("trips.txt"));

		String[] line;
		in.readNext();

		while ((line = in.readNext()) != null) {

			trips.add(new Trip(line[0], line[2], line[6]));
		}

	}

	public Trip getTrip(String shapeId) {
		// List<Trip> tripsById = new ArrayList<Trip>();
		for (Trip trip : trips) {
			if (shapeId.equals(trip.getShapeId())) {
				// tripsById.add(trip);
				return trip;
			}
		}
		return null;
		// return tripsById;
	}

}
