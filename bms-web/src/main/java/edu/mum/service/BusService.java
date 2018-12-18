package edu.mum.service;

import edu.mum.domain.Bus;

public interface BusService extends BaseService<Bus> {
	Long saveBus(Bus bus);
}
