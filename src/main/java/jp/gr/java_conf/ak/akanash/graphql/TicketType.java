package jp.gr.java_conf.ak.akanash.graphql;

import lombok.Data;

@Data
public class TicketType {
    private String id;
    private String title;
    private String status;
    private String created_by;
    private String created_at;
}