package com.practica.dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.model.Base;
import com.practica.dev.service.BaseServiceImpl;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Integer>> 
implements IBaseController<E, Integer> {
	
	@Autowired
	protected S service;

	@Override
	@GetMapping("")
	public ResponseEntity<?> getAll() throws Exception {
		// TODO Auto-generated method stub
		try {
		 return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
		}catch( Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) throws Exception {
		try {
			 return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
			}catch( Exception e)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
			}
	}

	@Override
	@PostMapping("")
	public ResponseEntity<?> save(@Valid @RequestBody E e) throws Exception {

		
		if( e != null)
		{
			try {
				 return ResponseEntity.status(HttpStatus.OK).body(service.save(e));
				}catch( Exception es)
				{
					System.out.println(es);
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error': 'Error. Verifica' } ");
				}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error':'Error. Verificar'} ");
	}

	@Override
	@PutMapping("")
	public ResponseEntity<?> update(Integer id,@RequestBody E e) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return ResponseEntity.status(HttpStatus.OK).body(service.update(id,e));
			}catch( Exception es)
			{
				System.out.println(es);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error': 'Error. Verifica' } ");
			}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
			}catch( Exception es)
			{
				System.out.println(es);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'error': 'Error. Verifica' } ");
			}
	}
	
	
}
