package com.practica.dev.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.model.Base;

public interface IBaseController<E extends Base, ID extends Serializable>
{
	public ResponseEntity<?> getAll() throws Exception;
	public ResponseEntity<?> getOne(@PathVariable ID id) throws Exception;
	public ResponseEntity<?> save(@Valid @RequestBody E e) throws Exception;
	public ResponseEntity<?> update(@PathVariable ID id,@RequestBody E e) throws Exception;
	public ResponseEntity<?> delete(@PathVariable ID id) throws Exception;
}
