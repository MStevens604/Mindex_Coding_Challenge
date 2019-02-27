package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compRepository;
    
	@Override
	public Compensation create(Compensation comp) {
		LOG.debug("Compensation created");
		return compRepository.insert(comp);
	}

	/*
	 * Will always return Mongo's first instance of compensation with ID.  Does not handle duplicates. 
	 */
	@Override
	public Compensation read(String id) {
		LOG.debug("Compensation requested");
		return compRepository.findCompByEmployeeEmployeeId(id);
	}

	/*
	 * TODO: Implement update so it handles duplicates
	 */
	@Override
	public Compensation update(Compensation comp) {
		LOG.debug("Somehow update was called - this method is implemented");
		return null;
	}
}
