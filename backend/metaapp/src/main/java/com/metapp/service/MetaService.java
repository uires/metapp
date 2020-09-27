package com.metapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metapp.entity.Meta;
import com.metapp.repository.MetaRepository;

@Service
public class MetaService {
	@Autowired
	private MetaRepository repository;

	public Long store(Meta meta) {
		try {
			Meta retornoPersistencia = this.repository.save(meta);
			return retornoPersistencia.getId();
		} catch (Exception e) {
			throw e;
		}
	}
}
