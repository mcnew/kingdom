package mx.dannyyesoft.crm.controller;

import java.net.URI;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.dannyyesoft.crm.controller.request.KingdomCreationRequest;
import mx.dannyyesoft.crm.controller.request.KingdomUpdateRequest;
import mx.dannyyesoft.crm.controller.response.KingdomListResponse;
import mx.dannyyesoft.crm.controller.response.KingdomReadResponse;
import mx.dannyyesoft.crm.service.KingdomService;

@RequestMapping("/kingdom")
@RestController
public class KingdomController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KingdomController.class);

	private final KingdomService kingdomService;

	@Autowired
	public KingdomController(KingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}

	@ApiOperation(value = "Listado", response = KingdomListResponse.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomListResponse>> list() {
		return ResponseEntity.ok(kingdomService.findAll());
	}

	@ApiOperation("Alta")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> create(@RequestBody KingdomCreationRequest request, UriComponentsBuilder ucBuilder) {
		Integer id = kingdomService.create(request);
		URI location = ucBuilder.path("/kingdom/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@ApiOperation("Actualizacion")
	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> update(
			@ApiParam(value = "The id", required = true) @PathVariable("id") Integer kingdomId,
			@RequestBody KingdomUpdateRequest request) {
		Integer id = kingdomService.update(kingdomId, request);
		if (id == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.accepted().build();
		}
	}

	@ApiOperation("Detalle")
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<KingdomReadResponse> read(
			@ApiParam(value = "The id", required = true) @PathVariable("id") Integer kingdomId) {
		LOGGER.trace("{}", kingdomId);
		KingdomReadResponse response = kingdomService.findById(kingdomId);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}

}
