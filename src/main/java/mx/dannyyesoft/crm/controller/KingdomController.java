package mx.dannyyesoft.crm.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

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

import mx.dannyyesoft.crm.controller.request.KingdomCreationRequest;
import mx.dannyyesoft.crm.controller.request.KingdomUpdateRequest;
import mx.dannyyesoft.crm.controller.response.KingdomListResponse;
import mx.dannyyesoft.crm.controller.response.KingdomReadResponse;
import mx.dannyyesoft.crm.service.KingdomService;

@RestController
public class KingdomController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KingdomController.class);

	private final KingdomService kingdomService;

	@Autowired
	public KingdomController(KingdomService kingdomService) {
		this.kingdomService = kingdomService;
	}

	@RequestMapping(path = "/kingdom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomListResponse>> list() {
		return ResponseEntity.ok(Collections.emptyList());
	}

	@RequestMapping(path = "/kingdom", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> create(@RequestBody KingdomCreationRequest request, UriComponentsBuilder ucBuilder) {
		URI location = ucBuilder.path("/kingdom/{id}").buildAndExpand(request.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(path = "/kingdom/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> update(@PathVariable("id") Integer kingdomId,
			@RequestBody KingdomUpdateRequest request) {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/kingdom/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<KingdomReadResponse> read(@PathVariable("id") Integer kingdomId) {
		LOGGER.trace("{}", kingdomId);
		return ResponseEntity.ok(new KingdomReadResponse());
	}

}
