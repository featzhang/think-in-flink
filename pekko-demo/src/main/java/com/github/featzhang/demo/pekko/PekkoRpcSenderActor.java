package com.github.featzhang.demo.pekko;

import org.apache.pekko.actor.AbstractActor;
import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.japi.pf.ReceiveBuilder;

public class PekkoRpcSenderActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return ReceiveBuilder.create()
        .match(PekkoData.class, this::handleMessage)
        .build();
  }

  private void handleMessage(final PekkoData message) {
    // 获取发送者的actorRef
    ActorRef sender = getSender();
    // 打印收到的消息
    System.out.println(String.format("%s 接收到消息: %s", sender, message.getContent()));
  }

}
