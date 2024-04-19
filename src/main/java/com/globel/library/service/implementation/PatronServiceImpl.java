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

	// inject PatronRepo
	@Autowired
	private PatronRepo patronRepo;

	@Override
	@Cacheable(value = "findAllPatrons", key = "#root.methodName") // caching
	public List<Patron> findAll() {
		List<Patron> patrons = patronRepo.findAll();
		if (patrons.isEmpty()) {
			throw new RecordNotFoundException("we not have any patrons");
		}
		return patrons;
	}

	@Override
	@Cacheable(value = "findAptronById", key = "#id") // caching
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
	@CacheEvict(value = { "findAllPatrons", "findAptronById" }, key = "#root.methodName", allEntries = true) // caching
																												// delete
																												// (for
																												// update)
	public Patron insert(Patron entity) {
		return patronRepo.save(entity);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "findAllPatrons", "findAptronById" }, key = "#root.methodName", allEntries = true) // caching
																												// delete
																												// (for
																												// update)
	public Patron update(Patron entity) {
		Patron patron = patronRepo.getById(entity.getId());

		if (patron != null) {
			patron.setName(entity.getName());
			patron.setContactInformation(entity.getContactInformation());
			return patronRepo.save(patron);
		} else {
			throw new RecordNotFoundException("book  data not found");
		}

	}

	@Override
	public void deleteById(Long id) {
		Optional<Patron> entity = patronRepo.findById(id);
		if (entity.isPresent()) {
			patronRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("book with id:- " + id + "  not found to deleted");
		}

	}

}
