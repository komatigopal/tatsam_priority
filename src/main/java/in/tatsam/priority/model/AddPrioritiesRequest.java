package in.tatsam.priority.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPrioritiesRequest {
	private String emailId;
	private List<Priority> Priorities;
}
