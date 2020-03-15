package jp.gr.java_conf.ak.akanash.api;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gr.java_conf.ak.akanash.entity.TicketEntity;
import jp.gr.java_conf.ak.akanash.entity.TicketRepository;
import lombok.Data;

@RestController
@RequestMapping(path = "/api/tickets")
@Transactional
public class TicketActions {

    @Data
    public static class CreateTicketParams {
        @NotNull
        private String title;
    }

    @Data
    public static class DeleteTicketParams {
        @NotNull
        private String id;
    }

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping(path = "create-ticket")
    public void createTicket(final Principal principal, @RequestBody @Valid final CreateTicketParams params) {

        final TicketEntity entity = new TicketEntity();
        entity.setId(new UUID(System.currentTimeMillis(), System.nanoTime()).toString());
        entity.setTitle(params.getTitle());
        entity.setStatus("CREATED");
        entity.setCreated_by(principal.getName());
        entity.setCreated_at(LocalDateTime.now());

        this.ticketRepository.save(entity);
    }

    @PostMapping(path = "delete-ticket")
    public void deleteTicket(final Principal pricipal, @RequestBody @Valid final DeleteTicketParams params) {
        try {
            this.ticketRepository.deleteById(params.getId());
        } catch (EmptyResultDataAccessException e) {
            // 
        }
    }
}