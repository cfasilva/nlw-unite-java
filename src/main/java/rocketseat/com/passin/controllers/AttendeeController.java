package rocketseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.passin.services.AttendeeService;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping("/{attendeeId}/badge")
    public ResponseEntity<AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String attendeeId, UriComponentsBuilder uriBuilder) {
        AttendeeBadgeResponseDTO response = this.attendeeService.getAttendeeBadge(attendeeId, uriBuilder);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{attendeeId}/check-in")
    public ResponseEntity registerCheckIn(@PathVariable String attendeeId, UriComponentsBuilder uriBuilder) {
        this.attendeeService.checkInAttendee(attendeeId);

        var uri = uriBuilder
                .path("/attendees/{attendee}/badge")
                .buildAndExpand(attendeeId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
