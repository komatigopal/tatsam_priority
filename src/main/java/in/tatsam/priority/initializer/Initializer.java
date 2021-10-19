package in.tatsam.priority.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tatsam.priority.model.Area;
import in.tatsam.priority.repository.AreaRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Initializer {

	@Autowired
	private AreaRepository areaRepository;

	public void init() {
		log.info("Starting Initializer..");
		Long count = areaRepository.count();
		log.info("before Initializer level no of areas present in table " + count);

		this.areaSave("Connection");

		this.areaSave("Relationships");

		this.areaSave("Career");

		this.areaSave("Wealth");

		count = areaRepository.count();
		log.info("after Initializer level no of areas present in table " + count);
	}

	private void areaSave(String areaName) {
		Area area = areaRepository.findByName(areaName.trim());
		if (null == area) {
			area = Area.builder().name(areaName).build();
			area = areaRepository.save(area);
		}
	}
}
