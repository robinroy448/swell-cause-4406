package com.bus.services;

import java.util.List;

import com.bus.bean.Route;
import com.bus.exceptions.AdminException;
import com.bus.exceptions.RouteException;

public interface RouteService {

	public Route addRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route updateRoute(Route route,String key) throws RouteException, AdminException;
	
	public Route deleteRoute(int routeId,String key) throws RouteException, AdminException;
	
	public Route viewRoute(int routeId) throws RouteException;
	
	public List<Route> viewAllRoute() throws RouteException;
	
	
}
