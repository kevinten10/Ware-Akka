package com.ten.wara.akka.actor.kvdb;

import lombok.Data;

@Data
public class SetRequest {
    private final String key;
    private final Object value;
}
