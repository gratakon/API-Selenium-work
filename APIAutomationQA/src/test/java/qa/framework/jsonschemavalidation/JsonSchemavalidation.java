package qa.framework.jsonschemavalidation;

import java.io.IOException;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONWriter;

import com.apivalidation.stepdefs.FileManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import net.minidev.json.reader.JsonWriter;

public class JsonSchemavalidation {

	public static String objectToValidate;
	public static String objectType;
	public static JSONObject jsonObjectSchema;

	public static String convertYamlToJson(String swaggerFileName) throws IOException {
		String userDir = System.getProperty("user.dir");
		String filepath = FileManager.getFileManagerObj().searchFile(userDir, swaggerFileName);

		String yamlstr = FileManager.getFileManagerObj().readFile(filepath);
		ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
		Object obj = yamlReader.readValue(yamlstr, Object.class);
		ObjectMapper jsonwiter = new ObjectMapper();
		// writevaluetostring method
		return JSONWriter.valueToString(obj);

	}

	public static String convertSwaggerToString(String swaggerFileName) throws IOException {
		String swaggerJsonString;
		String userDir = System.getProperty("user.dir");
		String filepath = FileManager.getFileManagerObj().searchFile(userDir, swaggerFileName);
		if (swaggerFileName.contains(".yaml") || swaggerFileName.contains(".yml")) {
			swaggerJsonString = convertYamlToJson(swaggerFileName);
		} else {
			swaggerJsonString = FileManager.getFileManagerObj().readFile(filepath);
		}
		return swaggerJsonString;
	}

	public static JSONObject createJsonSchema(String swaggerJsonAsString, String objectToValidate, String objectType) {
		JsonSchemavalidation.objectToValidate = objectToValidate;
		JsonSchemavalidation.objectType = objectType;

		JSONObject definitions = new JSONObject();
		JSONObject swaggerObject = new JSONObject(swaggerJsonAsString);

		if (swaggerObject.has("openapi")) {
			swaggerObject = new JSONObject(swaggerJsonAsString.replace("components/schemas", "definitions"));
			definitions = swaggerObject.getJSONObject("components").getJSONObject("schemas");
		} else {
			definitions = swaggerObject.getJSONObject("definitions");

		}

		JSONObject targetObject = definitions.getJSONObject(objectToValidate);

		// Added now start 1
		if (!(definitions.getJSONObject(objectToValidate).has("allof"))) {
			if ((targetObject.has("items")) && !(targetObject.has("type"))) {
				targetObject.put("type", "array");
			}

			String objectTypeInDefinition = targetObject.getString("type");
			if ((!objectTypeInDefinition.equals(objectType)) && objectType.equals("array")) {
				JSONObject properties = targetObject.getJSONObject("properties");
				definitions.getJSONObject(objectToValidate).put("type", objectType);
				definitions.getJSONObject(objectToValidate).remove("properties");
				definitions.getJSONObject(objectToValidate).put("items",
						new JSONObject().put("properties", properties).put("type", "object"));

			} else if ((!objectTypeInDefinition.equals(objectType)) && objectType.equals("object")) {
				JSONObject properties = targetObject.getJSONObject("items").getJSONObject("properties");
				definitions.getJSONObject(objectToValidate).put("type", objectType);
				definitions.getJSONObject(objectToValidate).remove("properties");
				definitions.getJSONObject(objectToValidate).put("properties", properties);

			}

		}

		return definitions;

	}
	public static JSONObject addSchemaValidationOptions(JSONObject definitions, Set<SchemaValidationModes> schemaValidationModes) {
		
		if(!(schemaValidationModes.isEmpty())) {
			for(String keyStr : definitions.keySet()) {
				
				
				//Added to handle all of element in json schema
				combineAllofInJsonSchema(definitions,keyStr);
			}
		}
		return definitions;
	}
	
	private static void combineAllofInJsonSchema(JSONObject definitions, String KeyModel) {
		
	}
	
	

}
