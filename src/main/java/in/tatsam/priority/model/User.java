package in.tatsam.priority.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
	@Id
	private String emailId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(unique = true, nullable = false)
	private long mobile;

	@Column(nullable = false)
	private String profesion;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Priority> priorities = new ArrayList<>();
}
