package qa.framework.jsonschemavalidationStepdefs;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.json.JSONObject;

import com.apivalidation.stepdefs.TE_ESL_API_StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import qa.framework.jsonschemavalidation.JsonSchemavalidation;
import qa.framework.jsonschemavalidation.SchemaValidationModes;

public class JsonschemavalidationStepdef extends JsonSchemavalidation {

	String response;
	String swaggerjsonasstring;
	JSONObject definition;

	@When("^user set api response as input for json schema validation$")
	public void user_set_api_response_as_input_for_json_schema_validation() {
		response = TE_ESL_API_StepDef.response.getBody().asString();
	}

	@When("^user have swagger yaml (.+)available$")
	public void user_have_swagger_yaml_something_available(String swaggeryamlFilename) throws IOException {
		swaggeryamlFilename = swaggeryamlFilename.replace("\"", "");
		swaggerjsonasstring = convertSwaggerToString(swaggeryamlFilename);

	}

	@When("^user convert swagger yaml to json schema for object to validate (.+) and of object type (.+)$")
	public void user_convert_swagger_yaml_to_json_schema_for_object_to_validate_and_of_object_type(
			String objectToValidate, String objectType) {
		objectToValidate = objectToValidate.replace("\"", "");
		objectType = objectType.replace("\"", "");
		qa.framework.jsonschemavalidation.JsonSchemavalidation.objectType = objectType;
		definition = createJsonSchema(swaggerjsonasstring, objectToValidate, objectType);

	}

	@And("^user add validation options \"([^\"]*)\" to existing json schema$")
	public void user_add_validation_options_to_existing_json_schema(String options) {
		List<String> optionList = Arrays.asList(options.split(","));
		HashSet<SchemaValidationModes> schemaValidationModes = new HashSet<SchemaValidationModes>();

		if (!optionList.isEmpty()) {
			if (options.contains("ALL_PROPERTIES_REQUIRED")) {
				schemaValidationModes.add(SchemaValidationModes.ALL_PROPERTIES_REQUIRED);

			}

			if (options.contains("NO_ADDITIONAL_PROPERTIES")) {
				schemaValidationModes.add(SchemaValidationModes.NO_ADDITIONAL_PROPERTIES);

			}
			if (options.contains("IGNORE_NULL_VALUES")) {
				schemaValidationModes.add(SchemaValidationModes.IGNORE_NULL_VALUES);

			}
			if (options.contains("FAIL_EMPTY_ARRAYS")) {
				schemaValidationModes.add(SchemaValidationModes.FAIL_EMPTY_ARRAYS);

			}

		}
		
		definition = addSchemaValidationOptions(definition,schemaValidationModes);

	}
}
