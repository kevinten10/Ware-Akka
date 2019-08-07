package com.ten.wara.akka.actor.kvdb;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class AkkaKvDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> cache = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(SetRequest.class, message -> {
                    log.info("Receive Set request: {}", message);
                    cache.put(message.getKey(), message.getValue());
                })
                .matchAny(o -> log.info("receive unknown message: {}", o))
                .build();
    }
}
