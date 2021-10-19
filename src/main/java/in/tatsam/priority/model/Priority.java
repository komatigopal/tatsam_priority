package in.tatsam.priority.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PriorityId.class)
public class Priority {
	@Id
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userEmailId")
	private User user;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "areaId")
	private Area area;

	@Column(nullable = false)
	private int scale;
}
