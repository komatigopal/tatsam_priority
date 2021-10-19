package in.tatsam.priority.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tatsam.priority.model.AddPrioritiesRequest;
import in.tatsam.priority.model.Area;
import in.tatsam.priority.model.Priority;
import in.tatsam.priority.model.User;
import in.tatsam.priority.repository.AreaRepository;
import in.tatsam.priority.repository.PriorityRepository;
import in.tatsam.priority.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PriorityRepository priorityRepository;

	public List<Area> getAreas() {
		log.info("coming to getAreas in service layer");
		List<Area> areas = new ArrayList<Area>();
		try {
			areas = areaRepository.findAll();
		} catch (Exception e) {
			log.error(e);
		}
		return areas;
	}

	public Area addArea(String areaName) {
		log.info("coming to addArea method in service areaName - " + areaName);
		Area area = new Area();
		try {
			area.setName(areaName);
			area = areaRepository.save(area);
		} catch (Exception e) {
			log.error(e);
		}
		return area;
	}

	public User addUser(User user) {
		log.info("coming to addUser method in service user - " + user);
		User user1 = userRepository.findByEmailId(user.getEmailId());
		user.setEmailId(user1.getEmailId());
		User afterUserSave = new User();
		try {
			afterUserSave = userRepository.save(user);
			afterUserSave = userRepository.findByEmailId(user.getEmailId());
		} catch (Exception e) {
			log.error(e);
		}
		return afterUserSave;
	}

	public User addPriorities(AddPrioritiesRequest addPrioritiesRequest) {
		log.info("coming to addPriorities method in service addPrioritiesRequest - " + addPrioritiesRequest);
		User user = userRepository.findByEmailId(addPrioritiesRequest.getEmailId());
		for (Priority priority : addPrioritiesRequest.getPriorities()) {
			priority.setUser(user);
			user.getPriorities().add(priority);
		}
		User afterUserSave = new User();
		try {
			afterUserSave = userRepository.save(user);
		} catch (Exception e) {
			log.error(e);
		}
		return afterUserSave;
	}
}
