package com.globel.library.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globel.library.entity.Patron;
import com.globel.library.repository.PatronRepo;
import com.globel.library.service.PatronService;

@Service
public class PatronServiceImpl implements PatronService {

	@Autowired
	private PatronRepo patronRepo;
	
	@Override
	public List<Patron> findAll() {
		return patronRepo.findAll();
	}

	@Override
	public Patron findById(Long id) {
		return patronRepo.findById(id).orElseThrow();
	}

	@Override
	public Patron getById(Long id) {
		return patronRepo.getById(id);
	}

	@Override
	public Patron insert(Patron entity) {
		return patronRepo.save(entity);
	}

	@Override
	public Patron update(Patron entity) {
		Patron patron = patronRepo.getById(entity.getId());
		
		if (patron != null) {
			patron.setName(entity.getName());
			patron.setContactInformation(entity.getContactInformation());
			return patronRepo.save(patron);
		}
		return patron;
		
	}

	@Override
	public void deleteById(Long id) {

		patronRepo.deleteById(id);

	}

}
