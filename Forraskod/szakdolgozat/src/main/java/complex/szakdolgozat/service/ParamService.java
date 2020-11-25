package complex.szakdolgozat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ParamService {

	private String params;

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public List<String> splitParams(String params) {

		List<String> paramList = new ArrayList<>();
		if (params.isEmpty()) {
			return null;
		}
		String[] paramArray = params.split(";");
		for (String param : paramArray) {
			paramList.add(param);
		}
		return paramList;
	}
}