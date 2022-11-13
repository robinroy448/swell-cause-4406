package com.bus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.bean.Route;
@Repository
public interface RouteDao extends JpaRepository<Route, Integer>{

	public Route findByRouteFromAndRouteTo(String from,String to);
}
