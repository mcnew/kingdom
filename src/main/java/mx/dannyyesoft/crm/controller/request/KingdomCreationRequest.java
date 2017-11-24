package mx.dannyyesoft.crm.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Creacion")
public class KingdomCreationRequest extends KingdomUpdateRequest {

	@ApiModelProperty(value = "El nombre", required = true)
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
