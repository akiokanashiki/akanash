package jp.gr.java_conf.ak.akanash.graphql;

import java.util.List;
import java.util.stream.Collectors;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import jp.gr.java_conf.ak.akanash.entity.TicketRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConversionService converteService;

    public List<TicketType> tickets() {
        return this.ticketRepository.findAll().stream().map(e -> this.converteService.convert(e, TicketType.class))
                .collect(Collectors.toList());
    }
}