package com.metapp.resource;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.metapp.entity.Meta;
import com.metapp.service.MetaService;

@RestController
@RequestMapping(path = "api/meta")
public class MetaResource {

	@Autowired
	private MetaService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Meta> store(@RequestBody(required = true) Meta meta, UriComponentsBuilder uriBuilder) {
		Long id = this.service.store(meta);
		URI uri = uriBuilder.path("api/meta/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).body(null);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Meta> search(@RequestParam(name = "id", required = true) Long id) {
		return null;
	}
}
