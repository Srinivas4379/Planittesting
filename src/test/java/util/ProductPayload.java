package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPayload {

	public static Map<String, Object> getPayload() {

		Map<String, Object> payload = new HashMap<>();

		payload.put("query", "laptop");

		List<Map<String, Object>> products = new ArrayList<>();

		Map<String, Object> hp = new HashMap<>();

		hp.put("name", "HP");
		hp.put("price", 799.99);

		Map<String, Object> lenovo = new HashMap<>();

		lenovo.put("name", "Lenovo");
		lenovo.put("price", 899.99);

		products.add(hp);

		products.add(lenovo);

		payload.put("products", products);

		return payload;
	}

}
