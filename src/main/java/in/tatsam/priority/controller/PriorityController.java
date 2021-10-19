package in.tatsam.priority.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.tatsam.priority.model.AddPrioritiesRequest;
import in.tatsam.priority.model.Area;
import in.tatsam.priority.model.User;
import in.tatsam.priority.service.PriorityService;
import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@Log4j2
@RestController
@RequestMapping("api/tatsam/priority")
public class PriorityController {

	@Autowired
	PriorityService priorityService;

	@PostMapping("/addPriorities")
	public User addPriorities(@RequestBody AddPrioritiesRequest addPrioritiesRequest) {
		log.info("coming to addPriorities method in controller addPrioritiesRequest - " + addPrioritiesRequest);
		User afterUserSave = new User();
		try {
			afterUserSave = priorityService.addPriorities(addPrioritiesRequest);
		} catch (Exception e) {
			log.error(e);
		}
		return afterUserSave;
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		log.info("coming to addUser method in controller user - " + user);
		User afterUserSave = new User();
		try {
			afterUserSave = priorityService.addUser(user);
		} catch (Exception e) {
			log.error(e);
		}
		return afterUserSave;
	}

	@PostMapping("/addArea")
	public Area addArea(@RequestParam String areaName) {
		log.info("coming to addArea method in controller areaName - " + areaName);
		Area area = new Area();
		try {
			area = priorityService.addArea(areaName);
		} catch (Exception e) {
			log.error(e);
		}
		return area;
	}

	@GetMapping("/getAreas")
	public List<Area> getAreas() {
		log.info("coming to getAres method in controller");
		List<Area> areas = new ArrayList<Area>();
		try {
			areas = priorityService.getAreas();
		} catch (Exception e) {
			log.error(e);
		}
		return areas;
	}
}
