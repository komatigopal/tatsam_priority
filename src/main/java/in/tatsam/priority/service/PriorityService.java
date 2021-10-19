package in.tatsam.priority.service;

import java.util.List;

import in.tatsam.priority.model.AddPrioritiesRequest;
import in.tatsam.priority.model.Area;
import in.tatsam.priority.model.User;

public interface PriorityService {
	public List<Area> getAreas();

	public Area addArea(String areaName);

	public User addUser(User user);

	public User addPriorities(AddPrioritiesRequest addPrioritiesRequest);
}
