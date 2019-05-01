package webmonitor;

import java.util.ArrayList;
import java.util.List;

public class Log {

	List<String> list = new ArrayList<String>();

	public void logPrint(String message) {
		list.add(message);
		System.out.println(message);
	}

	public List<String> getList() {
		return list;
	}

	public String getText() {
		StringBuilder content = new StringBuilder();
		for (String entry : list) {
			content.append(entry).append("\n");
		}
		return content.toString();
	}

}
