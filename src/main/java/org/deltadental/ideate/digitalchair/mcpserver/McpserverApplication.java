package org.deltadental.ideate.digitalchair.mcpserver;

import org.deltadental.ideate.digitalchair.mcpserver.service.VirtualVisitService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpserverApplication.class, args);
	}

	@Bean
	public List<ToolCallback> alexTools(VirtualVisitService virtualVisitService){
		return List.of(ToolCallbacks.from(virtualVisitService));
	}
}
