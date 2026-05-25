package com.tsk.entityDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskDTO {
	
	@NotBlank(message = "title is required")
	private String title;
	private String description;

}
