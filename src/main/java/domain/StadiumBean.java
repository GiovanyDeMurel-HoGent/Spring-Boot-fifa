package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StadiumBean {

	private final List<String> stadiumList;

	public StadiumBean() {
		stadiumList = new ArrayList<>(Arrays.asList(new String[]{"Al Bayt Stadium", "Al Thumama Stadium", "Feyenoord Stadium", "Tollembeek Stadium"}));
	}

	public List<String> getStadiumList() {
		return stadiumList;
	}
}