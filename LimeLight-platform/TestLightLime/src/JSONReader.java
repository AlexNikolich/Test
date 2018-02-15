import java.io.InputStream;

import org.apache.cxf.helpers.IOUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Given a csv file, parse it into a List<String[]>
 */
public class JSONReader {
    
    static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode getFileContents(String filePath) throws Exception {
        InputStream is = JSONReader.class.getClassLoader().getResourceAsStream(filePath);
        String outputText = IOUtils.toString(is);
        
        JsonNode rootNode = objectMapper.readTree(outputText);
        
        return rootNode;
    }
}