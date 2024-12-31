package com.gas.edu.qdbs.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class IncomingMessageReply {
    Long id;
    String message;
}
