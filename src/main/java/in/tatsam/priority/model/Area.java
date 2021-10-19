package in.tatsam.priority.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Area implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long areaId;
	@Column(unique = true, nullable = false)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Priority> priorities = new ArrayList<>();
}
