package mx.dannyyesoft.crm.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import mx.dannyyesoft.crm.entity.KingdomEntity;

@RestController
public class KingdomController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KingdomController.class);

	@RequestMapping(path = "/kingdom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<KingdomEntity> list() {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(path = "/kingdom", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> create(@RequestBody KingdomEntity kingdom, UriComponentsBuilder ucBuilder) {
		URI location = ucBuilder.path("/kingdom/{id}").buildAndExpand(kingdom.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(path = "/kingdom", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> update(@RequestBody KingdomEntity kingdom) {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/kingdom/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<KingdomEntity> read(@PathVariable("id") Integer kingdomId) {
		LOGGER.trace("{}", kingdomId);
		return ResponseEntity.ok().build();
	}

}
