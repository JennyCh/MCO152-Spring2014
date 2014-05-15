package charnetskaya.stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private Map<String, List<DailyPrice>> map;

	public AmexData() throws IOException {

		map = new HashMap<String, List<DailyPrice>>();
		List<String> fileNames = getAllFileNames();

		for (String file : fileNames) {
			CSVReader in = new CSVReader(new FileReader("resources/amex/"
					+ file));
			String[] line;
			in.readNext(); // skips the top line
			while ((line = in.readNext()) != null) {
				ArrayList<DailyPrice> list = null;

				if (!map.containsKey(line[1])) {
					list = new ArrayList<DailyPrice>();
					map.put(line[1], list);

				} else {
					list = (ArrayList<DailyPrice>) map.get(line[1]);
				}
				list.add(new DailyPrice(line));

			}

		}

	}

	public boolean contains(String symbolValue) {

		return map.containsKey(symbolValue);
	}

	public List<DailyPrice> getPrices(String symbolValue) {
		if (map.containsKey(symbolValue)) {
			return map.get(symbolValue);
		} else {
			return new ArrayList<DailyPrice>();
		}

	}

	public List<DailyPrice> getPrices(String symbolValue,
			Date startDate, Date endDate) {
		if (map.containsKey(symbolValue)) {
			List<DailyPrice> records = map.get(symbolValue);

			Collections.sort(records);
			Integer start = 0;
			Integer end = 0;
			for (int i = 0; i < records.size(); i++) {
				if (startDate.equals(records.get(i).getDate())) {
					if (start == 0) {
						start = i;
					}
				}
				if (endDate.equals(records.get(i).getDate())) {
					end = i;
				}
			}

			if (end != null && start != null) {
				if(end<= start){
				return records.subList(end, start);
				}
			}
		}
		return new ArrayList<DailyPrice>();

	}

	private List<String> getAllFileNames() {

		String filePathAndName = "resources/amex";
		File folder = new File(filePathAndName);
		File[] listOfFiles = folder.listFiles();
		List<String> fileNames = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileNames.add(listOfFiles[i].getName());
			}
		}

		return fileNames;
	}/*

	public static void main(String[] args) throws IOException {
		new AmexData();
	}*/
}
