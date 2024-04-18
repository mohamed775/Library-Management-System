package com.globel.library.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.globel.library.entity.Book;
import com.globel.library.entity.Patron;
import com.globel.library.error.RecordNotFoundException;
import com.globel.library.repository.PatronRepo;
import com.globel.library.service.PatronService;

import jakarta.transaction.Transactional;

@Service
public class PatronServiceImpl implements PatronService {

	@Autowired
	private PatronRepo patronRepo;
	
	@Override
	@Cacheable(value = "findAllPatrons",key = "#root.methodName")
	public List<Patron> findAll() {
		return patronRepo.findAll();
	}

	@Override
	@Cacheable(value = "findAptronById",key = "#id")
	public Patron findById(Long id) {
		Optional<Patron> entity = patronRepo.findById(id);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			throw new RecordNotFoundException("book with id:- " + id + "  not found");
		}
	}

	@Override
	public Patron getById(Long id) {
		return patronRepo.getById(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = {"findAllPatrons" ,"findAptronById"} ,key = "#root.methodName" , allEntries = true)
	public Patron insert(Patron entity) {
		return patronRepo.save(entity);
	}

	@Override
	@Transactional
	@CacheEvict(value = {"findAllPatrons" ,"findAptronById"} ,key = "#root.methodName" , allEntries = true)
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
