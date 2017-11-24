package mx.dannyyesoft.crm.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Detalle")
public class KingdomReadResponse extends KingdomListResponse {

	@ApiModelProperty("La descripcion")
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
