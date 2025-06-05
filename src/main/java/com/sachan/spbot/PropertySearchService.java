
package com.sachan.spbot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.Iterator;

@Service
public class PropertySearchService {

    private JsonNode allData;

    public PropertySearchService() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("property_data.json");
            allData = mapper.readTree(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String search(String userMessage) {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<String> sheetNames = allData.fieldNames();
            while (sheetNames.hasNext()) {
                String sheet = sheetNames.next();
                JsonNode sheetData = allData.get(sheet);

                for (JsonNode row : sheetData) {
                    String rowText = row.toString().toLowerCase();
                    if (userMessage.toLowerCase().matches(".*" + rowText + ".*")) {
                        sb.append("From sheet [").append(sheet).append("]:\n");
                        sb.append(row.toPrettyString()).append("\n\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.length() > 0 ? sb.toString() : "No exact property match found.";
    }
}
