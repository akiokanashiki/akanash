package jp.gr.java_conf.ak.akanash.converter;

import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jp.gr.java_conf.ak.akanash.entity.TicketEntity;
import jp.gr.java_conf.ak.akanash.graphql.TicketType;

@Component
public class TicketEntityToTicketTypeConverter implements Converter<TicketEntity, TicketType> {

    @Override
    public TicketType convert(final TicketEntity source) {

        final TicketType target = new TicketType();

        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setStatus(source.getStatus());
        target.setCreated_by(source.getCreated_by());
        target.setCreated_at(source.getCreated_at().format(DateTimeFormatter.ISO_DATE_TIME));

        return target;
    }
}