package com.devsuperior.bds02.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;


@RestController
@RequestMapping(value = "/cities")
public class CityController {
	
	@Autowired
	private CityService service;

	@GetMapping	
	public ResponseEntity<List<CityDTO>> findAll() {		
		List<CityDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CityDTO> delete(@PathVariable Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<CityDTO> findById(@PathVariable Long id) {
//		CityDTO dto = service.findById(id);
//		return ResponseEntity.ok().body(dto);
//	}

//	@PostMapping
//	public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto) {
//		dto = service.insert(dto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(dto.getId()).toUri();
//		return ResponseEntity.created(uri).body(dto);
//	}
	
	

}
