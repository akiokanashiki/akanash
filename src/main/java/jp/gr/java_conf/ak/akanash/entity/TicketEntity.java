package jp.gr.java_conf.ak.akanash.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity(name="Ticket")
@Table(name="tbl_ticket")
@Data
public class TicketEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Version
    @Column(name = "version")
    private long version;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String created_by;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
}