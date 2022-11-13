package com.bus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.Repo.AdminSessionDao;
import com.bus.Repo.BusDao;
import com.bus.Repo.RouteDao;
import com.bus.bean.Bus;
import com.bus.bean.CurrentAdminSession;
import com.bus.bean.Route;
import com.bus.exceptions.AdminException;
import com.bus.exceptions.BusException;

@Service
public class BusServiceImplementation implements BusService{
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public Bus addBus(Bus bus,String key) throws BusException, AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to add bus!");
		}
		
		Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
		
		if(route != null) {
			route.getBusList().add(bus);
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus detail is not correct");
	}

	@Override
	public Bus updateBus(Bus bus,String key) throws BusException, AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to update bus!");
		}
		
		Optional<Bus> existingBusOpt=busDao.findById(bus.getBusId());
		
		if(existingBusOpt.isPresent()) {
			
			Bus existingBus = existingBusOpt.get();
			
			if(existingBus.getAvailableSeats()!=existingBus.getSeats()) throw new BusException("Cannot update already scheduled bus!");
			
			Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
			if(route == null) throw new BusException("Invalid route!");
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+ bus.getBusId());

	}

	@Override
	public Bus deleteBus(Integer busId,String key) throws BusException, AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to delete bus!");
		}
		
		Optional<Bus> bus=busDao.findById(busId);
		
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();					
			
			busDao.delete(existingBus);
			
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
		
	}

	@Override
	public List<Bus> viewBusByType(String BusType) throws BusException {
		List<Bus> listOfBusType = busDao.findByBusType(BusType);
		
		if(listOfBusType.size() >0)
			return listOfBusType;
		else
			throw new BusException("There is no bus of type "+ BusType);
	
	}

	@Override
	public List<Bus> viewAllBuses() throws BusException {
		
		List<Bus> buses= busDao.findAll();
		if(buses.size()>0)
			return buses;
		else
			throw new BusException("There is no bus availabe now");

	}

	@Override
	public Bus viewBus(Integer busId) throws BusException {
		Optional<Bus> bus=busDao.findById(busId);
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
	}
	
}
