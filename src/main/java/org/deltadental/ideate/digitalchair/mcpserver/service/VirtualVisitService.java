package org.deltadental.ideate.digitalchair.mcpserver.service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class VirtualVisitService {

    private static final Logger logger = LoggerFactory.getLogger(VirtualVisitService.class);

    @PostConstruct
    public void init() {
        logger.info("VirtualVisitService initialized");
    }

    @Tool(
            name = "virtual-visit-schedule",
            description = """
            Schedule a virtual dental visit for a patient.
            Parameters:
              - patientId (string): unique patient identifier
              - preferredTime (string): requested appointment time (ISO-8601)
              - reason (string): reason for visit
            Returns: JSON confirmation with visitId and status
            """
    )
    public Map<String, Object> scheduleVirtualVisit(
            @ToolParam(description = "Unique patient identifier") String patientId,
            @ToolParam(description = "Requested appointment time (ISO-8601)") String preferredTime,
            @ToolParam(description = "Reason for the visit") String reason
    ) {
        logger.info("Scheduling virtual visit for patient {} at {} (reason: {})",
                patientId, preferredTime, reason);

        // In real life, you'd call an internal scheduling service here
        String visitId = "visit-" + patientId + "-" + System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("visitId", visitId);
        response.put("patientId", patientId);
        response.put("scheduledTime", preferredTime);
        response.put("reason", reason);
        response.put("status", "confirmed");
        response.put("createdAt", Instant.now().toString());

        return response;
    }
}
