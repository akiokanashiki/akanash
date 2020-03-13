package jp.gr.java_conf.ak.akanash.graphql;

import java.time.LocalDateTime;
import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import jp.gr.java_conf.ak.akanash.entity.TicketEntity;
import jp.gr.java_conf.ak.akanash.entity.TicketRepository;
import jp.gr.java_conf.ak.akanash.security.CurrentUser;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConversionService converteService;

    @Autowired
    private ApplicationContext ApplicationContext;
    
    public TicketType createTicket(final String title) {

        final CurrentUser user = this.ApplicationContext.getBean(CurrentUser.class);

        final TicketEntity entity = new TicketEntity();
        entity.setId(new UUID(System.nanoTime(), System.nanoTime()).toString());
        entity.setTitle(title);
        entity.setStatus("CREATED");
        entity.setCreated_by(user.getUsername());
        entity.setCreated_at(LocalDateTime.now());

        this.ticketRepository.save(entity);
        return this.converteService.convert(entity, TicketType.class);
    }

    public TicketType deleteTicket(final String id) {

        final TicketEntity entity = this.ticketRepository.findById(id).orElse(null);
        return this.converteService.convert(entity, TicketType.class);
    }
}